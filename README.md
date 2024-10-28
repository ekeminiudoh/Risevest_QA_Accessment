# Risevest_QA_Accessment
# UI Test Suite
This project aims to automate the testing of risevest website using Selenium, Java, and TestNG. The test suite covers functional tests to validate login, wallet and creation of plan.

# Project Structure
The test suite follows a modular structure, with each type of test organized into separate packages:

src
└── test
    ├── java
    │     ├── base
    │     │   └── PageBase.java
    │     │   └── TestBase.java
    │     ├── pages
    │     │   └── DashboardPage.java
    │     │   └── LoginPage.java
    │     │   └── PlansPage.java
    │     │   └── WalletPage.java
    │     ├── tests
    │     │   └── InvalidLoginTest.java
    │     │   └── RiseVestE2ETest.java
    │     │   └── ValidLoginTest.java
    │     ├── utils
    │     │   └── ReadTestData.java
    │     │   └── extentReports
    │     │        └── ExtentManager.java
    │     │        └── ExtentTestManager.java
    │     │   └── listeners
    │     │        └── AnnotationTransformer.java
    │     │        └── Retry.java
    │     │        └── TestListener.java
    │     │   └── ReadTestData.java
└── AutomationTest.xml

* base: Contains the test and page base setup and teardown logic for the tests.
* pages: contains classes that represent the web pages of your application.
* tests: contains tests to validate specific functionalities.
* utils: Utility classes for reading data from the test data file, listeners, extent report configurations and ReadTestData to call.

# Prerequisites
* Java 8 or higher
* Maven 3.x
* An IDE (IntelliJ, Eclipse, etc.)
* Internet connection for downloading dependencies

# Setup
1. Clone the Repository: bash   git clone <repository-url>
2. cd public-apis-test-suite   
3. Open the Project in an IDE: Import the project as a Maven project in your preferred IDE (e.g., IntelliJ, Eclipse).
4. Install Dependencies: Run the following command to install dependencies: bash   
    mvn clean install
   
5. A github yml file to run the test on Github actions pipeline.

# Running the Tests
You can run the tests using Maven and TestNG.
1. Run All Tests:
   bash   mvn clean test
2. And run from testng.xml file  
3. Run Specific Test Suites: To run only a particular type of test, specify the suite file. For example, to run the tests: bash Copy code   mvn clean test -DsuiteXmlFile=/AutomationTest.xml -Dtest=TestCases
   
4. The test can also be run from the AutomationTest.xml file.

# Test Coverage

Functional Tests
* Tests specific functionalities of the Risevest website.
* Validates Login functionality, wallet and creation of plans.


# Tools and Technologies
* Java: Programming language for writing the tests.
* Selenium: Java library for testing web apps.
* TestNG: Testing framework for structuring the tests.
* Maven: Dependency management and build tool.

# How to Extend the Tests
1. Add New Test Cases:
    * Create a new class under the appropriate package (e.g. tests).
    * Extend the TestBase class and write new test methods.
2. Add New Utilities:
    * Add common utility methods in utils package for reuse across different test classes.
3. Configure TestNG Suite:
    * Edit AutomationTest.xml to add new test classes or groups.
      
# Test Reporting
Test reports are generated with aventstack extent report in the reports directory. 

# License
This project is open-source 
