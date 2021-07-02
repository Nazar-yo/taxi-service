# **Taxi Service**

Project for managing common taxi park. Here you can add, delete, update cars, drivers, and manufacturers. Also, you can see which cars driver have and reassign car to another driver.

### **⚡️ Quick start**
- Clone this project into your local folder and open the project in an IDE.
- Configure Tomcat Server and set up the MySQL RDBMS on your machine.
- Replicate the database from the project by copying the script from init_db.sql into the MySQL Workbench query editor window.
- Setup new connection with DB in ConnectionUtil:
```bash
    String URL = "YOUR DATABASE URL"; 
    - URL must be like : jdbc:mysql://xxxx:yyyy/kkkk?serverTimezone=UTC , where:
        - xxxx - host name,
        - yyyy - port,
        - kkkk - database name
    String USERNAME = "YOUR USERNAME"; 
    String PASSWORD = "YOUR PASSWORD"; 
    String JDBC_DRIVER = "YOUR DRIVER";
    - Driver for example : "com.mysql.jdbc.Driver"
```
- Run a project

### **⚙️Project Structure**
- The project has an N-tier structure and consists of the database layer, the DAO layer for interaction with the database, the service layer which contains the business logic, and the presentation layer.
- The DAO layer is built with the JDBC API.
- In presentation layer we use servlets API to receive and respond to client requests.
- Response to client request return JSP pages.
- Filters control access to the service's functionality.
- Also in project is implemented IoC principe and Dependency Injection pattern by custom Injector class which use custom annotations. 

### **🦾 Technologies used**
Java, JDBC, Servlets, HTML, CSS, JSP, JSTL, RDBMS MySQL, Apache Tomcat, Apache Maven
