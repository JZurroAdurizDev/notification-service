package com.jabierzurro.notificationservice.event.consumer;

import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import com.jabierzurro.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka consumer responsible for receiving loan-related events from library-api.
 *
 * <p>The consumer receives events from Kafka and delegates notification
 * processing to the service layer.
 *
 * @author Jabier Zurro Aduriz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoanEventConsumer {

    private final NotificationService notificationService;

    /**
     * Consumes loan creation events published to Kafka.
     *
     * @param event loan creation event received from Kafka
     */
    @KafkaListener(
            topics = "loan-events",
            groupId = "notification-service"
    )
    public void consumeLoanCreatedEvent(LoanCreatedEvent event) {

        log.info(
                "Received LoanCreatedEvent for loanId={}",
                event.loanId()
        );

        notificationService.processLoanCreatedEvent(event);
    }
}