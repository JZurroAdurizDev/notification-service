package com.jabierzurro.notificationservice.event.dto;

import java.time.LocalDateTime;

/**
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
