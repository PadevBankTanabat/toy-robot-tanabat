import java.util.Scanner;

public class ToyRobotSimulation {
    private int x, y; // current position
    private String facing; // current direction
    StringBuilder output = new StringBuilder(); // text for output

    public ToyRobotSimulation() {
        //undefined placing at first (off the table)
        x = -1;
        y = -1;
        facing = null;
    }

    public boolean place(int x, int y, String facing) {
        if (isValidPosition(x, y) && isValidDirection(facing)) {
            this.x = x;
            this.y = y;
            this.facing = facing;
            return true;
        }
        else {
            output.setLength(0);
            output.append("error!! table's not existed");
            System.out.println("That's not on the table!");

            // for case typo
            this.facing = facing;

            return false;
        }
    }

    public boolean move() {
        if (x == -1 || y == -1 || facing == null) return false;

        int newX = x;
        int newY = y;

        switch (facing) {
            case "NORTH":
                newY++;
                break;
            case "SOUTH":
                newY--;
                break;
            case "EAST":
                newX++;
                break;
            case "WEST":
                newX--;
                break;
            default:
                output.setLength(0);
                output.append("Typo detected. Please try again!");
                System.out.println("Typo detected. Please try again!");
                return false;
        }

        if (isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
            return true;
        } else {
            // Ignore
            this.x = x;
            this.y = y;
            System.out.println("!!!! Move ignored. Robot would fall off the table. !!!!");
            return false;
        }
    }

    public void left() {
        if (x == -1 || y == -1 || facing == null) return;

        switch (facing) {
            case "NORTH":
                facing = "WEST";
                break;
            case "SOUTH":
                facing = "EAST";
                break;
            case "EAST":
                facing = "NORTH";
                break;
            case "WEST":
                facing = "SOUTH";
                break;
        }
    }

    public void right() {
        if (x == -1 || y == -1 || facing == null) return;

        switch (facing) {
            case "NORTH":
                facing = "EAST";
                break;
            case "SOUTH":
                facing = "WEST";
                break;
            case "EAST":
                facing = "SOUTH";
                break;
            case "WEST":
                facing = "NORTH";
                break;
        }
    }

    public void report() {
        if (x == -1 || y == -1 || facing == null) return;

        output.setLength(0);
        output.append("Output: ").append(x).append(",").append(y).append(",").append(facing);
        System.out.println(output.toString());

    }

    private boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < 5) && (y >= 0 && y < 5);
    }

    private boolean isValidDirection(String direction) {
        return direction.equals("NORTH") || direction.equals("SOUTH") || direction.equals("EAST") || direction.equals("WEST");
    }

    public String getOutput() {
        return output.toString();
    }

    public static void main(String[] args) {
        ToyRobotSimulation robot = new ToyRobotSimulation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "PLACE":
                    // validate in case type only "PLACE"
                    if(parts[0].equals("PLACE") && parts[1]==null){
                        System.out.println("Invalid input format for PLACE command. Please try again.");
                        break;
                    }

                    String[] params = parts[1].split(",");

                    // Validate if it's not meet 3 condition (X,Y,F)
                    if (params.length < 3) {
                        System.out.println("Invalid input format for PLACE command. Please try again.");
                        break;
                    }

                    int x = Integer.parseInt(params[0]);
                    int y = Integer.parseInt(params[1]);
                    String facing = params[2];
                    robot.place(x, y, facing);
                    break;
                case "MOVE":
                    robot.move();
                    break;
                case "LEFT":
                    robot.left();
                    break;
                case "RIGHT":
                    robot.right();
                    break;
                case "REPORT":
                    robot.report();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

}