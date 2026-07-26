# QE Automation Framework

## Overview

Automation framework developed using:

- Java 21
- Serenity BDD
- Screenplay Pattern
- Gradle
- Cucumber
- Selenium
- RestAssured

The framework automates UI and REST API scenarios following Clean Code and Screenplay principles.

---

## Project Structure

src/
├── test/
│   ├── java/
│   │   ├── starter/
│   │   │   ├── models/           # DTOs y modelos de datos (Booking, BookingDates, etc.)
│   │   │   ├── questions/        # Clases para validaciones/assercciones de respuesta
│   │   │   ├── tasks/            # Interacciones HTTP (Create, Get, Update, Delete)
│   │   │   └── stepdefinitions/  # Mapeo de pasos Cucumber Gherkin a Java
│   │   └── cucumber/             # Run y configuración del Test Runner
│   └── resources/
│       ├── features/             # Archivos .feature redactados en Gherkin
│       └── serenity.conf         # Configuración global de Serenity BDD

---

## Requirements

Java 21

Gradle 8+

Chrome

Git

---

## Installation

git clone https://github.com/Johans2018/RetoWebAp.git

./gradlew clean build

---

## Run all tests

gradlew clean test aggregate

---

## Run Smoke

gradlew clean test -Dcucumber.filter.tags="@Smoke"

---

## Run Regression

gradlew clean test -Dcucumber.filter.tags="@RegressionCreate"

---

## Run UI

gradlew clean test -Dcucumber.filter.tags="@UI"

---

## Run API

gradlew clean test -Dcucumber.filter.tags="@API"

---

## Parallel execution

The suite supports parallel execution using Gradle.

---

## Reports

After execution

target/site/serenity

Open

index.html

---

## Design Pattern

Screenplay Pattern

---

## CI

GitHub Actions

Runs automatically on every push.

# Autor 👨 ‍💻
## Jonathan Hans Ballesteros