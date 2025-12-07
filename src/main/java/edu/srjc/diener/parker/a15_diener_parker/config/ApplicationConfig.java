package edu.srjc.diener.parker.a15_diener_parker.config;
import edu.srjc.diener.parker.a15_diener_parker.utils.ConfigUtils;
import java.util.Properties;

public class ApplicationConfig
{
    private final int sceneWidth;
    private final int sceneHeight;
    private final String sceneTitle;

    public ApplicationConfig(String fileName)
    {
        Properties settings = ConfigUtils.loadConfig(fileName, getClass().getSimpleName());

        sceneWidth = ConfigUtils.getIntOrDefault(settings,"sceneWidth", 1024);
        sceneHeight = ConfigUtils.getIntOrDefault(settings,"sceneHeight", 768);
        sceneTitle = ConfigUtils.getStringOrDefault(settings,"sceneTitle", "Curve Ball 3D");
    }

    public int getWidth()
    {
        return sceneWidth;
    }

    public int getHeight()
    {
        return sceneHeight;
    }

    public String getTitle()
    {
        return sceneTitle;
    }
}
