package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CreditMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CustomerMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CreditDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CreditService {

    private CreditDao creditDao;
    private CustomerDao customerDao;
    private CreditScoreService creditScoreService;
    private SmsService smsService;

    public ResponseEntity saveCredit(CreditApplicationDto creditApplicationDto) {

        String turkishIdentityNumber = creditApplicationDto.getTurkishIdentityNumber();
        Optional<Customer> customerOptional = customerDao.findCustomerByTurkishIdentityNumber(turkishIdentityNumber);

        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();

            BigDecimal monthlySalaryFromDto = creditApplicationDto.getMonthlySalary();
            if(monthlySalaryFromDto.compareTo(customer.getMonthlySalary()) != 0){
                throw new RuntimeException("Salary didn't match with salary value in database.");
            }

            int creditScore = creditScoreService.getCreditScore(turkishIdentityNumber);
            CreditResultEnum creditResultEnum = creditScoreService.getCreditScoreEnum(turkishIdentityNumber);
            BigDecimal pledgeValue = creditApplicationDto.getPledgeValue();

            CreditProducedInFactory creditProducedInFactory = CreditFactory.getCredit(creditScore,creditResultEnum,customer,pledgeValue);
            Credit credit = CreditMapper.INSTANCE.convertCreditProducedFactoryToCredit(creditProducedInFactory);
            creditDao.save(credit);

            CreditApplicationResultDto creditApplicationResultDto = CreditMapper.INSTANCE.convertCreditToCreditApplicationResultDto(credit);
            String message = "TEST MESSAGE.\n"+"CREDIT "+credit.getCreditResultEnum()+".\nCredit Limit is "+ credit.getCreditLimit()+" TL.";
            // TODO: sms'i aktive et
            //smsService.sendSms(message,customer.getPhoneNumber().substring(1));
            return ResponseEntity.ok(creditApplicationResultDto);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
    }

    public ResponseEntity findCreditApplication(String turkishIdentityNumber, String dateOfBirthString) {
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);

        Optional<Credit> optionalCredit = creditDao.findCreditApplication(turkishIdentityNumber, dateOfBirth);
        if(optionalCredit.isPresent()){
            Credit credit = optionalCredit.get();
            CreditApplicationResultDto creditApplicationResultDto = CreditMapper.INSTANCE.convertCreditToCreditApplicationResultDto(credit);
            return ResponseEntity.ok(creditApplicationResultDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turkish identity number and date of birth didn't match!" +
                    " Or Credit application hasn't been found!");
        }

    }


}
