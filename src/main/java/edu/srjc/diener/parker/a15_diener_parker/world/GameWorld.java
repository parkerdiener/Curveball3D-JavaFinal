package edu.srjc.diener.parker.a15_diener_parker.world;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

// I used a lot of information for setting up 3d scene using sample code and information from
// https://docs.oracle.com/javase/8/javafx/graphics-tutorial/javafx-3d-graphics.htm#CHDGHHEJ

public class GameWorld
{
    private final Group root;
    private final PerspectiveCamera camera;

    // GameWorldConfig;

//    private final Tunnel tunnel;
//    private final Curveball ball;
//    private final UserPaddle userPaddle;
//    private final AIPaddle aiPaddle;

    private Box testCube;

    public GameWorld() {

        // initialize root and add camera
        camera = new PerspectiveCamera(true);
        root = new Group(camera);

        // initialize everything else
//        initBall();
//        initPaddles();
//        initTunnel();


        testCube = testCube();
    }

    private void updateWorld(long now)
    {
        // ball movement
        // paddle movement
        // collisions

        spin(testCube, 1, Rotate.Y_AXIS);
        spin(testCube, 1, Rotate.X_AXIS);
        spin(testCube, 1, Rotate.Z_AXIS);
    }

    public Group getRoot()
    {
        return root;
    }

    public PerspectiveCamera getCamera()
    {
        return camera;
    }


    // test function adding a box to the scene
    // call during constructor after camera object is defined
    private Box testCube()
    {
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setSpecularColor(Color.RED);
        redMaterial.setDiffuseColor(Color.BLUE);

        final Box testBox = new Box(5, 5, 5);
        testBox.setMaterial(redMaterial);
        testBox.setDrawMode(DrawMode.FILL);

        // to see box
        camera.getTransforms().addAll(
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -15));

        root.getChildren().add(testBox);

        return testBox;
    }

    public Box getTestCube()
    {
        return testCube;
    }

    public void spin(Shape3D objectToSpin, double angle, Point3D axis)
    {
        objectToSpin.getTransforms().add(new Rotate(angle, axis));
    }
}
