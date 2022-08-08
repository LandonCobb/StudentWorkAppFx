module com.example.studentworkappfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentworkappfx to javafx.fxml;
    exports com.example.studentworkappfx;
}