package Chapter8;

public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;

    private int[][] maze = {{1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1}};

    public int[][] grid;

//-----------------------------------------------------------------
// Creates a working copy of the maze to compute the final solution.
// The original maze is not modified. Calls traverse to recursively
// traverse the maze.
//-----------------------------------------------------------------
    public boolean traverseMaze (int row, int column) {
// make copy
        grid = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                grid[i][j] = maze[i][j];
            }
        }
    
        return traverse(row, column);
    }

//-----------------------------------------------------------------
// Attempts to recursively traverse the maze. Inserts special
// characters indicating locations that have been tried and that
// eventually become part of the solution.
//-----------------------------------------------------------------
    private boolean traverse (int row, int column) {
        boolean done = false;

        if (valid (row, column)) {
            grid[row][column] = TRIED;// this cell has been tried

            if (row == grid.length-1 && column == grid[0].length-1) {
                done = true; // the maze is solved
            } else {
                done = traverse (row+1, column); // down
                if (!done) {
                    done = traverse (row, column+1); // right
                }
                if (!done) {
                    done = traverse (row-1, column);// up
                }
                if (!done) {
                    done = traverse (row, column-1); // left
                }
            }

            if (done) {
                grid[row][column] = PATH;
                System.out.println("[" + row + "], [" + column + "]");
            }
        }

        return done;
    }

//-----------------------------------------------------------------
// Determines if a specific location is valid.
//-----------------------------------------------------------------
    private boolean valid (int row, int column) {
        boolean result = false;

// check if cell is in the bounds of the matrix
    if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)

// check if cell is not blocked and not previously tried
        if (grid[row][column] == 1)
            result = true;

            return result;
    }
    
//-----------------------------------------------------------------
// Returns the maze as a string.
//-----------------------------------------------------------------
    public String toString () {
        String result = "\n";

        for (int row=0; row < maze.length; row++) {
            for (int column=0; column < maze[row].length; column++)
            result += maze[row][column] + "";
            result += "\n";
        }
    
        return result;
    }
}