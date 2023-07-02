## Project Overview
The automation project is designed to automate the testing process 
for web applications across different browsers and API endpoints. 
It utilizes Java 11 as the programming language, 
TestNG as the testing framework, 
and REST Assured for API testing.

# Project Structure
The project follows a standard Maven project structure. 
The main directories and files are as follows:

```- src
    - main
        - java                      // Contains the main Java code
            - api                   // Main code for API
                - helpers           // Helpers for each endopoint to make action using API
                - pojos             // POJO mappers to get java object for each endpoint
                - services          // Services for endopoint to get Respose object to validate using Rest Assured functionality
            - functional            // Main code for UI tests
                - components        // Reusable components that can be used by more the one page objects
                - lsiteners         // Listener classes to execute asynchronous actions
                - pages             // Page objects
                - setup             // Global setup classes
                - setpdefinitions   // Setup difinitions to make any step, and depending on resolution make corresponding action
                - utils             // Utility classes
    - test
        - java                      // Contains the test classes and suites
            - api                   // API tests
            - base                  // Base classes
            - ui                    // UI tests
```

# Prerequisites
To set up and run the automation project, make sure you have the following prerequisites installed:

- Java 11
- Maven
- Browsers (chrome, safari, firefox)
<p/>There is no need to download drivers, because webdrivermanager is being used

# Parameters
Any of this params can be passed using System variable, otherwise will be passed from configuration.properties
```
base_url                    // UI test base url
browser                     // Browser type (available options chrome, safari, firefox)
resolution                  // Browser resolution (available options MAXIMUM, 800x600, 1024x768)
api_url                     // Base url for API tests
element_wait_timeout        // Explicit wait timeout
retry_count                 // Test retry count in case of failure
```

# Running the Tests
To run the automation tests, execute the following command:

```mvn failsafe:integration-test```

# Configuration and Test Data
The project's configuration settings and test data can be stored in the src/resources directory. 
You can define browser configurations, API endpoints, environment-specific data, etc., 
in the configuration.properties file.

# Acknowledgements
This project utilizes the following open-source libraries and frameworks:

- Java
- TestNG
- REST Assured
- Selenium
- Schema validator
- Lombok
- Failsafe plugin