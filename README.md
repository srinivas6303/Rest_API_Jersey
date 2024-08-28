Alien REST API
This Maven project implements a REST API for managing "Alien" records. The API supports basic CRUD (Create, Read, Update, Delete) operations and is implemented using Jersey Quick Start. <br>The database for storing the Alien data is created using JDBC, and the API is tested using Postman.<br>

Project Structure
com.srinivas.Restdemo.Alien: A Java class representing the Alien entity with fields like alienid, name, and points.<br>
com.srinivas.Restdemo.AlienResource: This class contains the RESTful API methods to handle requests.<br>
com.srinivas.Restdemo.AlienRepository: This class handles database operations using JDBC.<br>
API Endpoints
1. Get All Aliens
Path: /alienresource/getAliens<br>
Method: GET<br>
Description: Retrieves a list of all aliens in the database.<br>
Produces: application/json, application/xml<br>
2. Get a Single Alien
Path: /alienresource/getAlien/{id}<br>
Method: GET<br>
Description: Retrieves the details of an alien by its ID.<br>
PathParam: id - The ID of the alien to retrieve.<br>
Produces: application/json, application/xml<br>
3. Create a New Alien
Path: /alienresource/createAlien<br>
Method: POST<br>
Description: Adds a new alien to the database.<br>
Consumes: application/json, application/xml<br>
4. Update an Existing Alien
Path: /alienresource/updateAlien<br>
Method: PUT<br>
Description: Updates an existing alien record. If the alien with the given ID doesn't exist, a new record is created.<br>
Consumes: application/json, application/xml<br>
5. Delete an Alien
Path: /alienresource/deleteAlien/{id}<br>
Method: DELETE<br>
Description: Deletes an alien from the database based on its ID.<br>
PathParam: id - The ID of the alien to delete.<br>
Consumes: application/json, application/xml<br>
Database Setup
Database Name: restdb<br>
Table Name: aliens<br>
Columns:
id (INT): Primary key, unique identifier for each alien.<br>
name (VARCHAR): Name of the alien.<br>
points (INT): Points associated with the alien.<br>
Tools and Technologies Used
Java: The primary programming language used.<br>
Maven: For managing project dependencies and building the project.<br>
Jersey Quick Start: For implementing RESTful web services.<br>
JDBC: For database connectivity.<br>
MySQL: Database used to store the Alien records.<br>
Apache Tomcat: Server used to deploy the REST API.<br>
Postman: For testing the API endpoints.<br>
