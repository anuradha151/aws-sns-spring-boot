package com.anuradha.aws.sns.demo1.controller;

import com.anuradha.aws.sns.demo1.model.Notification;
import com.anuradha.aws.sns.demo1.service.impl.SNSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sns/notification")
public class NotificationController {
    @Autowired
    private SNSServiceImpl snsService;

    @PostMapping("/publish")
    public boolean publishMessage(@RequestBody Notification notification) {

        return false;
    }

    @GetMapping("/create")
    public boolean createSNSClient() {
        snsService.createSNSClient();
        return true;

    }

    @GetMapping("/subscribe")
    public boolean subscribeTopic() {
        snsService.subscribeToATopic();
        return true;

    }
    @GetMapping("/deleteTopic")
    public boolean deleteTopic() {
        snsService.deleteTopic();
        return true;

    }


}










