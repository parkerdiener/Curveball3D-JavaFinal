/*
Name: Parker Diener
Email: pdiener@bearcubs.santarosa.edu
Date: 6 December 2025
Project Name: A15 - Curveball 3D
Course: CS 17.11 Java Programming
Description: Provides reusable UI helper functions, such as
             displaying pop-up messages or confirmation dialogs.
*/

package edu.srjc.diener.parker.a15_diener_parker.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class UiUtils
{

    public static void messageBox(String message, Alert.AlertType alertType)
    {
        Alert alert = new Alert(alertType, message, ButtonType.OK);
        alert.setResizable(true);
        alert.showAndWait();
    }

    public static void messageBox(String message)
    {
        Alert alert = new Alert(Alert.AlertType.NONE, message, ButtonType.OK);
        alert.setResizable(true);
        alert.showAndWait();
    }

    public static ButtonType yesNoAnswerBox(String message, String title, Alert.AlertType alertType)
    {
        Alert alert = new Alert(alertType, title, ButtonType.YES, ButtonType.NO);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.setResizable(true);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }

    public static ButtonType yesNoAnswerBox(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.YES, ButtonType.NO);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.setResizable(true);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }
}
