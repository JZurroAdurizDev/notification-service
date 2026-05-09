package com.jabierzurro.notificationservice.service;

import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;

/**
 * Service responsible for notification-related business operations.
 *
 * @author Jabier Zurro Aduriz
 */
public interface NotificationService {

    /**
     * Processes a loan creation event and stores the generated notification log.
     *
     * @param event loan creation event received from Kafka
     */
    void processLoanCreatedEvent(LoanCreatedEvent event);
}