package com.anuradha.aws.sns.demo1.service.impl;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;
import com.anuradha.aws.sns.demo1.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class SNSServiceImpl {

    private AmazonSNS sns;

    private String topicArn = "arn:aws:sns:ap-southeast-1:372810632012:MyNewTopicEmail4";

    public SNSServiceImpl() {

        //create a new SNS client and set endpoint
        ClientConfiguration cfg = new ClientConfiguration();

        sns = AmazonSNSClient.builder()
                .withRegion(Regions.AP_SOUTHEAST_1)
                .withClientConfiguration(cfg)
                .withCredentials(new ProfileCredentialsProvider())
                .build();
    }

    public void createSNSClient() {


//        ClasspathPropertiesFileCredentialsProvider

        //create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest("MyNewTopicEmail5");
        CreateTopicResult createTopicResult = sns.createTopic(createTopicRequest);
        //print TopicArn

        this.topicArn = createTopicResult.getTopicArn();


        System.out.println("topicArn : " + createTopicResult.getTopicArn());

        //get request id for CreateTopicRequest from SNS metadata
        System.out.println("CreateTopicRequest - " + sns.getCachedResponseMetadata(createTopicRequest));

    }

    public void subscribeToATopic() {

        System.out.println("\n\n" + topicArn + "\n\n");
        System.out.println("\n\n" + sns + "\n\n");

        //subscribe to an SNS topic
        SubscribeRequest subRequest = new SubscribeRequest(topicArn, "email", "anuranasinghe151@gmail.com");
        sns.subscribe(subRequest);

        //get request id for SubscribeRequest from SNS metadata
        System.out.println("SubscribeRequest - " + sns.getCachedResponseMetadata(subRequest));
        System.out.println("Check your email and confirm subscription.");
    }

    public void deleteTopic() {
        //delete an SNS topic
        DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
        sns.deleteTopic(deleteTopicRequest);

        //get request id for DeleteTopicRequest from SNS metadata
        System.out.println("DeleteTopicRequest - " + sns.getCachedResponseMetadata(deleteTopicRequest));
    }

    public void publish(Notification notification) {

        //publish to an SNS topic
        PublishRequest publishRequest = new PublishRequest(topicArn, notification.getBody(), notification.getSubject());
        PublishResult publishResult = sns.publish(publishRequest);

        //print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());
    }

}
