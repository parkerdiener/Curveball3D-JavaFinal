package edu.srjc.diener.parker.a15_diener_parker.objects;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;

public class Curveball
{
    private final Sphere ball;

    public Curveball(double radius)
    {
        // TODO: pull from GameWorldConfig
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setSpecularColor(Color.RED);
        redMaterial.setDiffuseColor(Color.BLUE);

        ball = new Sphere(radius);
        ball.setMaterial(redMaterial);
        ball.setDrawMode(DrawMode.FILL);
    }
}
