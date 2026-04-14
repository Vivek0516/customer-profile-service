# Customer Profile Service

## Overview

Customer Profile Service is a Spring Boot-based application designed to manage customer data and publish events using Apache Kafka. This project follows a clean layered architecture and serves as a foundation for event-driven microservices systems.

## Features

* Create, update, delete, and fetch customer profiles
* Kafka event publishing (producer only)
* Layered architecture (Controller, Service, Persistence, Entity)
* Custom exception handling
* Gradle-based build

## Tech Stack

* Java 17
* Spring Boot
* Apache Kafka
* Gradle



## How to Run

### 1. Start Kafka

```bash
docker-compose up -d
```

### 2. Run Application

Run the main class:
CustomerProfileApplication

### 3. Test API

POST /api/v1/customers

## Future Enhancements

* Add Kafka consumer services
* Implement database (PostgreSQL)
* Add event logging (Outbox pattern)
* Add API Gateway
* Improve error handling and validation

## Note

This is an initial version of the project. More features and improvements will be added in future updates.
