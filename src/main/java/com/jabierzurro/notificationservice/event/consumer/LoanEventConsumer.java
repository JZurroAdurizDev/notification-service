package com.jabierzurro.notificationservice.event.consumer;

import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import com.jabierzurro.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jabier Zurro Aduriz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoanEventConsumer {

    private final NotificationService notificationService;

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