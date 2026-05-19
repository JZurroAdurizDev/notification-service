package com.jabierzurro.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the notification-service application.
 *
 * <p>This microservice consumes Kafka events published by library-api,
 * simulates notification delivery and stores notification logs.
 *
 * @author Jabier Zurro Aduriz
 */
@SpringBootApplication
public class NotificationServiceApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args application startup arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}