# JAKARTA-PERSISTENCE-CDI

A personal Jakarta EE project that demonstrates core Jakarta CDI and Jakarta Persistence (JPA) concepts, packaged as a WAR for deployment on a Jakarta EE–compatible server (WildFly). The project implements a simple Client CRUD to focus on dependency injection, persistence configuration, and server-side Java application structure.

---

## Table of contents
- [Project overview](#project-overview)
- [Project goals](#project-goals)
- [Features](#features)
- [Project architecture](#project-architecture)
- [Tech stack](#tech-stack)
- [Setup & installation](#setup--installation)
  - [Prerequisites](#prerequisites)
  - [Steps](#steps)
  - [Running the application](#running-the-application)
- [Author & role](#author--role)
- [Notes](#notes)

---

## Project overview
**JAKARTA-PERSISTENCE-CDI** is a concise learning project to explore Jakarta CDI, JPA, and deployment practices on WildFly. The application focuses on a simple domain model (Client) and provides full CRUD operations implemented using Servlets, JSP, and a DAO layer leveraging JPA.

Key points:
- Emphasis on dependency injection, persistence configuration, and application structure.
- Packaged as a WAR for deployment to a Jakarta EE server.

---

## Project goals
- Discover and practice Jakarta CDI and inversion of control
- Understand JPA persistence and entity mapping
- Learn how to configure and deploy applications on WildFly
- Build a clean and simple CRUD architecture using Servlets and JSP
- Gain hands-on experience with Jakarta EE project structure

---

## Features
- CDI-enabled components via `beans.xml`
- JPA entity mapping for the `Client` domain model
- DAO layer for persistence logic and transaction management
- Servlet-based controller using `@Inject` for dependency injection
- JSP/JSTL views for displaying and managing data
- Full CRUD (Create, Read, Update, Delete) operations
- Configurable datasource via `persistence.xml`

---

## Project architecture
A simple layered layout is used to keep concerns separated.

```
src/main/java
├── entities/
│   └── Client.java         # JPA entity
├── dao/
│   └── ClientDAO.java      # CRUD & persistence logic
└── servlet/
    └── ClientServlet.java  # Controller (request handling)

src/main/resources/META-INF
├── persistence.xml         # JPA & datasource configuration
└── beans.xml               # CDI activation

src/main/webapp
├── WEB-INF/
│   └── web.xml             # Servlet configuration
├── index.jsp               # Entry point
└── clients.jsp             # CRUD user interface
```

---

## Tech stack
- Java (JDK 17+)
- Maven (build & dependency management)
- Jakarta EE
  - CDI
  - Jakarta Persistence (JPA)
  - Servlets
  - JSP / JSTL
- JPA Provider: Hibernate
- Database: Microsoft SQL Server (MSSQL)
- Application Server: WildFly 38
- JDBC Driver: Microsoft JDBC Driver for SQL Server

---

## Setup & installation

### Prerequisites
- JDK 17 or higher
- Apache Maven
- WildFly 38
- Microsoft SQL Server
- MSSQL JDBC Driver installed on WildFly

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Nouhayousse/JAKARTA-PERSISTENCE-CDI.git
   cd JAKARTA-PERSISTENCE-CDI
   ```

2. Build the project:
   ```bash
   mvn clean package
   ```

3. Configure the datasource on WildFly:
   - Register the MSSQL JDBC driver with WildFly.
   - Create a datasource in the WildFly management console or CLI.
   - Ensure the datasource JNDI name matches the one defined in `persistence.xml` (for example: `java:/MSSQLDSs`).

---

## Running the application

1. Deploy the generated WAR file:
   - Copy the WAR from `target/` to WildFly deployments directory:
     ```bash
     cp target/JAKARTA-PERSISTENCE-CDI.war <wildfly-home>/standalone/deployments/
     ```

2. Start WildFly (if not already running):
   ```bash
   <wildfly-home>/bin/standalone.sh
   ```

3. Access the application in your browser:
   - Home page:
     ```
     http://localhost:8080/JAKARTA-PERSISTENCE-CDI/
     ```
   - Direct servlet access:
     ```
     http://localhost:8080/JAKARTA-PERSISTENCE-CDI/ClientServlet
     ```

---

## Author & role
- **Author:** Nouhayousse  
- **Role:** Full implementation (architecture, CDI, JPA, Servlets, JSP, database configuration)

This project is a personal implementation completed end-to-end to deepen understanding of Jakarta EE fundamentals.

---

## Notes
- The project prioritizes learning and clarity over production-scale optimizations.
- The `Client` entity is intentionally simple to highlight CDI and persistence concepts.
- The application is readily extensible with additional entities or REST endpoints if desired.
