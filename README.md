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

Quiz APIs:
- `GET /quiz/getAllQuiz`: Retrieve all existing quizzes.
- `GET /quiz/{id}`: Retrieve a specific quiz.
- `GET /quiz/getQuestions/{id}`: Retrieve the questions of a specific quiz.
- `POST /quiz/create?category={category}&numQ={numQ}&title={title}`: Create a new quiz based on category, number of questions, and title.
- `POST /quiz/submit/{id}`: Submit answers based on Quiz ID.
- `DELETE /quiz/{id}`: Delete a quiz.

Questions APIs:
- `GET /questions/allQuestions`: Retrieve all existing questions.
- `GET /questions/{id}`: Retrieve a specific question by its ID.
- `GET /questions/category/{category}`: Retrieve all questions in a specific category.
- `POST /questions/add`: Add a new question (requires a `Question` object in the request body).
- `POST /questions/update/{id}`: Update an existing question by its ID (requires a `Question` object in the request body).
- `DELETE /questions/delete/{id}`: Delete a specific question by its ID.