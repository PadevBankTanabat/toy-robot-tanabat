import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToyRobotSimulationTest {


    @Test
    public void testExampleInputAndOutput() {
        ToyRobotSimulation robot = new ToyRobotSimulation();

        // There are better solutions for writing these test cases, but for me this one is easier to understand and review.

        // Example a.
        robot.place(0, 0, "NORTH");
        robot.move();
        robot.report();
        assertEquals("Output: 0,1,NORTH", robot.getOutput());

        System.out.println("-------------------------------");

        // Example b.
        robot.place(0, 0, "NORTH");
        robot.left();
        robot.report();
        assertEquals("Output: 0,0,WEST", robot.getOutput());

        System.out.println("-------------------------------");

        // Example c.
        robot.place(1, 2, "EAST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        robot.report();
        assertEquals("Output: 3,3,NORTH", robot.getOutput());

        System.out.println("-------------------------------");

        //Ignore go left at the edge : case facing
        robot.place(0, 0, "WEST");
        robot.move();
        robot.report();
        assertEquals("Output: 0,0,WEST", robot.getOutput());

        System.out.println("-------------------------------");

        //Ignore go left at the edge : case 90 degree
        robot.place(0, 0, "NORTH");
        robot.left();
        robot.move();
        robot.report();
        assertEquals("Output: 0,0,WEST", robot.getOutput());

        System.out.println("-------------------------------");

        //Validate placing
        /*I am using this specific coding style solely for this case, as it is intended to be more easily understandable for you.
        * in fact, every test case should code in the same way but coding if-else like this one. it's not good for real production (on my opinion).
        * */
        if(!robot.place(-1, -99, "SOUTH")) {

        }
        else {
            /*no more process*/
            robot.move();
            robot.report();
            assertEquals("error!! table's not existed", robot.getOutput());
        }

        System.out.println("-------------------------------");

        //Ignore go right at the edge : case facing
        robot.place(4, 4, "EAST");
        robot.move();
        robot.report();
        assertEquals("Output: 4,4,EAST", robot.getOutput());

        System.out.println("-------------------------------");

        //Ignore go right at the edge : case 90 degree
        robot.place(4, 4, "NORTH");
        robot.right();
        robot.move();
        robot.report();
        assertEquals("Output: 4,4,EAST", robot.getOutput());

        System.out.println("-------------------------------");

        //Ignore go forward to north
        robot.place(2, 4, "NORTH");
        robot.move();
        robot.report();
        assertEquals("Output: 2,4,NORTH", robot.getOutput());

        System.out.println("-------------------------------");

        //Ignore go forward to south
        robot.place(2, 0, "SOUTH");
        robot.move();
        robot.report();
        assertEquals("Output: 2,0,SOUTH", robot.getOutput());

        System.out.println("-------------------------------");

        // double placing
        robot.place(2, 4, "NORTH");
        robot.left();
        robot.move();
        robot.place(2, 0, "SOUTH");
        // continuous process
        robot.left();
        robot.move();
        robot.report();
        assertEquals("Output: 3,0,EAST", robot.getOutput());

        System.out.println("-------------------------------");

        //Validate typo
        robot.place(2, 4, "NORTHTypo");
        robot.move();

    }
}