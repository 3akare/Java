# Bookstore Backend API

## Overview

Welcome to the **Bookstore Backend API** repository. This backend service provides basic CRUD operations for managing books. It exposes specific endpoints under `/api/v1/books` to create, delete, update, and fetch books.

## Endpoints

- **GET /api/v1/books**: Retrieve all books.
- **POST /api/v1/books**: Create a new book.
- **PUT /api/v1/books/{book-title}**: Update an existing book.
- **DELETE /api/v1/books/{book-title}**: Delete a book by ID.

## Usage

1. **Retrieve all books**: 
   - **Request**: `GET /api/v1/books`
   - **Response**: Returns a list of all books in the database.

2. **Create a new book**: 
   - **Request**: `POST /api/v1/books`
   - **Body**: JSON object containing book details (title, description, author, genre, rating, release_date).
   - **Response**: Returns the newly created book with its assigned ID.

3. **Update an existing book**: 
   - **Request**: `PUT /api/v1/books/{book-title}`
   - **Body**: JSON object containing updated book details.
   - **Response**: Returns the updated book details.

4. **Delete a book by ID**: 
   - **Request**: `DELETE /api/v1/books/{book-title}`
   - **Response**: Deletes the book with the specified ID from the database.


## Contribution

Contributions are welcome! If you have any suggestions, improvements, or bug fixes, please feel free to open an issue or submit a pull request.
