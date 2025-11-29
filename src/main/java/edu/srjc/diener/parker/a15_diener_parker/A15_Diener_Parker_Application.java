package edu.srjc.diener.parker.a15_diener_parker;

import edu.srjc.diener.parker.a15_diener_parker.model.GameWorld;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;

public class A15_Diener_Parker_Application extends Application
{


    private static int SCENE_WIDTH = 1024;
    private static int SCENE_HEIGHT = 768;


    public Parent createGame()
    {
        GameWorld world = new GameWorld();

        // Use a SubScene
        SubScene subScene = new SubScene(world.getRoot(), SCENE_WIDTH, SCENE_HEIGHT, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.ALICEBLUE);
        subScene.setCamera(world.getCamera());
        return new Group(subScene);
    }

    @Override
    public void start(Stage stage)
    {

        stage.setResizable(false);
        Scene scene = new Scene(createGame());

        stage.setScene(scene);
        stage.setTitle("Curveball 3D");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
