
Use cucumber for BDD - Behaviour Driven Development

There is a Feature file
    Scenario - That contains scenarios
        Given - What are the precondition
        When  - User action
        Then  - What is the result
We can use Junit / TestNG to run the feature
    Here we are using TestNG - Test runner to run the scenarios

It is better to use BDD for integration testing instead of using it
at unit testing phase

It will help the business to identify the business scenarios and its health

How to implement BDD for testing REST API?

    1 . You need the libraries or dependencies in the pom.xml file
                <!-- Cucumber dependency  -->
                <dependency>
                    <groupId>io.cucumber</groupId>
                    <artifactId>cucumber-java</artifactId>
                    <version>7.20.1</version>
                </dependency>

                <!-- Cucumber testNG dependency  -->
                <dependency>
                    <groupId>io.cucumber</groupId>
                    <artifactId>cucumber-testng</artifactId>
                    <version>7.20.1</version>
                </dependency>

    2 . A feature file with extension <name>.feature
            - A feature is a collection of scenarios
            - Define your scenario in the feature file
               - Eg :
                    Feature : "Name of my feature"
                    Given : "This is my precondition"
                    When :  "This is my user action"
                    Then :  "This is my result"
    3 .Create a Runner class a class that extends AbstractTestNGCucumberTests , that is used to run your BDD feature/scenarios
            - Annotate the Runner class with @CucumberOptions
            - Give the values for the feature parameter
                - Eg :
                    @CucumberOptions(feature="src/test/java/myfeatures")
                    class MyRunner extends AbstractTestNGCucumberTests{
                    }

    4. Create a step definition java class , this is java class where your
        actual logic to test happens
