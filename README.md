# distance-calculator
This Spring Boot-driven app takes a list of customer GPS locations as input and returns the names and user ids of customers within 100km of a given GPS location. Great-circle distance is used to determine the distance between two points.

The central angle is calculated using the below forumla: 

![](https://wikimedia.org/api/rest_v1/media/math/render/svg/d924c72204c36417ad81c90186cf20da997b266f)

The arc length is calculated using the below formula:

![](https://wikimedia.org/api/rest_v1/media/math/render/svg/813bb7a7fb37e206075fe236f558cf1ef176e642)

# Usage Instructions (Mac)
Requires: [Java 8](https://java.com/en/download/help/mac_install.xml), [Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac)

1. Clone the repository to your local machine.
2. Run `mvn package` within the `distance-calculator` folder to create an executable .jar file. The unit tests will run at this point and the results will be displayed in the terminal. Tests can also be executed manually in IntelliJ by right-clicking on the `tests > java` folder and selecting `Run 'All Tests'`.
3. Optionally, save the input file of your choice inside the `distance-calculator` folder. A sample file (`customers.txt`) is provided in the `src/main/resources` folder if you do not wish to create a new file.
4. Run `java -jar target/distance-calculator-0.0.1-SNAPSHOT.jar "path-to-file"`, replacing `path-to-file` with the path to the file you want to use as input (eg `java -jar target/distance-calculator-0.0.1-SNAPSHOT.jar "src/main/resources/customers.txt"`). A relative path may be used for files below the `distance-calculator` folder, otherwise an absolute path should be provided. Multiple file paths may be provided.
5. The results will be printed to the terminal.
