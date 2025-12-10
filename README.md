
# 🏦Java Based Digital Banking Fraud Detection and Simulation Engine

A robust, Java-based system designed to simulate complex digital banking transaction streams and apply real-time fraud detection algorithms to identify and flag suspicious activities. This engine serves as both a development/testing environment and a potential core component for live fraud monitoring.


## ✨Features

**-Transaction Simulation:** 
It can create fake streams of banking actions (like transfers and deposits) that look totally real, so you can test the system without risking real money.

**-Plug-and-Play Detection:** Supports multiple fraud detection algorithms (like Velocity Checks, Geo-location Anomaly, Machine Learning Model integration).

**-Detection Rules:** It uses specific rules to catch bad actors: Velocity Check (Did they spend too much, too fast?), Geo-Location Check (Did the user "teleport" between two cities?), Frequent Transaction in a short internal (like 5 transactions in 2 minutes), too many failed transactions and Behavioral Check (Is this transaction different from what the user usually does?).

**-Real-time Alerting:** Flags transactions as fraudulent in sub-millisecond timeframes and generates alerts.

**-User Behavior Profiling:** Maintains stateful profiles for users to detect deviations from typical spending and transaction patterns.

**-Reporting:** Provides detailed logs and reports for simulation results and detection efficacy.


## 🛠️Tech Stack

**Core Language:** Java (JDK 17+)

**Framework:** Spring Boot

**Database Connector:** JDBC (Java Database Connectivity)

**Database:** MySQL

**Build Tool:** Maven

**Development IDE:** IntelliJ IDEA

**API Testing:** Postman


## 🚀Getting Started

**Prerequisites**

-Java Development Kit (JDK) 17 or higher

-Maven or Gradle build tool

-MySQL Server

-IntelliJ IDEA (Community or Ultimate edition)

-Postman (Desktop application or web client)


## Local Setup 

**Clone the repository**

```bash
  git clone https://github.com/Vishesh-03-hub/Java-Based-Digital-Banking-Fraud-Detection-and-Simulation-Engine.git
```

**Database Setup (MySQL)**

-Ensure your MySQL server is running (e.g., via Docker, XAMPP, or a local service).

-Create the necessary database:

```bash
  CREATE DATABASE transaction_db;
```
**IntelliJ Configuration**

-Open IntelliJ IDEA.

-Select File -> Open and navigate to the cloned repository.

-IntelliJ should automatically detect the Maven project structure. If prompted, click "Import changes" to load all dependencies.

-Configure the database connection in the IDE's Database tool window for easy querying during development.

**Configure Environment Variables (Application Properties)**

-Locate the application configuration file (e.g., application.properties or application.yml in src/main/resources).

-Configure connection details for Kafka and MySQL:
Install dependencies

**Properties**
```bash
# application.properties snippet
spring.datasource.url=jdbc:mysql://localhost:3306/fraud_detection_db
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.kafka.bootstrap-servers=localhost:9092
```

**Run the application**

-In IntelliJ, find the main application class (e.g., FraudDetectionEngineApplication.java).

-Right-click the main class and select "Run 'FraudDetectionEngineApplication'".


## 🧪 API Testing with Postman

The core engine exposes several REST API endpoints for interaction, submission, and retrieval. When an endpoint is called, the application logic ensures the relevant data is processed and persisted to the MySQL database before any response is returned.

**Transaction Submission:** POST to /api/v1/transactions

**Profile Update:** PUT to /api/v1/users/{id}/profile

**Alert Retrieval** GET to /api/v1/alerts/recent

To ensure the full life cycle (API Call -> Application Logic -> Database Persistence -> API Response) is working correctly:

**1.Submit a Test Transaction:**

 Use Postman to send a POST request (including transaction details in the JSON body) to:

 ```bash
 http://localhost:8080/api/v1/transactions
 ```

 **2.Verify in MySQL:**
 
  After sending the request, open your MySQL client (or use the IntelliJ Database tool) and execute a query to confirm the data was successfully stored:
  
  SQL

  ```bash
  SELECT * FROM transactions WHERE transaction_id = 'the_submitted_id_from_your_postman_request';
  ```
## 🤝 Contribution

Contributions are welcome! Please follow these steps:

1.Fork the repository.

2.Create a new feature branch (git checkout -b feature/AmazingFeature).

3.Commit your changes (git commit -m 'Add some AmazingFeature').

4.Push to the branch (git push origin feature/AmazingFeature).

5.Open a Pull Request.
