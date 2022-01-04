# ProgrammeGestionEmployes<br>
This is a project for managing employees and staff information.<br>
In this phase, the project consists of two sections. The first of these sections is the administrator login section:<br> 
-The section that connects the database to the correct username and password entry.<br> 
-Once you log in with the correct username and password, the second section is entered. The second section is where the employee table is located: <br>
-With the dynamic search function it is possible to quickly find the employees in the data table by their ID, first name, last name, department. <br>
It is even possible to search by salary. <br>
-Adding new employees to the table, editing employee information or deleting employees are other functions. <br>
You can find the database properties in the folder database.java. Methods that allow database connection and operation on the table are in the class 'ActionEmployes.java'. <br>
The class 'EcranConnexion.java' contains the login process, which also contains the main method. The design of the login screen was made in this folder as well. <br>
The class 'Employes.java' contains information like ID, first name, last name, department name and salary for employees only.<br>
Finally, in the class 'EcranEmployes.java', information is taken from the database and displayed in the table jframe.<br>
In addition, this is the folder where the operations and table design are done on the table. To make a MySQL connection, <br>
you need to download xampp and make the required database connection called 'demo'. You should create a database and a file 'demo.sql' in the mysql folder. <br>
You need to import it. This program was created by Candas Kat in December 2021.<br>
