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
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.PhoneNumbersNotMatchException;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.SalaryNotMatchException;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public CreditApplicationResultDto saveCreditApplicationAndSendSMSIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(CreditApplicationDto creditApplicationDto) {

        String turkishIdentityNumber = creditApplicationDto.getTurkishIdentityNumber();
        BigDecimal pledgeValue = creditApplicationDto.getPledgeValue();
        int creditScore = creditScoreService.getCreditScore(turkishIdentityNumber);
        CreditResultEnum creditResultEnum = creditScoreService.getCreditScoreEnum(turkishIdentityNumber);

        Optional<Customer> customerOptional = customerDao.findCustomerByTurkishIdentityNumber(turkishIdentityNumber);
        if(customerOptional.isPresent()){

            Customer customer = customerOptional.get();

            if(customer.getDateOfBirth().compareTo(creditApplicationDto.getDateOfBirth()) != 0) {
                throw new SalaryNotMatchException("Salary in the request and database are not identical. If salary of customer has changed, update it first.");
            }
            if(!customer.getPhoneNumber().equals(creditApplicationDto.getPhoneNumber())){
               throw new PhoneNumbersNotMatchException("Phone numbers in the request and database are not identical. If phone number of customer has changed, update it first.");
            }

            CreditProducedInFactory creditProducedInFactory = CreditFactory.getCredit(creditScore,creditResultEnum,customer,pledgeValue);
            Credit credit = CreditMapper.INSTANCE.convertCreditProducedFactoryToCredit(creditProducedInFactory);
            creditDao.save(credit);
            //TODO:SMS gönder

            CreditApplicationResultDto creditApplicationResultDto = CreditMapper.INSTANCE.convertCreditToCreditApplicationResultDto(credit);
            return creditApplicationResultDto;



        }else{

            Customer customer = CustomerMapper.INSTANCE.convertCreditApplicationDtoToCustomer(creditApplicationDto);
            customerDao.save(customer);

            CreditProducedInFactory creditProducedInFactory = CreditFactory.getCredit(creditScore,creditResultEnum,customer,pledgeValue);
            Credit credit = CreditMapper.INSTANCE.convertCreditProducedFactoryToCredit(creditProducedInFactory);
            creditDao.save(credit);
            //TODO:SMS gönder

            CreditApplicationResultDto creditApplicationResultDto = CreditMapper.INSTANCE.convertCreditToCreditApplicationResultDto(credit);
            return creditApplicationResultDto;



        }


    }

    public ResponseEntity findCreditApplication(String turkishIdentityNumber, LocalDate dateOfBirth) {

        Optional<Credit> optionalCredit = creditDao.findCreditApplication(turkishIdentityNumber, dateOfBirth);
        if(optionalCredit.isPresent()){
            Credit credit = optionalCredit.get();
            CreditApplicationResultDto creditApplicationResultDto = CreditMapper.INSTANCE.convertCreditToCreditApplicationResultDto(credit);
            return ResponseEntity.ok(creditApplicationResultDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turkish identity number and date of birth didn't match!\n" +
                    "Or Credit application hasn't been found!");
        }

    }


}
