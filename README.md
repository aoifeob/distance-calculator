# distance-calculator
This Spring Boot-driven app takes a list of customer GPS locations as input and returns the names and user ids of customers within 100km of a given GPS location.

# Installation instructions
Requires: Java 8, Maven

1. Clone the repository to your local machine.

# Code execution instructions
1. Run `mvn package` to create an executable .jar file.
2. Optionally, save the input file of your choice inside the `distance-calculator` folder. A sample file (`customers.txt`) is provided if you do not wish to create a new file.
3. Run `java -jar target/distance-calculator-0.0.1-SNAPSHOT.jar "path-to-file"`, replacing `path-to-file` with the path to the file you want to use as input (eg `java -jar target/distance-calculator-0.0.1-SNAPSHOT.jar "customers.txt"`). A relative path may be used for files below the `distance-calculator` folder, otherwise an absolute path should be provided. Multiple file paths may be provided.
4. The results will be printed to the file `output.txt`. Executing the code again will overwrite the previous contents of the file.

# Test execution instructions
Running `mvn clean install` inside the project directory will run the tests and display the results in the terminal. Tests can also be executed manually in IntelliJ by right-clicking on the `tests > java` folder and selecting `Run 'All Tests'`.
