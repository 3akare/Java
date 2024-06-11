# Word Counting Application

## Overview

The **Word Counting Application** is a practice project built to test Spring Boot skills. It consists of a client-side interface developed with React and Vite, and a backend server implemented using Spring Boot. The client and server communicate with each other over a WebSocket connection.

## Features

- **Word Counting**: Users can input text into the client interface, and the backend server will count the occurrences of each word in real-time.
- **WebSocket Communication**: The client and server communicate asynchronously over a WebSocket connection, enabling seamless updates of word counts without page refresh.
- **React and Spring Boot Integration**: Demonstrates the integration of React for the frontend and Spring Boot for the backend, showcasing full-stack development capabilities.

## Usage

To use the Word Counting Application, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/3akare/Java
   cd WordCounter
   ```

2. **Start the backend server**:
   ```bash
   cd WordCounterApplication
   mvn spring-boot:run
   ```

3. **Start the client**:
   ```bash
   cd client
   npm install
   npm run dev
   ```

4. **Access the application**:
   Open your web browser and navigate to `http://localhost:5173` to access the Word Counting Application.

## Contributing

Contributions to improve or extend the functionality of this application are welcome! If you have any suggestions, bug fixes, or new features to propose, please feel free to open an issue or submit a pull request.
