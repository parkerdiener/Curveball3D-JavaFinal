package edu.srjc.diener.parker.a15_diener_parker.world;

import javafx.animation.AnimationTimer;
import javafx.scene.transform.Rotate;

public class GameController
{
    GameWorld world;
    private final AnimationTimer gameLoop;


    public GameController(GameWorld gameWorld)
    {
        world = gameWorld;
        gameLoop = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                updateWorld(now);
            }
        };

        start();
    }

    public void start()
    {
        gameLoop.start();
    }

    public void stop()
    {
        gameLoop.stop();
    }

    private void updateWorld(long now)
    {
        world.spin(world.getTestCube(), 1, Rotate.Y_AXIS);
    }
}
