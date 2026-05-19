package com.jabierzurro.notificationservice.service;

import com.jabierzurro.notificationservice.event.dto.LoanClosedEvent;
import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import com.jabierzurro.notificationservice.event.dto.LoanUpdatedEvent;

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

   /**
    * Processes a loan update event and stores the generated notification log.
    *
    * @param event loan update event received from Kafka
    */
   void processLoanUpdatedEvent(LoanUpdatedEvent event);

   /**
    * Processes a loan closure event and stores the generated notification log.
    *
    * @param event loan closure event received from Kafka
    */
   void processLoanClosedEvent(LoanClosedEvent event);
}