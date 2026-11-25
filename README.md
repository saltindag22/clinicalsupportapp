# Clinical Support App

A Java-based clinical support application built with Spring Boot. The project combines a server-side web interface, relational database access, and OpenAI integration through Spring AI as a foundation for AI-assisted clinical workflows.

## Technology Stack

| Technology | Purpose |
| --- | --- |
| Java 21 | Application development |
| Spring Boot 3.3.3 | Backend framework |
| Spring Web | Web application infrastructure |
| Thymeleaf | Server-side HTML rendering |
| Spring AI 1.0.0-M1 | OpenAI integration |
| Spring Data JPA and JDBC | Database access |
| MySQL Connector/J | MySQL connectivity |
| Lombok | Reducing Java boilerplate |
| Apache Maven | Dependency management and build automation |

## Project Structure

```text
clinicalsupportapp/
├── .mvn/wrapper/    # Maven Wrapper configuration
├── src/             # Application source code and resources
├── .gitignore
├── mvnw             # Maven Wrapper (macOS/Linux)
├── mvnw.cmd         # Maven Wrapper (Windows)
└── pom.xml          # Dependencies and build configuration
```

## Getting Started

### Prerequisites

- JDK 21
- A running MySQL instance and a database for the application
- An OpenAI API key
- Internet access to download Maven dependencies

### 1. Clone the repository

```bash
git clone https://github.com/saltindag22/clinicalsupportapp.git
cd clinicalsupportapp
```

### 2. Configure the application

Set the database connection and OpenAI credentials before starting the application. The following environment variables are examples using standard Spring Boot and Spring AI configuration conventions; adjust the database name and settings to match your local configuration.

```bash
export SPRING_DATASOURCE_URL='jdbc:mysql://localhost:3306/clinicalsupportapp'
export SPRING_DATASOURCE_USERNAME='your_username'
export SPRING_DATASOURCE_PASSWORD='your_password'
export SPRING_AI_OPENAI_API_KEY='your_api_key'
```

Create the corresponding MySQL database if it does not already exist. Check the application configuration and any schema initialization requirements before running. Never commit API keys or database credentials to GitHub.

### 3. Build and run

On macOS or Linux:

```bash
chmod +x mvnw
./mvnw clean package
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

The default Spring Boot web server address is `http://localhost:8080`, unless overridden in the application configuration.

## Testing

Run the Maven test lifecycle:

```bash
./mvnw test
```

Tests that initialize the application context may require database and API configuration.

## Development Notes

The project uses a milestone version of Spring AI. The Spring Milestones repository is already declared in `pom.xml` to resolve its dependencies. Review compatibility before upgrading Spring Boot or Spring AI.

## Future Improvements

- Add authentication and role-based access control where needed.
- Improve input validation, error handling, and automated tests.
- Add privacy-preserving handling of clinical information and audit logging.
- Evaluate AI-generated responses for accuracy and reliability.

## Disclaimer

This project is a software prototype, not a validated medical device or a substitute for professional clinical judgment. Do not submit real patient information to external AI services without appropriate authorization, privacy safeguards, and compliance review.
