package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.sms.SmsApi;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public String sendSms(String message, String phoneNumberToSent){
        String response = SmsApi.excutePost(message,phoneNumberToSent);
        return response;
    }

}
