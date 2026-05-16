package com.jabierzurro.notificationservice.event.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO representing a loan update event transferred through Kafka.
 *
 * <p>This event is published by library-api and consumed by notification-service
 * to simulate notification delivery asynchronously.
 *
 * @param loanId identifier of the updated loan
 * @param userId identifier of the user associated with the loan
 * @param userEmail email address of the user
 * @param previousStartDate previous loan start date
 * @param previousDueDate previous loan due date
 * @param newStartDate updated loan start date
 * @param newDueDate updated loan due date
 * @param timestamp event creation timestamp
 *
 * @author Jabier Zurro Aduriz
 */
public record LoanUpdatedEvent(
        Integer loanId,
        Integer userId,
        String userEmail,
        LocalDate previousStartDate,
        LocalDate previousDueDate,
        LocalDate newStartDate,
        LocalDate newDueDate,
        LocalDateTime timestamp
) {
}