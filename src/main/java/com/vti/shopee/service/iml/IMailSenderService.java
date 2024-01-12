package com.vti.shopee.service.iml;

import org.springframework.stereotype.Service;


public interface IMailSenderService {

        void sendSimpleMessage(String to, String subject, String text);

        void sendMessageWithAttachment(String to, String subject, String text);

}
