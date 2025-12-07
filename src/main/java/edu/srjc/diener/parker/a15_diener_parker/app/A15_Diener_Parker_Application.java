package edu.srjc.diener.parker.a15_diener_parker.app;

import edu.srjc.diener.parker.a15_diener_parker.config.ApplicationConfig;
import edu.srjc.diener.parker.a15_diener_parker.world.GameController;
import edu.srjc.diener.parker.a15_diener_parker.world.GameWorld;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;

public class A15_Diener_Parker_Application extends Application
{
    // Use config file for global settings
    // https://www.geeksforgeeks.org/java/reading-and-writing-properties-file-in-java/
    ApplicationConfig appConfig;

    GameWorld world;
    GameController controller;

    @Override
    public void start(Stage stage)
    {
        System.out.println("Application started, generating ApplicationConfig...");
        appConfig  = new ApplicationConfig("gameData/application.properties");

        world = new GameWorld();
        controller = new GameController(world);

        stage.setResizable(false);
        Scene scene = new Scene(createGameScene());

//        scene.setOnMouseMoved(event ->
//        {
//            updatePaddle(event.getX());
//        });

        stage.setScene(scene);
        stage.setTitle(appConfig.getTitle());
        stage.show();

        controller.start();
    }

    public Parent createGameScene()
    {
        // Use a SubScene
        // credit: https://docs.oracle.com/javase/8/javafx/graphics-tutorial/camera.htm
        SubScene subScene = new SubScene(world.getRoot(), appConfig.getWidth(),
                                         appConfig.getHeight(), true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.ALICEBLUE);
        subScene.setCamera(world.getCamera());

        return new Group(subScene);
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
