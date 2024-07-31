## Description 

Developed a Java-based web application using JSP, Servlets, and Maven to provide personalized beer recommendations based on user preferences.

## Key Features
- User Authentication: Implemented a login mechanism with credential validation and session management.
- Recommendation System: Designed a beer recommendation engine using Java and a simple algorithm.
- MVC Architecture: Utilized Model-View-Controller (MVC) pattern to separate business logic, presentation, and data.
- Filters: Created a servlet filter for URL redirection to ensure user-friendly navigation.
- Bootstrap Integration: Used Bootstrap for responsive and visually appealing UI design.
- Deployment: Deployed the application on Apache Tomcat.

## Technologies Used
- Java
- JSP and Servlets
- Maven for build automation
- Apache Tomcat for deployment
- HTML, CSS, and Bootstrap for front-end development

## How to Run
### Setting Up the Environment

1. **Clone the Repository**
2. **Configure the Database:**
   - Import the beerdb.sql file into your MySQL database or create your own beer database.
   - Update the database connection settings in your db.properties  file with your MySQL credentials.
   - MY DB SCHEMA
     ![image](https://github.com/user-attachments/assets/21bef975-f784-454e-9adb-d0695b1423bf)

4. Build the Project:

   ```bash
    mvn clean install
5. Run the Application using tomcat by placing the complied WAR file of your project into the webapps folder of tomcat or any other method 🤷‍♂️ .
