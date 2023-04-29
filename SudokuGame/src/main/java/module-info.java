module com.example.sudokugame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.sudokugame to javafx.fxml;
    exports com.example.sudokugame;
}