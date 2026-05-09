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
- Simulate notification delivery
- Persist notification logs in an independent database
- Maintain loose coupling with the main API

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

🚧 Initial setup phase

Currently implemented:

- Spring Boot project initialization
- Maven project configuration
- Flyway configuration
- Kafka consumer configuration
- Local environment setup structure
- Initial database schema migration

Planned next steps:

- NotificationLog entity
- Kafka consumer implementation
- LoanCreatedEvent integration
- Notification persistence
- Service layer implementation
- Docker deployment

---

## Development approach

- Database-first design using Flyway
- Layered architecture
- Event-driven communication using Apache Kafka
- Independent database persistence
- Git workflow based on main, develop and feature branches