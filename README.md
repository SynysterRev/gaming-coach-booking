# Gaming Coach Booking

A booking platform for gaming coaching sessions.

## Description

Gaming Coach Booking is a REST API that connects gaming coaches with players looking to improve their skills. The platform facilitates booking personalized coaching sessions.

## Technologies

- **Backend**: Java 25 with Spring Boot 4
- **Database**: PostgreSQL
- **Cache**: Redis (for cart/session management)
- **Build**: Maven
- **Containerization**: Docker & Docker Compose
- **Authentication**: JWT

## Prerequisites

- Java 25
- Maven 3.6+
- Docker & Docker Compose
- A Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/SynysterRev/gaming-coach-booking.git
cd gaming-coach-booking
```

### 2. Environment configuration

Copy the `.env.example` file to `.env` and update it with your own values:

```
.env.example → .env
```

### 3. Start the database

The database will be automatically initialized when you start Docker. All SQL scripts in the `sql_script/` folder will be executed thanks to the volume mapping in `docker-compose.yml`:

```bash
docker-compose up -d
```

> **Note**: The SQL scripts are automatically mounted to `/docker-entrypoint-initdb.d` in the PostgreSQL container, which executes them on first startup.

### 4. Build and run the application

```bash
# With Maven Wrapper (recommended)
./mvnw clean install
./mvnw spring-boot:run

# Or with globally installed Maven
mvn clean install
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080` (default port).

## Project Structure

```
gaming-coach-booking/
├── src/
│   ├── main/
│   │   ├── java/           # Java source code
│   │   └── resources/      # Configuration files
│   └── test/               # Unit and integration tests (coming soon)
├── sql_script/             # SQL initialization scripts
├── target/                 # Compiled files (generated)
├── docker-compose.yml      # Docker configuration
├── pom.xml                 # Maven configuration
└── .env.example            # Environment variables template
```

## Development

### Build for production

```bash
./mvnw clean package -DskipTests
```

The JAR file will be generated in `target/`.

## Docker

### Start all services

```bash
docker-compose up
```

### Stop services

```bash
docker-compose down
```

### Remove volumes (complete reset)

```bash
docker-compose down -v
```

## Features

### Implemented

- **User Registration**: Account creation with JWT token generation for authentication

### In Progress / Planned

- **Authentication**: Login system with JWT
- **User Profiles**: 
  - Coach profile with games expertise, skill levels, and available time slots
  - Gamer profile for booking sessions
- **Coaching Sessions**:
  - Coaches can create 1-hour time slots
  - Gamers can browse and book available slots
  - Redis-based cart/booking management
- **Game Integration**: Integration with game APIs (e.g., League of Legends) to fetch coach profiles and stats
- **Concurrency Control**: Prevent double-booking of the same time slot
- **Testing**: Unit and integration tests with Mockito

### Future Ideas

- Payment integration
- Session review and rating system
- Coach search and filtering
- Notification system
- And more to come...
