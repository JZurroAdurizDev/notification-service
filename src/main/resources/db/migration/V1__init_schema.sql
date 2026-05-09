-- V1__init_schema.sql
-- Schema for notification-service (MySQL 8+)

-- IMPORTANT:
-- This migration should NOT create the database or users.
-- It assumes the schema/database already exists and is selected.

-- -------------------------
-- NOTIFICATION_LOGS
-- -------------------------
CREATE TABLE IF NOT EXISTS notification_logs (
    id           BIGINT NOT NULL AUTO_INCREMENT,
    loan_id      INT NOT NULL,
    user_id      INT NOT NULL,
    user_email   VARCHAR(255) NOT NULL,
    book_titles  TEXT NOT NULL,
    message      TEXT NOT NULL,
    created_at   DATETIME NOT NULL,

    PRIMARY KEY (id),

    KEY ix_notification_logs_loan_id (loan_id),
    KEY ix_notification_logs_user_id (user_id),
    KEY ix_notification_logs_created_at (created_at)
) ENGINE=InnoDB;