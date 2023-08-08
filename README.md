# SPRING_BOOT-cinema_rest_service

A comprehensive ticket management API for movie theaters, allowing users to seamlessly view, purchase, and refund tickets.

## 🎬 Features

- **Dynamic Seat Viewing**: Real-time seat availability displayed in a 9x9 matrix.
- **Secure Ticket Purchasing**: Buy tickets confidently with our token system.
- **Hassle-Free Refunds**: Easy ticket cancellations with instant refunds.

## 🛠 Technology Stack

- **Spring Boot**: Back-end framework that powers the core application.
- **Jackson**: Ensures efficient data serialization and deserialization.
- **Slf4j with Logback**: Robust logging mechanism for seamless event tracking.

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher.
- Gradle for dependency management.

### Installation & Running

1. Clone the repository:
    ```bash
    git clone https://github.com/n-alonso/SPRING_BOOT-cinema_rest_service.git
    ```

2. Navigate to the project directory:
    ```bash
    cd SPRING_BOOT-cinema_rest_service
    ```

3. Run the application:
    ```bash
    ./gradlew bootRun
    ```

The API will spring to life at `http://localhost:28852`.

## 🔗 API Endpoints

1. **GET `/seats`**: Retrieves all available seats in the theater.
2. **POST `/purchase`**: Purchase your desired seat by providing the row and column.
3. **POST `/return`**: Return a previously purchased ticket using its unique token.

## 🔍 Error Handling

Should things not go as planned, the application has in-built error mechanisms:

- `BadRequestException`: Triggers for requests with invalid parameters.
- `NotFoundRequestException`: Notifies when a requested resource isn't found.

Each error response includes:
- A timestamp of when the error occurred.
- HTTP status code.
- A descriptive error message.

## 📜 Logging

Application events are meticulously logged. Visit the `./logs` directory for the logs. Configurations include:

- General logging level: **WARN**
- Specific logging level for `cinema.utilities.Config`: **INFO**

## 🙌 Contributing

We love contributions! If you find a bug, have a feature request, or even want to contribute an enhancement or fix:

1. Fork the repo.
2. Create a new feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes.
4. Push the branch.
5. Open a pull request.

Please ensure you update tests as appropriate.

## 📄 License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).
