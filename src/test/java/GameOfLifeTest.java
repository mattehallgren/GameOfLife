import GameOfLife.GameOfLifeShower;
import GameOfLife.GameOfLifeView;
import GameOfLife.Generation;
import GameOfLife.StdDrawSetup;
import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {
    private static final int negative_HEIGHT = -3;
    private static final int negative_WIDTH = -3;

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeightWidth() {
        final GameOfLifeView gameOfLifeViewNegative = new StdDrawSetup(negative_WIDTH, negative_HEIGHT);
        final GameOfLifeShower gameOfLifeShowerNegative = new GameOfLifeShower(gameOfLifeViewNegative);
        gameOfLifeShowerNegative.start();
    }

    @Test
    public void testGeneration3NeighborsReproduce() {
        //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        boolean[][] original = new boolean[5][5];
        original[0][2] = false;
        original[1][1] = true;
        original[1][2] = true;
        original[1][3] = true;

        boolean[][] expected = new boolean[5][5];
        expected[0][2] = true;
        expected[1][2] = true;
        expected[2][2] = true;
        Assert.assertEquals(new Generation(expected), new Generation(original).progress());
    }

    @Test
    public void testGeneration2Neighbors() {
        //Any live cell with two live neighbors lives on to the next generation.
        boolean[][] original = new boolean[5][5];
        original[1][0] = true;
        original[1][1] = true;
        original[1][2] = true;

        boolean[][] expected = new boolean[5][5];
        expected[0][0] = false;
        expected[0][1] = false;
        expected[0][2] = false;
        expected[2][0] = false;
        expected[2][1] = true;
        expected[2][2] = false;
        expected[0][1] = true;
        expected[1][1] = true;
        expected[1][2] = false;
        Assert.assertEquals(new Generation(expected), new Generation(original).progress());
    }

    @Test
    public void testGeneration3Neighbors() {
        //Any live cell with three live neighbors lives on to the next generation.
        boolean[][] original = new boolean[5][5];
        original[0][2] = true;
        original[1][1] = true;
        original[1][2] = true;
        original[1][3] = true;

        boolean[][] expected = new boolean[5][5];
        expected[0][1] = true;
        expected[0][2] = true;
        expected[0][3] = true;
        expected[1][1] = true;
        expected[1][2] = true;
        expected[1][3] = true;
        expected[2][2] = true;
        Assert.assertEquals(new Generation(expected), new Generation(original).progress());
    }

    @Test
    public void testGenerationLessThan2NeighborsDies() {
        //Any live cell with fewer than two live neighbors dies, as if by underpopulation.
        boolean[][] original = new boolean[5][5];
        original[1][0] = true;
        original[1][1] = false;
        original[1][2] = false;

        boolean[][] expected = new boolean[5][5];
        expected[0][0] = false;
        expected[0][1] = false;
        expected[0][2] = false;
        expected[0][3] = false;
        expected[0][4] = false;
        expected[1][0] = false;
        expected[1][1] = false;
        expected[1][2] = false;
        expected[1][3] = false;
        expected[1][4] = false;
        expected[2][0] = false;
        expected[2][1] = false;
        expected[2][2] = false;
        expected[2][3] = false;
        expected[2][4] = false;
        expected[3][0] = false;
        expected[3][1] = false;
        expected[3][2] = false;
        expected[3][3] = false;
        expected[3][4] = false;
        expected[4][0] = false;
        expected[4][1] = false;
        expected[4][2] = false;
        expected[4][3] = false;
        expected[4][4] = false;
        Assert.assertEquals(new Generation(expected), new Generation(original).progress());
    }

    @Test
    public void testGenerationOverpopulationDies() {
        //Any live cell with more than three live neighbors dies, as if by overpopulation.
        boolean[][] original = new boolean[5][5];
        original[0][0] = true;
        original[0][1] = true;
        original[0][2] = true;
        original[0][3] = true;
        original[0][4] = true;

        boolean[][] expected = new boolean[5][5];
        expected[0][0] = false;
        expected[0][1] = true;
        expected[0][2] = true;
        expected[0][3] = true;
        expected[0][4] = false;
        expected[1][0] = false;
        expected[1][1] = true;
        expected[1][2] = true;
        expected[1][3] = true;
        expected[1][4] = false;
        expected[2][0] = false;
        expected[2][1] = false;
        expected[2][2] = false;
        expected[2][3] = false;
        expected[2][4] = false;
        expected[3][0] = false;
        expected[3][1] = false;
        expected[3][2] = false;
        expected[3][3] = false;
        expected[3][4] = false;
        expected[4][0] = false;
        expected[4][1] = false;
        expected[4][2] = false;
        expected[4][3] = false;
        expected[4][4] = false;
        Assert.assertEquals(new Generation(expected), new Generation(original).progress());
    }
}
