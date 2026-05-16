package com.jabierzurro.notificationservice.event.dto;

import java.time.LocalDateTime;

/**
 * DTO representing a loan closure event transferred through Kafka.
 *
 * <p>This event is published by library-api and consumed by notification-service
 * to simulate notification delivery asynchronously.
 *
 * @param loanId identifier of the closed loan
 * @param userId identifier of the user associated with the loan
 * @param userEmail email address of the user
 * @param closedAt loan closure timestamp
 * @param timestamp event creation timestamp
 *
 * @author Jabier Zurro Aduriz
 */
public record LoanClosedEvent(
        Integer loanId,
        Integer userId,
        String userEmail,
        LocalDateTime closedAt,
        LocalDateTime timestamp
) {
}