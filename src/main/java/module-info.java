module org.adrian.gamedemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.adrian.gamedemo to javafx.fxml;
    exports org.adrian.gamedemo;
}