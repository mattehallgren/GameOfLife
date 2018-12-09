package GameOfLife;

public class GameOfLifeRunner {

    private GameOfLifeRunner(final int width, final int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("height and width must be a positive value");
        }
        final GameOfLifeView gameOfLifeView = new StdDrawSetup(width, height);
        final GameOfLifeShower gameOfLifeShower = new GameOfLifeShower(gameOfLifeView);
        gameOfLifeShower.start();
    }

    public static void main(final String... args) {
        new GameOfLifeRunner(1337, 666);
    }
}
