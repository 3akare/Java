# PortServiceMapping Project
## Overview
The **PortServiceMapping** project is a full-stack application that enables a user to monitor the activity status of their servers at specific ports.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Backend](#backend)
  - [Client](#client)
- [Usage](#usage)
- [Configuration](#configuration)
- [License](#license)

## Architecture
**Backend**: A Spring Boot application that handles all operational logic, including:
- Storing IP addresses and port numbers in a MySQL relational database.
- Reading from the database and exposing endpoints for the frontend to render.
- Handling a cron job that checks the activity and online status of the IP address and a specific port at certain intervals.
- Sending email notifications when a service (a saved IP address and port) is down, based on the email specified in the `application.yml` configuration.

**Backend Structure**
```bash
/src
    /main
        /java
            /com
                /portkeeper
                    /pkbackend
                        /data
                            /**/*java
        /resources
            application*.yml
Dockerfile
pom.xml
```

**Client**: A React application with Vite as the build tool. It renders data from the backend and provides an interface for the user to interact with. It also handles a few functionalities including:
- Pagination
- Search functionality

**Client Structure**
```bash
/public
/src
    /components
    /lib
    *jsx
Dockerfile
*js
```

## Prerequisites
- Java 17
- Maven (for building the project)
- Spring Boot (for backend)
- Node.js version 18 <= x <= 22
- MySQL database (5.7.1)

## Getting Started

### Backend

1. **Clone the repository:**
   ```bash
   git clone http://github.com/3akare/Java.git
   cd Java/portServiceMapping/backend
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   The backend service will be available at `http://localhost:8080`.

4. **Verify the service:**
   Open your browser or use a tool like `curl` to test:
   ```bash
   curl http://localhost:8080/propertyFile
   ```
   Expected response:
   ```json
   {
     "Message": "Welcome to PORTKEEPER App ...local dev Api",
     "contactDetails": {
       "name": "DAVID BAKARE - DB"
     },
     "onCallSupport": [
       "+(234)8 159 602 684"
     ]
   }
   ```

### Client

1. **Navigate to the client directory:**
   ```bash
   cd ../client
   ```

2. **Build the project:**
   ```bash
   npm install
   npm run build
   ```

3. **Run the client:**
   ```bash
   npm run preview
   ```
   The client service will be available at `http://localhost:3000` or `http://localhost:4173`.

### Database
A relational database, preferably a MySQL database, should be created and named `portkeeper`. 

The table schema and structure will be automatically created by the backend database drivers when the configuration is done successfully. More configurations can be made to meet your individual needs. See [property-files](https://www.ibm.com/docs/en/sim/7.0.2?topic=files-properties).

## Usage

1. Start the backend server as described above.
2. Run the client application.
3. Enter an IP address or domain name of your choice, and a port number.
4. Monitor the activity status on the dashboard.

## Configuration

### Backend
- **Default Port**: The default port is `8080`, but it can be changed in the `application.yml` file.
- **Sender Email Address**: The sender's email address can be altered in the `application.yml` file.
- **Database Configuration**: Setting up the database configuration will also be done in the `application.yml` file.

## Contributing

Contributions are welcome! Please open issues and submit pull requests for bug fixes, new features, or documentation improvements.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your branch.
5. Open a pull request.
