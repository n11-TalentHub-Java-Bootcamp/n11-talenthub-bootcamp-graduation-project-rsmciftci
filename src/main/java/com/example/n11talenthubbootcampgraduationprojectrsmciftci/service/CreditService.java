package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CreditMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CreditDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.SalaryNotMatchException;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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
//TODO:DTO'da validasyonu yap
    //TODO:kredi sonucu ve limiti dönmesi grekiyor
    public void saveCreditApplicationIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(@RequestBody @Valid CreditApplicationDto creditApplicationDto) {

        String turkishIdentityNumber = creditApplicationDto.getTurkishIdentityNumber();
        LocalDate dateOfBirth = creditApplicationDto.getDateOfBirth();
        BigDecimal pledgeValue = creditApplicationDto.getPledgeValue();
        BigDecimal customerMonthlySalaryFromDto = creditApplicationDto.getMonthlySalary();
        int creditScore = creditScoreService.getCreditScore(turkishIdentityNumber);
        CreditResultEnum creditResultEnum = creditScoreService.getCreditScoreEnum(turkishIdentityNumber);

        Optional<Customer> customerOptional = customerDao.findCustomerByTurkishIdentityNumber(turkishIdentityNumber); //TODO: bu sorguya dateOfBirth'te mi koysak

        if(customerOptional.isPresent()){

            Customer customer = customerOptional.get();
            BigDecimal customerMonthlySalaryFromDB = customer.getMonthlySalary();

            if(customerMonthlySalaryFromDB.compareTo(customerMonthlySalaryFromDto) == 0){

                CreditProducedInFactory creditProducedInFactory = CreditFactory.getCredit(creditScore,creditResultEnum,customer,pledgeValue);
                Credit credit = CreditMapper.INSTANCE.convertCreditProducedFactoryToCredit(creditProducedInFactory);

                creditDao.save(credit);
                //TODO:SMS gönder
                //TODO:kredi sonucu ve limiti dönmesi grekiyor


            }else{
                throw new SalaryNotMatchException("Salary in the request and database are not identical. If salary of customer has changed, update it first.");
            }


        }else{
            //TODO: save customer first then credit
            //TODO:SMS gönder
            //TODO:kredi sonucu ve limiti dönmesi grekiyor
        }


    }
}
