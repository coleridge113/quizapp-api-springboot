# Quiz App

The **Quiz App** is a web application built using **Spring Boot** that allows users to create, manage, and take quizzes. It provides a robust backend powered by a **RESTful API** to handle all quiz-related operations.

## Features

- Create, update, and delete quizzes.
- Add, edit, and remove questions for each quiz.
- Take quizzes and receive instant feedback.
- Store and retrieve quiz data using a database.

## Technologies Used

- **Spring Boot**: Backend framework for building the application.
- **RESTful API**: Exposes endpoints for managing quizzes and questions.
- **Java**: Core programming language.
- **Database**: For persistent storage of quizzes and results.

## API Endpoints

The application provides the following RESTful API endpoints:

- `GET /api/quizzes`: Retrieve all quizzes.
- `POST /api/quizzes`: Create a new quiz.
- `PUT /api/quizzes/{id}`: Update an existing quiz.
- `DELETE /api/quizzes/{id}`: Delete a quiz.
- `GET /api/quizzes/{id}/questions`: Retrieve questions for a specific quiz.

## Getting Started

1. Clone the repository.
2. Build the project using Maven or Gradle.
3. Run the application using the Spring Boot starter.
4. Access the API or integrate it with a frontend.

## License

This project is licensed under the MIT License.