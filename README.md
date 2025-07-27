# Schools Management API
# project in progress, adding more features each time 

A Spring Boot RESTful API for managing schools, students, student profiles and more.  
Built with Java 17, Spring Boot, and PostgreSQL.

## Project Features and informations (for now)
- Create, read, update, delete (CRUD) operations for:
    - Schools
    - Students
- Search functionality by school name (substring also)
- Search functionality by student's firstname
- Search functionality by student's age
- Proper HTTP status responses for each request
- PostgreSQL database integration

## DTO Pattern
- the project follows the DTO pattern architecture to separate the different application's layers from each other
- it provides more control on the data we allow our users to see (or not)
- It's also a good approach for maintenability and scalability 


