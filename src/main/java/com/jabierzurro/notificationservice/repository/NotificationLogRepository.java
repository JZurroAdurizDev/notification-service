package com.jabierzurro.notificationservice.repository;

import com.jabierzurro.notificationservice.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jabier Zurro Aduriz
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    
}
