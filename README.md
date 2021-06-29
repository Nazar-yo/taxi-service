# **Taxi Service**

This project is the implementation of online service for internal usage of taxi company, whose functions are adding, deleting and editing information about cars at the cabstand and their manufacturers and drivers.

### **Project Structure**
- The project has an N-tier structure and consists of the database layer, the DAO layer for interaction with the database, the service layer which contains the business logic, and the presentation layer.
- The DAO layer is built with the JDBC API.
- Servlets are used to receive and respond to client requests.
- Filters control access to the service's functionality.
- The presentation layer is implemented with JSP pages.
- This project also includes custom-made annotations and an injector, which utilizes Reflection API.

### **Technologies used**
- Backend: Java, JDBC, Servlets
- Frontend: HTML, CSS, JSP and JSTL
- Databases: RDBMS MySQL
- Web-server: Apache Tomcat
- Packaging: Apache Maven

### **Configuration**
- Clone this project into your local folder and open the project in an IDE.
- Configure Tomcat Server and set up the MySQL RDBMS on your machine.
- Replicate the database from the project by copying the script from init_db.sql into the MySQL Workbench query editor window.
- Insert your own MySQL username and login in dbProperties in the ConnectionUtil class.
- Setup new connection with:
    - user: "your username"
    - password: "your password"
    - url: jdbc:mysql://xxxx:yyyy/kkkk?serverTimezone=UTC , where:
        - xxxx - host name,
        - yyyy - port,
        - kkkk - database name

- Run a project
