package com.jabierzurro.notificationservice.event.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
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
