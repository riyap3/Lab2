import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);



        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        for (int step = 0; step < 1000; step++) {
            // Implement your maze solving algorithm here
        }
        while (maze.isFinished() == false) {

            Boolean canTurnRight = false;
            Boolean canTurnLeft = false;
            Boolean canGoStraight = false;
            Boolean deadEnd = false;

// Checking every direction to see where we can move and how many options.

            if (maze.canMove()) {
                canGoStraight = true;
            }
            maze.turnRight();
            if (maze.canMove()) {
                canTurnRight = true;
            }
            maze.turnRight();
            maze.turnRight();
            if (maze.canMove()) {
                canTurnLeft = true;
            }
// if you can’t turn anywhere it is a dead end and you need to turn around.

            if (canTurnRight == false && canTurnLeft == false &&
                    canGoStraight == false) {
                deadEnd = true;
            }
            if (deadEnd) {
                maze.turnLeft();   //ended checking where we can turn while looking left.
                maze.move();
            } else if (canTurnRight) {
                maze.turnLeft();
                maze.turnLeft();
                maze.move();
            } else if (canGoStraight) {
                maze.turnRight();
                maze.move();
            } else if (canTurnLeft) {
                maze.move();
            }

        }

        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }
    }
}
