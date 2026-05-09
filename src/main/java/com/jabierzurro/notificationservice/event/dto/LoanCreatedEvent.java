package com.jabierzurro.notificationservice.event.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO representing a loan creation event transferred through Kafka.
 *
 * <p>This event is published by library-api and consumed by notification-service
 * to simulate notification delivery asynchronously.
 *
 * @param loanId identifier of the created loan
 * @param userId identifier of the user who created the loan
 * @param userEmail email address of the user
 * @param bookTitles titles of the books included in the loan
 * @param startDate loan start date
 * @param dueDate loan due date
 * @param timestamp event creation timestamp
 *
 * @author Jabier Zurro Aduriz
 */
public record LoanCreatedEvent(
        Integer loanId,
        Integer userId,
        String userEmail,
        List<String> bookTitles,
        LocalDate startDate,
        LocalDate dueDate,
        LocalDateTime timestamp
) {
}