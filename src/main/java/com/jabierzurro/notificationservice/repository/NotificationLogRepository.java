package com.jabierzurro.notificationservice.repository;

import com.jabierzurro.notificationservice.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsible for notification log persistence operations.
 *
 * <p>Provides CRUD operations for {@link NotificationLog} through Spring Data JPA.
 *
 * @author Jabier Zurro Aduriz
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}