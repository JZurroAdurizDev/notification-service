package com.jabierzurro.notificationservice.service;

import com.jabierzurro.notificationservice.entity.NotificationLog;
import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import com.jabierzurro.notificationservice.repository.NotificationLogRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jabier Zurro Aduriz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationLogRepository notificationLogRepository;

    @Override
    public void processLoanCreatedEvent(LoanCreatedEvent event) {

        String bookTitles = String.join(", ", event.bookTitles());
        String message = buildEmailMessage(event);

        log.info(
                "Simulated email sent to {} for loanId={}",
                event.userEmail(),
                event.loanId()
        );

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setLoanId(event.loanId());
        notificationLog.setUserId(event.userId());
        notificationLog.setUserEmail(event.userEmail());
        notificationLog.setBookTitles(bookTitles);
        notificationLog.setMessage(message);
        notificationLog.setCreatedAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);
    }
    
    private static String buildEmailMessage(LoanCreatedEvent event) {
        return String.format(
                """
                Hello %s,

                Your loan has been created successfully.

                Loan ID: %d
                Books: %s
                Start date: %s
                Due date: %s

                Thank you for using our library service.
                """,
                event.userEmail(),
                event.loanId(),
                String.join(", ", event.bookTitles()),
                event.startDate(),
                event.dueDate()
        );
    }
}