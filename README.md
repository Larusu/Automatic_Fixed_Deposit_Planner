<h1>
  <img src="./assets/logo.png" alt="BluPlan Logo" width="75" style="vertical-align: middle;"/>
  BluPlan: Automated Fixed Deposit Planner
</h1>
BluPlan is a Java-based application that helps users plan and manage fixed deposit accounts through a graphical interace. This project was developed as for the final project for our Object-Oriented Programming subject, demonstrating full CRUD operations, database integrations with MySQL, and GUI development using Java Swing.
### 👨‍💻Developed by:
[JhervisArevalo](https://github.com/JhervisArevalo)

[Larusu](https://github.com/Larusu)

[watercress](https://github.com/waterrcress)

## 📝 Features
- Simple, intuitive GUI
- CRUD operations (Create, Read, Update, Delete) for deposit plans and goals
- MySQL integration using JDBC
- Maturity date calculation, interest tracking, and goal linking
- Clean object-oriented structure using Abstraction, Encapsulation, Inheritance, and Polymorphism

## 🔧 Setup Instructions
1. Install XAMPP. 
- Make sure XAMPP is installed and MySQL is running.
2. Set up the database
- Go to the [DatabaseInitializer.java](./src/main/java/dbcode/DatabaseInitializer.java) file. 
- Update the static variables: 
```
ROOT_URL
DB_UR
USERNAME
PASSWORD
```
-  These should match your MySQL login found in MySQL config file (```my.ini```). (Usually: ```root``` with no password)
3. Compile and Run. 
- Open the project in your IDE.
- Build and run ```Main.java```.

## 📁 Project Structure
```
/src
  ├── components/
  ├── dbcode/
  ├── gui/
  ├── lib/
  ├── logic/
  ├── model/
  ├── session/
  └── Main.java
```
- components/ — Custom components used for GUI
- dbcode/ — All database-related code (connection, queries)
- gui/ — Java Swing UI (.java and .form)
- lib/ — External Libraries (JCalendar)
- logic/ — Business Logic (maturity calculations)
- model/ — Data models
- session — Tracks the current user session