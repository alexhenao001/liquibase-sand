# LiquibaseSand

A Spring Boot application demonstrating database schema management with Liquibase and PostgreSQL.

## Overview

LiquibaseSand showcases how to:
- Set up Liquibase for database schema versioning
- Configure PostgreSQL for local development
- Integrate Testcontainers for testing
- Implement database migrations using Liquibase changesets

## Technologies

- Java
- Spring Boot
- Liquibase
- PostgreSQL
- Testcontainers
- JUnit 5

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/henlab/liquibasesand/
│   │       └── LiquibaseSandApplication.java
│   └── resources/
│       ├── application.properties
│       └── db/changelog/
│           ├── db.changelog-master.xml
│           └── 2025-01-26.01-create-tables.yaml
└── test/
    └── java/
        └── com/henlab/liquibasesand/
            ├── LiquibaseSandApplicationTests.java
            ├── TestLiquibaseSandApplication.java
            └── TestcontainersConfiguration.java
```

## Database Schema

The application manages two tables:
- `users`: Stores user authentication information
- `profiles`: Stores user profile details

## Getting Started

### Prerequisites

- Java 17 or later
- Docker (for running PostgreSQL)
- PostgreSQL instance (local or Docker)

### Environment Variables

Set the following environment variables:
- `DB_USERNAME`: PostgreSQL username
- `DB_PASSWORD`: PostgreSQL password

### Running Locally

1. Start a PostgreSQL instance:

```bash
docker run --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_USER=username -e POSTGRES_DB=myTestDatabase -p 5432:5432 -d postgres
```

2. Set environment variables:

```bash
export DB_USERNAME=username
export DB_PASSWORD=password
```

3. Build and run the application:

```bash
./mvnw clean package
java -jar target/liquibase-sand-0.0.1-SNAPSHOT.jar
```

### Running Tests

The project uses Testcontainers to spin up a PostgreSQL container for tests:

```bash
./mvnw test
```

## Liquibase Changesets

Database changes are managed through Liquibase changesets. The initial changeset (2025-01-26.01-create-tables.yaml) creates:

1. `users` table with:
   - UUID primary key
   - Username and email (both unique)
   - Timestamps for creation and updates

2. `profiles` table with:
   - UUID primary key
   - Foreign key to users table
   - First and last name fields
   - Timestamps for creation and updates

## Adding New Changesets

To add new database changes:

1. Create a new changeset file in `src/main/resources/db/changelog/`
2. Add the changeset to `db.changelog-master.xml`
3. Run the application to apply the changes

## License

This project is licensed under the MIT License - see below for details:

```
MIT License

Copyright (c) 2025 alexhenao001

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Author

alexhenao001 (Alex Henao)
