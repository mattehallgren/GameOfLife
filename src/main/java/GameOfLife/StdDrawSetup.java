package GameOfLife;

import edu.princeton.cs.introcs.StdDraw;

public class StdDrawSetup implements GameOfLifeView {
    private final int width;
    private final int height;

    public StdDrawSetup(final int width, final int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("height and width must be a positive value");
        }
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setYscale(0, height);
        StdDraw.setXscale(0, width);
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
