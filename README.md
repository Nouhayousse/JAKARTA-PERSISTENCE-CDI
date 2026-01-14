# JAKARTA-PERSISTENCE-CDI

## 📌 Project Overview
**JAKARTA-PERSISTENCE-CDI** is a personal Jakarta EE project designed to explore and understand the core concepts of **Jakarta CDI**, **Jakarta Persistence (JPA)**, and **application deployment on WildFly**.

The project implements a simple **Client CRUD** to focus on the most important learning objectives: dependency injection, persistence configuration, and server-side Java application structure.  
It is packaged as a **WAR** and intended for deployment on a Jakarta EE–compatible application server.

---

## 🎯 Project Goals
- Discover and practice **Jakarta CDI** and inversion of control
- Understand **JPA persistence** and entity mapping
- Learn how to configure and deploy applications on **WildFly**
- Build a clean and simple **CRUD architecture** using Servlets and JSP
- Gain hands-on experience with Jakarta EE project structure

---

## ✨ Features
- CDI-enabled components using `beans.xml`
- JPA entity mapping for the `Client` domain model
- DAO layer handling persistence logic and transactions
- Servlet-based controller using dependency injection (`@Inject`)
- JSP/JSTL views for displaying and managing data
- Full CRUD operations (Create, Read, Update, Delete)
- Configurable datasource via `persistence.xml`

---

## 🏗️ Project Architecture
The application follows a simple layered architecture:

src/main/java
├── entities/
│ └── Client.java # JPA entity
├── dao/
│ └── ClientDAO.java # CRUD & persistence logic
└── servlet/
└── ClientServlet.java # Controller (request handling)

src/main/resources/META-INF
├── persistence.xml # JPA & datasource configuration
└── beans.xml # CDI activation

src/main/webapp
├── WEB-INF/
│ └── web.xml # Servlet configuration
├── index.jsp # Entry point
└── clients.jsp # CRUD user interface

markdown
Copier le code

---

## 🧰 Tech Stack
- **Java** (JDK 17+)
- **Maven** (build & dependency management)
- **Jakarta EE**
  - CDI
  - Jakarta Persistence (JPA)
  - Servlets
  - JSP / JSTL
- **JPA Provider**: Hibernate
- **Database**: Microsoft SQL Server (MSSQL)
- **Application Server**: WildFly 38
- **JDBC Driver**: Microsoft JDBC Driver for SQL Server

---

## ⚙️ Setup & Installation

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
Build the project:

bash
Copier le code
mvn clean package
Configure the datasource on WildFly:

Register the MSSQL JDBC driver

Create a datasource

Ensure the JNDI name matches the one defined in persistence.xml
(e.g. java:/MSSQLDSs)

▶️ Running the Application
Deploy the generated WAR file from the target/ directory to:

arduino
Copier le code
<wildfly-home>/standalone/deployments/
Start WildFly:

bash
Copier le code
standalone.sh
Access the application:

Home page:

arduino
Copier le code
http://localhost:8080/JAKARTA-PERSISTENCE-CDI/
Direct servlet access:

arduino
Copier le code
http://localhost:8080/JAKARTA-PERSISTENCE-CDI/ClientServlet
👩‍💻 Author & Role
Author: Nouhayousse

Role: Full implementation (architecture, CDI, JPA, Servlets, JSP, database configuration)

This project is fully personal and was implemented end-to-end to deepen understanding of Jakarta EE fundamentals.

📝 Notes
The project focuses on learning and clarity, not production-scale optimization

The Client entity is intentionally simple to highlight Jakarta CDI and persistence concepts

The application can easily be extended with additional entities or REST endpoints
