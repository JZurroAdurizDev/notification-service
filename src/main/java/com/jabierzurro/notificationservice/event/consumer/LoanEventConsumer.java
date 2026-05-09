package com.jabierzurro.notificationservice.event.consumer;

import com.jabierzurro.notificationservice.event.dto.LoanCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jabier Zurro Aduriz
 */
@Service
@Slf4j
public class LoanEventConsumer {

    @KafkaListener(
            topics = "loan-events",
            groupId = "notification-service"
    )
    public void consumeLoanCreatedEvent(LoanCreatedEvent event) {

        log.info(
                "Received LoanCreatedEvent for loanId={}",
                event.loanId()
        );
    }
}