package com.anuradha.aws.sns.demo1.repository;

import com.anuradha.aws.sns.demo1.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
