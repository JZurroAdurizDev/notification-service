package com.jabierzurro.notificationservice.service;

import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;

/**
 *
 * @author Jabier Zurro Aduriz
 */
public interface NotificationService {
    void processLoanCreatedEvent(LoanCreatedEvent event);
}
