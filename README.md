
# Hibernate Spring Boot Practice

## Overview
This project is a practice implementation of using Hibernate with Spring Boot. It demonstrates various aspects of integrating Hibernate ORM with Spring Boot, including CRUD operations, database integration, and validation.

## Features
- **Entity Management**: Use Hibernate for ORM (Object Relational Mapping).
- **Database Integration**: Uses H2 in-memory database and MySQL for persistent storage.
- **Validation**: Uses Spring Boot validation for entity validation.
- **Spring Boot Integration**: Leverages Spring Boot for rapid application development.

## Technologies Used

### Backend
- **Spring Boot**: Framework to create stand-alone, production-grade Spring based Applications.
- **Hibernate**: ORM framework for mapping Java objects to database tables.
- **Spring Data JPA**: Abstraction over the JPA to interact with relational databases.
- **H2 Database**: In-memory database for development and testing.
- **MySQL**: Relational database management system for production use.
- **Lombok**: Java library that automatically plugs into your editor and build tools, simplifying Java development.

## Prerequisites
- Java 17
- Maven

## Getting Started

### Clone the repository
```bash
git clone https://github.com/GRVKMR2003/Hibernate.git
cd Hibernate/demo
```

### Build the project
```bash
mvn clean install
```

### Run the project
```bash
mvn spring-boot:run
```

The application will be running on `http://localhost:8080`.

## Project Structure
- **src/main/java**: Contains the main application code.
- **src/main/resources**: Contains application properties and static resources.
- **src/test/java**: Contains test cases for the application.

## Usage
- **Entity Management**: Manage entities using Hibernate ORM.
- **Database Operations**: Perform CRUD operations on the database using Spring Data JPA.
- **Validation**: Validate entity fields using Spring Boot validation.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements
- Spring Boot
- Hibernate
- Spring Data JPA
- H2 Database
- MySQL
- Lombok

