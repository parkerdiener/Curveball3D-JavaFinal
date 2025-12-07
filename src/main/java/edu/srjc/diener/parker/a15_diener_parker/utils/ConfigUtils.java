package edu.srjc.diener.parker.a15_diener_parker.utils;

import javafx.scene.control.Alert;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils
{
    public static Properties loadConfig (String fileName, String className)
    {
        // Properties extends HashTable and stores key-value pairs loaded from .properties file
        // https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
        Properties props = new Properties();

        try
        {
            System.out.println(String.format("Loading %s from %s...", className, fileName));
            props.load(new FileInputStream(fileName));
            System.out.println(String.format("Succesfully loaded %s.", className));
        }
        catch (Exception e)
        {
            UiUtils.messageBox(String.format("Failed to load %s: %s." +
                    "\nUsing default settings.", className, e.getMessage()), Alert.AlertType.ERROR);

            System.out.println(String.format("Error loading %s: %s", className, e.getMessage()));
        }

        return props;
    }

    public static int getIntOrDefault(Properties props, String key, int defaultValue)
    {
        int configValue;
        try
        {
            configValue = Integer.parseInt(props.getProperty(key));
            printValidEntry(key, String.format("%d", configValue));
        }
        catch (Exception e)
        {
            printInvalidEntry(key, String.format("%d", defaultValue));

            configValue = defaultValue;
        }

        return configValue;
    }

    public static double getDoubleOrDefault(Properties props, String key, double defaultValue)
    {
        double configValue;
        try
        {
            configValue = Double.parseDouble(props.getProperty(key));
            printValidEntry(key, String.format("%.2f", configValue));
        }
        catch (Exception e)
        {
            printInvalidEntry(key, String.format("%.2f", defaultValue));
            configValue = defaultValue;
        }

        return configValue;
    }

    public static String getStringOrDefault(Properties props, String key, String defaultValue)
    {
        String configValue;
        try
        {
            configValue = props.getProperty(key);
            printValidEntry(key, configValue);
        }
        catch (Exception e)
        {
            printInvalidEntry(key, defaultValue);
            configValue = defaultValue;
        }

        return configValue;
    }

    private static void printValidEntry(String key, String value)
    {
        System.out.println(String.format("Valid entry for key '%s', using loaded entry." +
                "\n%s=%s",key, key, value));
    }

    private static void printInvalidEntry(String key, String value)
    {
        System.out.println(String.format("Invalid entry for key '%s', using default entry." +
                "\n%s=%s",key, key, value));
    }
}
