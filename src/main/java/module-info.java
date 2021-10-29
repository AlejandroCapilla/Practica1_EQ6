module com.example.practica1_eq6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica1_eq6 to javafx.fxml;
    exports com.example.practica1_eq6;
}