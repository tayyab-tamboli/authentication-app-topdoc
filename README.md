# Authentication-App-TopDoc
##### _Repository for Top-Doc interview process_

### Requirements
You are required to build a backend application that will feature User
Registration & Authentication (OTP based).


- You are required to create following API endpoints for following 5 use cases
   
   a. User Registration: Registration MUST pass through OTP Validation (Step ‘b’).
   Registration fields are 
   
   i. Username (required)
   
   ii. Password (required)
   
   iii. Name (required)
   
   iv. Mobile (required)
   
   v. Date of birth (required)
   
   b. OTP Validation: Create a 2factor free account to use transactional SMS for
   OTP. Users registering with a valid mobile number will receive the OTP on
   his/her mobile number. When OTP validation passes then User can be added
   to the backend Database safely.
   
   c. User Profile Details: Return the registered user account details (Registration
   Fields).
  
   d. Login: Login using username & password
   
   e. Logout
   
- List all the endpoints with method supported & parameters required.
- You should handle error scenarios.
- Use Java technology for the backend but you are open to use any framework that
 you are comfortable with. We prefer Spring Boot framework.
- Choose a Database that you are most comfortable with.
- The app should be hosted/run locally.




## Technologies Used

- Java 8
- Spring Boot
- Swagger
- Spring Data JPA
- H2 DB (In-Mem)
- Lombok

#### Swagger API Documentation
URI : http://localhost:9890/topdoc-app/swagger-ui/index.html#/

#### H2 Console
URI : http://localhost:9890/topdoc-app/h2-console/login.jsp

## Steps to Run the App

Clone project on local

```sh
git clone https://github.com/Tayyabt120/authentication-app-topdoc.git
```

Change directory to authentication-app-topdoc

```sh
cd authentication-app-topdoc
```

Build Project

```sh
gradle build 
```

Run Jar File

```sh
java -jar authentication-app-topdoc-0.0.1-SNAPSHOT.jar
```

Import postman collection 'TopDoc-Interview.postman_collection.json' to test all api from Postman.
