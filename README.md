# Examination System

A JavaFX-based application for managing examinations, including subjects, tests, questions, users, and results. The application uses PostgreSQL as its database.

## Requirements
- Java Development Kit (JDK) 11 or higher
- JavaFX SDK
- PostgreSQL (version 12 or higher)
- IntelliJ IDEA or any preferred IDE

---

## Setup Instructions

### 1. Clone the Repository
To get started, clone the project repository to your local machine:

```bash
git clone https://github.com/FrauMeka/exam_final.git examination_meka_true
cd examination_meka_true
```

---

### 2. Configure the Database Connection
The database configuration is located in the `DatabaseUtil.java` file. Ensure the following line is correctly filled based on your setup:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/exam_system";
```

Make sure PostgreSQL is running on port `5432`, and the database name is set to `exam_system`.

---

### 3. Create the Database
#### On macOS:
1. Open the Terminal and access PostgreSQL:
   ```bash
   psql -U postgres -p 5432
   ```
2. Create the database:
   ```sql
   CREATE DATABASE exam_system;
   ```

#### On Windows:
1. Open Command Prompt or PowerShell and access PostgreSQL:
   ```bash
   psql -U postgres -p 5432
   ```
2. Create the database:
   ```sql
   CREATE DATABASE exam_system;
   ```

---

### 4. Build and Run the Application
1. Open the project in your IDE (e.g., IntelliJ IDEA).
2. Ensure the required dependencies are loaded and properly configured in the `pom.xml` file (for Maven users).
3. Run the application by executing the `HelloApplication.java` file.
4. The application will automatically initialize the database tables if they don’t exist.

---

## Features
- **Subjects Management:** Add and view subjects.
- **Tests Management:** Manage tests related to specific subjects.
- **Questions Management:** Add questions for tests.
- **User Results:** Record and display user results for specific tests.

---

## Notes
- Ensure PostgreSQL is installed and running before launching the application.
- The default PostgreSQL user is `postgres`. If you use a different username/password, update the credentials in `DatabaseUtil.java`:
  ```java
  private static final String USER = "meka";
  private static final String PASSWORD = "postgres";
  ```
- Run the application using `HelloApplication.java`. This file contains the entry point of the program.

---

## Troubleshooting
- **Database Connection Error:** Ensure PostgreSQL is running on the correct port and the credentials in `DatabaseUtil.java` are correct.
- **Dependencies Issue:** If using Maven, run `mvn clean install` to ensure all dependencies are downloaded.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

