# Notification Service

Microservice responsible for consuming loan-related events from Apache Kafka and managing notification logs.

This project is part of the library-api ecosystem and follows an event-driven architecture approach.

---

## Tech stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring for Apache Kafka
- Apache Kafka
- MySQL
- Flyway
- Maven

---

## Architecture overview

The notification-service acts as an asynchronous consumer microservice.

Current architecture:

```text
library-api → Kafka → notification-service
```

Main responsibilities:

- Consume `LoanCreatedEvent` messages from Kafka
- Simulate email notification delivery
- Persist notification logs in an independent database
- Process asynchronous event-driven workflows
- Maintain loose coupling with the main API

---

## Event flow

```text
library-api
    ↓
Kafka topic (loan-events)
    ↓
notification-service consumer
    ↓
NotificationService
    ↓
notification_logs persistence
```

---

## Database

The microservice uses an independent MySQL database:

```text
notification_db
```

Database schema management is handled using Flyway migrations.

Initial migration:

```text
src/main/resources/db/migration/V1__init_schema.sql
```

---

## Local setup

Copy the example configuration files:

```bash
cp src/main/resources/application.properties.example \
   src/main/resources/application.properties
```

```bash
cp sql/setup_local.sql.example sql/setup_local.sql
```

Adjust local credentials if needed.

Execute the SQL setup script manually in MySQL before starting the application.

---

## Project status

✅ Functional microservice implementation completed

Currently implemented:

- Kafka consumer integration
- LoanCreatedEvent deserialization
- Notification event processing workflow
- Simulated email notification generation
- Notification log persistence
- Flyway database migrations
- JPA persistence layer
- Layered architecture implementation
- Javadoc documentation
- Git workflow with feature branches and Pull Requests

---

## Future improvements

Possible future extensions:

- LoanUpdatedEvent support
- LoanCancelledEvent support
- Real email provider integration
- Docker deployment
- Integration testing
- Retry and dead-letter queue strategies
- Monitoring and observability

---

## Development approach

- Database-first design using Flyway
- Layered architecture
- Event-driven communication using Apache Kafka
- Independent database persistence
- Git workflow based on main, develop and feature branches
- Features developed in isolated branches and merged through Pull Requests