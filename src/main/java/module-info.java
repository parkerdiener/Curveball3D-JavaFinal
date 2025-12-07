module edu.srjc.diener.parker.a15_diener_parker {
    requires javafx.graphics;
    requires javafx.controls;


    opens edu.srjc.diener.parker.a15_diener_parker to javafx.fxml;
    exports edu.srjc.diener.parker.a15_diener_parker;
    exports edu.srjc.diener.parker.a15_diener_parker.utils;
    opens edu.srjc.diener.parker.a15_diener_parker.utils to javafx.fxml;
    exports edu.srjc.diener.parker.a15_diener_parker.app;
    opens edu.srjc.diener.parker.a15_diener_parker.app to javafx.fxml;
}