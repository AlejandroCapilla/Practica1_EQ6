package com.example.practica1_eq6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Main extends Application {

    private BorderPane borderPane;
    private VBox vBox;
    private Scene escena;
    private Button btnGenerarColor, btnSalir;
    private HBox contenedorVasos, contenedorVasos10ml;
    private VBox vaso1, vaso2, vaso3;
    private Label lblLiquido1, lblLiquido2, lblLiquido3;
    private Label separadorVasos;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        crearUI();
        stage.setTitle("Practica1_Eq6");
        stage.setScene(escena);
        stage.show();
    }

    private void crearUI() {
        borderPane = new BorderPane();
        vBox = new VBox();
        contenedorVasos = new HBox(); // Contenedor donde se muestran todos los vasos
        contenedorVasos10ml = new HBox(); // Contenedor donde se muestran los vasos de 10ml (mas chicos)
        vaso1 = new VBox();
        vaso2 = new VBox();
        vaso3 = new VBox();
        separadorVasos = new Label(""); // label que sirve para generar un espacio entre los vasos de 10ml y el de 100
        btnGenerarColor = new Button("");
        btnSalir = new Button("");
        // Label que muestra el contenido de cada vaso
        lblLiquido1 = new Label();
        lblLiquido2 = new Label();
        lblLiquido3 = new Label();

        lblLiquido1.setPrefSize(80,40);
        lblLiquido2.setPrefSize(80,40);

        vaso1.getChildren().add(lblLiquido1);
        vaso2.getChildren().add(lblLiquido2);

        btnGenerarColor.setPrefSize(90,40);
        btnSalir.setPrefSize(90,40);

        contenedorVasos10ml.setPadding(new Insets(35, 0, 0, 0));
        contenedorVasos10ml.setSpacing(30);

        contenedorVasos.setPrefSize(300,180);
        contenedorVasos.setId("panelPadre");
        contenedorVasos.setPadding(new Insets(30, 30, 20, 30));
        contenedorVasos.setSpacing(20);

        vaso1.setPrefSize(60,40);
        vaso1.setId("vaso");
        vaso1.setPadding(new Insets(10));
        vaso1.setSpacing(15);

        vaso2.setPrefSize(60,40);
        vaso2.setId("vaso");
        vaso2.setPadding(new Insets(10));
        vaso2.setSpacing(15);

        vaso3.setPrefSize(80,60);
        vaso3.setId("vaso");
        vaso3.setPadding(new Insets(10));
        vaso3.setSpacing(15);

        separadorVasos.setPrefSize(40,1);

        contenedorVasos10ml.getChildren().addAll(vaso1,vaso2);
        contenedorVasos.getChildren().addAll(contenedorVasos10ml, separadorVasos, vaso3);

        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(contenedorVasos,borderPane);

        borderPane.setPadding(new Insets(0, 20, 0, 20));
        borderPane.setLeft(btnGenerarColor);
        borderPane.setRight(btnSalir);

        btnGenerarColor.setOnAction(event -> llenadoColores());
        btnSalir.setOnAction(event -> {System.exit(0);});

        agregarImagenIniciar();
        agregarImagenSalir();

        escena = new Scene(vBox, 400, 270);
        escena.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    }

    private void llenadoColores() {
        btnGenerarColor.setDisable(true);
    }

    private void agregarImagenIniciar() {
        BackgroundImage myBI= null;
        try {
            myBI = new BackgroundImage(new Image(Main.class.getResource("generarColor.png").toURI().toString(),320,320,false,true),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(1.0, 1.0, true, true, false, false));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        btnGenerarColor.setBackground(new Background(myBI));
    }

    private void agregarImagenSalir() {
        BackgroundImage myBI= null;
        try {
            myBI = new BackgroundImage(new Image(Main.class.getResource("salir.png").toURI().toString(),320,320,false,true),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(1.0, 1.0, true, true, false, false));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        btnSalir.setBackground(new Background(myBI));
    }

}
