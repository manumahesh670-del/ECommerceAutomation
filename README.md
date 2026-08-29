# E-Commerce Automation Framework

A robust, data-driven web automation framework built from scratch to test E-Commerce web applications. This project demonstrates enterprise-level QA practices including clean code architecture, automated reporting, and dynamic test data management.

## 🛠️ Technology Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** ExtentReports (with automated failure screenshots)

## 🏗️ Framework Architecture
This framework is designed for scalability and maintenance, utilizing industry-standard design patterns:
* **Page Object Model (POM):** Object locators and interactions are separated from test logic, making the code highly reusable and easy to update.
* **Data-Driven Testing:** Test cases dynamically consume multiple sets of data to maximize test coverage efficiently.
* **Centralized Configuration:** Base configurations (browser setup, teardown) are handled in a core `BaseTest` class.

## 🚀 Key Features
* **Automated Screenshots:** A custom TestNG Listener automatically captures and attaches screenshots directly to the HTML report whenever a test fails.
* **Interactive HTML Dashboards:** Generates rich, visual test execution reports using ExtentReports, providing clear insights into pass/fail ratios and execution times.
* **Suite Execution:** Tests are batched and executed via `testng.xml` for seamless CI/CD integration.
