# DronMed project

DronMed Project is a web application that allows you to manage the delivery of medicines at home using drones.

## Project description

The objective of this project is to develop a system that facilitates access to medicines for people who cannot travel to a pharmacy or who live in remote areas. For this, a fleet of drones is used that can transport the medicines from a central warehouse to the patient's home, following an optimal and safe route.

The project is developed with Spring Boot, a Java framework that facilitates the creation of web applications based on microservices. Thymeleaf is also used as a template engine to generate HTML views, JPA for data access through entities and repositories, and Quartz for task programming.

## Table of Contents

- [How to start](#how-to-start)
- [How to use](#how-to)
- [How to contribute](#how-to-contribute)
- [License](#license)
- [Contact](#contact)

## How to start

In order to run the project you need to have Java 1.8 or higher, Maven 3.5+ and MySQL 8+ installed. It is also recommended to use an IDE like Eclipse or IntelliJ IDEA.

The steps to install and run the project are as follows:

1. Clone the repository from GitHub: `git clone https://github.com/lhcastillo9402/dronmed-project-musala.git`
2. Enter the project directory: `cd dronmed`
3. Create the MySQL database with the name `dronmed` and the user `root` and password `root`.
4. Run the SQL script `src/main/resources/schema.sql` to create the tables and insert some test data.
5. Run the `mvn spring-boot:run` command to start the application.
6. Open a web browser and access the URL `http://localhost:8080` to see the user interface.

## How to use

The application allows you to perform the following actions:

- Register a new drone with its serial number, model, battery capacity and weight limit.
- Load a drone with one or more medications, indicating their codes.
- Consult the data of a drone by its serial number, including the medications loaded.
- Consult the medicines available in the warehouse by their code or name.
- Consult the drones available for shipments, that is, those that are in IDLE state and have enough battery.
-Schedule a shipment of medicines to a patient, indicating his name, address and the codes of the medicines he needs.
- View the history of shipments made by the drones, including the date, time, battery level and status of the drone.

## How to contribute

If you want to collaborate in the development or improvement of the project, you can follow the steps below:

1. Fork the repository in your GitHub account.
2. Create a branch with a descriptive name for your contribution: `git checkout -b feature/new-feature`
3. Make the changes that you consider necessary in the code, following the rules of style and good practices of Java and Spring Boot.
4. Make a commit with an explanatory message: `git commit -m "Added new functionality"`
5. Push your branch to the remote repository: `git push origin feature/new-feature`
6. Make a pull request from your branch to the original repository, indicating the purpose and scope of your contribution.

## License

This project is licensed under the MIT license, which means you are free to use, modify, and distribute it, as long as you acknowledge original authorship and don't use it for commercial purposes. For more information, see the [LICENSE](LICENSE) file in this repository.

## Contact

If you have any questions, suggestions or comments about the project, you can contact the authors through the following means:

- User: lhcastillo9402@gmail.com
- GitHub: https://github.com/lhcastillo9402
