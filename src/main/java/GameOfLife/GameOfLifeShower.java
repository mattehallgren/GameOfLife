package GameOfLife;

import java.util.Timer;
import java.util.TimerTask;

public class GameOfLifeShower {
    private Generation currentGeneration;
    private TimerTask task;

    public GameOfLifeShower(final GameOfLifeView view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null!");
        }
        currentGeneration = new Generation(view.getHeight(),view.getWidth());
    }

    public void start() {
        task = new TimerTask() {
            @Override
            public void run() {
                currentGeneration = currentGeneration.progress();
                currentGeneration.draw();
            }
        };
        new Timer().schedule(task, 0, 15);
    }
}
