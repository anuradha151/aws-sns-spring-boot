package com.anuradha.aws.sns.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long not_id;
    private String subject;
    private String body;

    public Notification() {
    }

    public Notification(int not_id, String subject, String body) {
        this.setNot_id(not_id);
        this.setSubject(subject);
        this.setBody(body);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "not_id=" + getNot_id() +
                ", subject='" + getSubject() + '\'' +
                ", body='" + getBody() + '\'' +
                '}';
    }

    public long getNot_id() {
        return not_id;
    }

    public void setNot_id(long not_id) {
        this.not_id = not_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
