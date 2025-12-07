package edu.srjc.diener.parker.a15_diener_parker.config;

import edu.srjc.diener.parker.a15_diener_parker.utils.ConfigUtils;
import edu.srjc.diener.parker.a15_diener_parker.utils.UiUtils;
import javafx.scene.control.Alert;

import java.io.FileInputStream;
import java.util.Properties;

public class GameWorldConfig
{
    private final double ballRadius;

    public GameWorldConfig(String fileName)
    {
        Properties settings = ConfigUtils.loadConfig(fileName, getClass().getSimpleName());

        ballRadius = ConfigUtils.getDoubleOrDefault(settings,"ballRadius", 2.5);
    }

    public double getBallRadius()
    {
        return ballRadius;
    }
}
