# Employee Management Program

A basic Java Swing application to manage employee records using a manually configured MySQL database.  
This project was created as a personal Java learning exercise.

## 🔧 Features

- Admin login with hardcoded credentials  
- View, search, add, edit, and delete employee records  
- Simple GUI built with Java Swing  
- MySQL database connection via JDBC

## 📦 Requirements

- Java JDK 11 or higher  
- MySQL Server (running on localhost, port 3306)  
- A MySQL user with access to a database named `demo`

## 🗄️ Database Setup

1. Open a MySQL client and execute:
   ```sql
   CREATE DATABASE demo;
   USE demo;

   CREATE TABLE employes (
     id INT PRIMARY KEY AUTO_INCREMENT,
     prenom VARCHAR(50),
     nom VARCHAR(50),
     departement VARCHAR(50),
     salaire DOUBLE
   );

   INSERT INTO employes (prenom, nom, departement, salaire) VALUES
     ('Alice', 'Durand', 'HR', 4500),
     ('Bob', 'Martin', 'IT', 5200),
     ('Celine', 'Petit', 'Sales', 4800);
    ```
2. No password authentication is implemented — the app uses hardcoded credentials (admin / admin123).

## ▶️ Running the Program

1. Clone the repository:

  ```bash
  git clone https://github.com/CandasKat/Programme-Gestion-Employes.git
  cd Programme-Gestion-Employes
  ```

2. Compile the source code manually:

  ```bash
  javac -d out src/com/candaskat/*.java
  ```

3. Run the application:

  ```bash
  java -cp out com.candaskat.EcranConnexion
  ```

## 📁 Project Structure

  ```bash
  ├── src/
  │   └── com/candaskat/
  │       ├── ActionEmployes.java
  │       ├── EcranConnexion.java
  │       ├── EcranEmployes.java
  │       └── Employes.java
  ├── demo.sql      # SQL dump (optional)
  ├── out/          # Compiled classes
  └── README.md
  ```

## 💡 Notes

* This project does not use build tools like Maven or Gradle.
* Database connection is handled via JDBC.
* The focus was on practicing core Java, Swing, and SQL — all setup is done manually.


