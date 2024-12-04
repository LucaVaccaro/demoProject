module org.example.programmingproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.programmingproject2 to javafx.fxml;
    exports org.example.programmingproject2;
}