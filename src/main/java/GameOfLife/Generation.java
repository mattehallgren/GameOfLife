package GameOfLife;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Arrays;
import java.util.Random;

public class Generation {
    private boolean[][] generation;

    public Generation(final boolean[][] generation) {
        this.generation = generation;
    }
    public Generation(int height, int width) {
        generation = new boolean[height][width];
        final Random random = new Random();
        for (int row = 0; row < generation.length; ++row) {
            for (int col = 0; col < generation[row].length; ++col) {
                generation[row][col] = random.nextBoolean();
            }
        }
    }

    public Generation progress() {
        return clone().next(this);
    }

    public boolean equals(Object o) {
        if (o instanceof Generation) {
            return Arrays.deepEquals(generation, ((Generation) o).generation);
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(generation);
    }

    private Generation next(Generation previous) {
        for (int row = 0; row < generation.length; ++row) {
            for (int col = 0; col < generation[row].length; ++col) {
                final int numNeighbors = previous.countNeighbors(row, col);
                if ((numNeighbors < 2) || (numNeighbors > 3)) {
                    generation[row][col] = false;
                }
                if (numNeighbors == 2) {
                    generation[row][col] = generation[row][col];
                }
                if (numNeighbors == 3) {
                    generation[row][col] = true;
                }
            }
        }
        return this;
    }

    public Generation clone() {
        final boolean[][] newGeneration = new boolean[generation.length][];
        for (int row = 0; row < generation.length; ++row) {
            newGeneration[row] = Arrays.copyOf(generation[row], generation[row].length);
        }
        return new Generation(newGeneration);
    }

    private int countNeighbors(int row, int col) {

        int numNeighbors = 0;

        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            if (generation[row - 1][col - 1]) {
                numNeighbors++;
            }
        }
        if ((row >= 0) && (col - 1 >= 0)) {
            if (generation[row][col - 1]) {
                numNeighbors++;
            }
        }
        if ((row + 1 < generation.length) && (col - 1 >= 0)) {
            if (generation[row + 1][col - 1]) {
                numNeighbors++;
            }
        }
        if ((row + 1 < generation.length) && (col < generation[0].length)) {
            if (generation[row + 1][col]) {
                numNeighbors++;
            }
        }
        if ((row + 1 < generation.length) && (col + 1 < generation[0].length)) {
            if (generation[row + 1][col + 1]) {
                numNeighbors++;
            }

        }
        if ((row < generation.length) && (col + 1 < generation[0].length)) {
            if (generation[row][col + 1]) {
                numNeighbors++;
            }
        }
        if ((row - 1 >= 0) && (col + 1 < generation[0].length)) {
            if (generation[row - 1][col + 1]) {
                numNeighbors++;
            }

        }
        if ((row - 1 >= 0) && (col < generation[0].length)) {
            if (generation[row - 1][col]) {
                numNeighbors++;
            }
        }
        return numNeighbors;
    }

    void draw() {
        StdDraw.show(0);
        StdDraw.clear();
        for (int row = 0; row < generation.length; row++) {
            for (int col = 0; col < generation[row].length; col++) {
                if (generation[row][col]) {
                    StdDraw.point(col, row);
                }
            }
        }
        StdDraw.show(0);
    }
}
