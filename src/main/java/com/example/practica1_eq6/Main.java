package com.example.practica1_eq6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Main extends Application {

    private BorderPane borderPane;
    private VBox vBox;
    private Scene escena;
    private Button btnIniciar, btnSalir;
    private GridPane gridPane;

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
        gridPane = new GridPane();
        btnIniciar = new Button("");
        btnSalir = new Button("");

        btnIniciar.setPrefSize(90,65);
        btnSalir.setPrefSize(90,65);
        gridPane.setPrefSize(250,180);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(gridPane,borderPane);
        borderPane.setLeft(btnIniciar);
        borderPane.setRight(btnSalir);

        btnIniciar.setOnAction(event -> llenadoColores());
        btnSalir.setOnAction(event -> {System.exit(0);});

        agregarImagenIniciar();
        agregarImagenSalir();

        escena = new Scene(vBox, 400, 300);

    }

    private void llenadoColores() {
        System.out.println("Se ejecuta el metodo correspondiente");
    }

    private void agregarImagenIniciar() {
        BackgroundImage myBI= null;
        try {
            myBI = new BackgroundImage(new Image(Main.class.getResource("iniciar.png").toURI().toString(),320,320,false,true),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(1.0, 1.0, true, true, false, false));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        btnIniciar.setBackground(new Background(myBI));
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
