# Automated Testing Project

## AutomationTestStore

Hello and welcome to AutomationTestStore :)

This project contains automated tests for the https://automationteststore.com website. The tests are designed to
validate various functionalities and behaviors of the website to ensure its proper functioning.

### Table of contents:

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Credits](#credits)

### Introduction

The AutomationTestStore Automated Testing Project aims to provide automated tests for
the https://automationteststore.com website.
These tests cover a range of scenarios, including user interactions, cart functionality and checkout processes, to
ensure the website operates as expected.

### Features

- Automated tests for key functionalities of the https://automationteststore.com website.
- Validation of user flows, cart operations, and checkout processes.
- Scalable and maintainable test suite structure.

### Installation

To run the automated tests locally, follow these steps:

1. Clone the repository to your local machine: `git clone https://github.com/fnfldx/automationteststore.git`
2. Install the required dependencies using Maven
3. Ensure you have the necessary WebDriver setup (e.g., ChromeDriver) for your preferred browser
4. See `config.example` file to configure your own properties file

### Credits

- The project uses Selenium WebDriver for automated browser interactions.
- Maven is used for project management and dependency resolution.

## PetStore

Hello and welcome to PetStore for API testing :)

This project contains automated tests for the https://petstore.swagger.io/ api. The tests are designed to
validate various functionalities and behaviors of the api endpoints to ensure its proper functioning.

### Introduction

API tests approach is based on the RestAssured and the Cucumber - BDD.
Due to this fact the cucumber `features files` must be linked with java code `test steps` via `runner` files.
Please see the following structure:

```bash
├──src
│   ├───main
│   │   └───java
│   │       ├───clients # methods implementations of the requests
│   │       ├───model # objects usually represents the json objects from the response/request body
│   │       └───steps # cucumber test steps implementations
│   │          
│   │          
│   │   
│   └── test
│       ├───java
│       │   └───runner # runner of the test cases
│       │   
│       └───resources
│           └───cucumber 
│               └───features # cucumber files with gherkin syntax
```

### Installation

If all maven dependencies are correctly imported and project has no errors the API tests are ready to be run.

### Running test

Go to the runner folder with certain test runner `*.AT` file.
Click on the test icon on the left from the runner test class (i.e.: "PetCrudAT").

For running test using maven command line, please use the following command:

```bash
mvn test
```
For running tests with Allure Report generation please use the following command:

```bash
mvn test allure:report
```

### Running Allure Report
If you want to start the Allure report, please use the following command:

```bash
allure serve allure-results
```
It will start the Allure report server and open the report in your default browser.

For generating the Allure report and save it as HTML, please use the following command:

```bash
allure generate allure-results
```