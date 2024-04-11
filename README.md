# Petstore API testing automation
Backend testing framework based on the Swagger API documentation. 

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [My approach](#my-approach)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Contact](#contact)
<!-- * [License](#license) -->


## General Information
- The goal of this project is to build versatile API automation testing framework.
- I wanted to use some solutions which will make this framework reusable and reduce the code usage. 

## Technologies Used
- Java 17
- Rest Assured 5.4
- TestNG 7.9


## My approach
Endpoints
- The endpoints package contains classes/files that define the endpoints used in the application.
- Encapsulating the logic for making HTTP requests, handling responses, and processing data.
- Providing a clean and modular interface for other parts of the application to interact with external APIs.
Payload
- Designed to encapsulate the data structures used as payloads in API requests and responses.
- It contains several classes and enums that represent different entities and attributes according to the documentation.
- User has 1 payload class, Pet has 1 payload class and 1 enum, Pet has 3 payload classes and 1 enum
Test
- I use the Java facker Library to mock the data for tests
- Each test method is responsible for testing a specific aspect of the API endpoint. 
- The test classes cover various scenarios, including creating, updating, retrieving, and deleting resources.

## Screenshots

## Setup
Setup Instructions
To set up your local environment and get started with the project, follow these steps:

Clone the Repository:
git clone <repository_url>
cd <project_directory>

Build the Project:
mvn clean install

Run Tests:
mvn test

Example:
$ git clone https://github.com/username/PetStore.git
$ cd PetStore
$ mvn clean install
$ mvn test

After following these steps, you'll have the project set up and ready for development or testing. You can modify the source code, add new tests, and run the project locally on your machine.

## Usage

## Project Status
Project is in progress.


## Room for Improvement

Room for improvement:
- Add more tests to increase test coverage.

To do:
- Add usage description and screenshots to the readme.md
