module org.example.paszportfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.paszportfx to javafx.fxml;
    exports org.example.paszportfx;
}