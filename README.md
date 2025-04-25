# 📚 Book Tracker REST API

A modern Java 18+ RESTful API built with Spring Boot, Gradle, and AWS DynamoDB. This API allows you to manage a collection of books — add, list, and store book data in a NoSQL database. Built for portfolio demonstration, optimized with clean architecture and popular libraries.

---

## 🚀 Tech Stack

- Java 18+
- Spring Boot
- Gradle
- AWS SDK v2 (DynamoDB)
- DynamoDB Enhanced Client
- Lombok
- JPA (for structural clarity)
- Docker (for local DynamoDB)
- Spring Profiles (local/cloud switching)

---

## 🛠️ Prerequisites

- Java 18+
- Gradle 8+
- Docker
- AWS CLI
- Git

---

## 🧱 Project Structure

```shell
├── src
│   └── main
│       ├── java/com/yourname/booktracker
│       │   ├── controller
│       │   ├── model
│       │   ├── repository
│       │   └── config
│       └── resources
│           ├── application.yml
│           ├── application-local.yml
│           └── application-cloud.yml
├── build.gradle
└── README.md
```

## Run DynamoDB Locally with Docker

Run docker in project context to create the pods locally

```docker run -d -p 8000:8000 amazon/dynamodb-local```

The project has a component to create the tables on local profile on --bootRun

## Build and Run:

Add this local variable for AWS Authentication on DynamoDB

```
AWS_ACCESS_KEY_ID=dummy
AWS_SECRET_ACCESS_KEY=dummy
AWS_REGION=us-east-1
```

Run this command to build project on local profile

```./gradlew bootRun --args='--spring.profiles.active=local'```

## License

This project is for educational and portfolio purposes.
