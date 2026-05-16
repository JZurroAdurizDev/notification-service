package com.jabierzurro.notificationservice.service;

import com.jabierzurro.notificationservice.entity.NotificationLog;
import com.jabierzurro.notificationservice.event.dto.LoanClosedEvent;
import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import com.jabierzurro.notificationservice.event.dto.LoanUpdatedEvent;
import com.jabierzurro.notificationservice.repository.NotificationLogRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service implementation responsible for processing notification events.
 *
 * <p>This service simulates email notification delivery and persists
 * notification logs in the database.
 *
 * @author Jabier Zurro Aduriz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationLogRepository notificationLogRepository;

    /**
     * Processes a loan creation event received from Kafka.
     *
     * <p>The method generates a simulated email message, stores the relevant
     * notification data and persists a {@link NotificationLog} entry.
     *
     * @param event loan creation event received from Kafka
     */
    @Override
    public void processLoanCreatedEvent(LoanCreatedEvent event) {

        String bookTitles = String.join(", ", event.bookTitles());
        String message = buildEmailMessage(
            event.userEmail(),
            String.format(
                """
                Your loan has been created successfully.

                Loan ID: %d
                Books: %s
                Start date: %s
                Due date: %s
                """,
                event.loanId(),
                String.join(", ", event.bookTitles()),
                event.startDate(),
                event.dueDate()
            )
        );

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
        notificationLog.setNotificationType("LOAN_CREATED");
        notificationLog.setMessage(message);
        notificationLog.setCreatedAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);
    }

    @Override
    public void processLoanUpdatedEvent(LoanUpdatedEvent event) {
        String message = buildEmailMessage(
            event.userEmail(),
            String.format(
                    """
                    Your loan dates have been updated successfully.

                    Loan ID: %d
                    Previous start date: %s
                    Previous due date: %s
                    New start date: %s
                    New due date: %s
                    """,
                    event.loanId(),
                    event.previousStartDate(),
                    event.previousDueDate(),
                    event.newStartDate(),
                    event.newDueDate()
            )
        );

        log.info(
                "Simulated update notification sent to {} for loanId={}",
                event.userEmail(),
                event.loanId()
        );

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setLoanId(event.loanId());
        notificationLog.setUserId(event.userId());
        notificationLog.setUserEmail(event.userEmail());
        notificationLog.setBookTitles("N/A");
        notificationLog.setNotificationType("LOAN_UPDATED");
        notificationLog.setMessage(message);
        notificationLog.setCreatedAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);
    }

    @Override
    public void processLoanClosedEvent(LoanClosedEvent event) {
        String message = buildEmailMessage(
            event.userEmail(),
            String.format(
                    """
                    Your loan has been closed successfully.

                    Loan ID: %d
                    Closed at: %s
                    """,
                    event.loanId(),
                    event.closedAt()
            )
        );

        log.info(
                "Simulated closure notification sent to {} for loanId={}",
                event.userEmail(),
                event.loanId()
        );

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setLoanId(event.loanId());
        notificationLog.setUserId(event.userId());
        notificationLog.setUserEmail(event.userEmail());
        notificationLog.setBookTitles("N/A");
        notificationLog.setNotificationType("LOAN_CLOSED");
        notificationLog.setMessage(message);
        notificationLog.setCreatedAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);
    }
    
    /**
     * Builds the simulated email message for a loan creation event.
     *
     * @param event loan creation event
     * @return formatted simulated email message
     */
    private static String buildEmailMessage(String userEmail, String body) {
        return String.format(
                """
                Hello %s,

                %s

                Thank you for using our library service.
                """,
                userEmail,
                body
        );
    }
}