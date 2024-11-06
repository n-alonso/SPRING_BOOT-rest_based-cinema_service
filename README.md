# SPRING_BOOT-cinema_rest_service

A ticket management API for movie theaters, allows users to view, purchase, and refund tickets.

## Features

- Seat availability displayed in a 9x9 matrix.
- Buy tickets with a token system.
- Ticket cancellations and refunds.

## Technology Stack

- Spring Boot
- Jackson
- Slf4j with Logback

## Getting Started

### Prerequisites

- Java 17 or higher.
- Gradle for dependency management.

### Installation & Running

1. Clone the repository:
    ```bash
    git clone https://github.com/n-alonso/SPRING_BOOT-cinema_rest_service.git && cd SPRING_BOOT-cinema_rest_service
    ```

2. Run the application:
    ```bash
    ./gradlew bootRun
    ```

The API is served at `http://localhost:28852`.

## API Endpoints

1. **GET `/seats`**: Retrieves all available seats.
2. **POST `/purchase`**: Purchase a seat by providing the row and column.
3. **POST `/return`**: Return a purchased ticket using the seat's token.

## Error Handling

- `BadRequestException`: Triggers for requests with invalid parameters.
- `NotFoundRequestException`: Notifies when a requested resource isn't found.

Each error response includes:
- A timestamp of when the error occurred.
- HTTP status code.
- A descriptive error message.

## Logging

Application events are meticulously logged.  
Visit the `./logs` directory for the logs.  
Configurations include:

- General logging level: **WARN**
- Specific logging level for `cinema.utilities.Config`: **INFO**
