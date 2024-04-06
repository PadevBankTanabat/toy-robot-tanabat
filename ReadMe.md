# Toy Robot Simulation

## Approach

The Toy Robot Simulation project aims to create a console application that simulates the movement of a toy robot on a tabletop. The robot can be placed on the table, moved, rotated, and report its current position and direction.

### Functionality
- **PLACE X, Y, F**: Places the robot on the table at position X, Y, and facing direction F (NORTH, SOUTH, EAST, or WEST).
- **MOVE**: Moves the robot one unit forward in the direction it is facing.
- **LEFT**: Rotates the robot 90 degrees to the left without changing its position.
- **RIGHT**: Rotates the robot 90 degrees to the right without changing its position.
- **REPORT**: Displays the current position (X, Y) and facing direction (F) of the robot.

### Constraints
- The robot must not fall off the table during movement.
- The first command must be a valid PLACE command.

### Approach
1. **ToyRobotSimulation Class**: Created a Java class to represent the toy robot and implemented methods for placing, moving, rotating, and reporting.
2. **JUnit Testing**: Implemented JUnit tests to validate the functionality of the ToyRobotSimulation class.
3. **Example Input and Output**: Provided sample input and output scenarios to demonstrate the functionality of the application.
4. **README.md**: Documented the project, including the approach, functionality, constraints, design patterns and usage instructions.

### Design Patterns
1. Singleton Pattern: The ToyRobotSimulation class does not implement the Singleton pattern explicitly, but it resembles a singleton in the way it is used. The main method creates a single instance of ToyRobotSimulation and interacts with it throughout the program's execution.
2. Command Pattern: The main method processes different commands (PLACE, MOVE, LEFT, RIGHT, REPORT) by calling corresponding methods in the ToyRobotSimulation class. This separation of commands and their execution aligns with the Command pattern.
3. State Pattern: The state of the robot (position and direction) is maintained within the ToyRobotSimulation class. The methods like move, left, right, and report operate based on the current state of the robot, resembling the State pattern.
4. Strategy Pattern: Although not explicitly implemented, the ToyRobotSimulation class could potentially benefit from the Strategy pattern if there were different strategies for moving or rotating the robot based on its current state.
5. Factory Method Pattern: While not present in the provided code, a Factory Method pattern could be used to create instances of different types of robots or to handle different types of commands in a more modular and extensible way.

## Usage
1. Compile the Java files.
2. Run the `ToyRobotSimulationTest` class to execute the JUnit tests.
   * If the JUnit tests are failing (shown in red), click to add the classpath in IntelliJ(recommended).
3. Run the `ToyRobotSimulation` class to interact with the toy robot simulation via the console.


#### Thank you for taking the time to review my code! I hope you find my solution impressive and that it meets the requirements for passing to the next round. I appreciate your feedback and look forward to any suggestions you may have to improve my code. 😊