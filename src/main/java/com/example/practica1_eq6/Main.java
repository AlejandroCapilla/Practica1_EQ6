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
    private Button btnIniciar, btnSalir;
    private HBox contenedorVasos;
    private VBox vaso1, vaso2, vaso3;
    private Label lblVaso1sup, lblVaso1inf, lblVaso2sup, lblVaso2inf, lblVaso3sup, lblVaso3inf;

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
        contenedorVasos = new HBox();
        vaso1 = new VBox();
        vaso2 = new VBox();
        vaso3 = new VBox();
        btnIniciar = new Button("");
        btnSalir = new Button("");
        lblVaso1sup = new Label();
        lblVaso2sup = new Label();
        lblVaso3sup = new Label();
        lblVaso1inf = new Label();
        lblVaso2inf = new Label();
        lblVaso3inf = new Label();

        lblVaso1inf.setPrefSize(80,40);
        lblVaso1sup.setPrefSize(80,40);

        lblVaso2inf.setPrefSize(80,40);
        lblVaso2sup.setPrefSize(80,40);

        lblVaso3inf.setPrefSize(80,40);
        lblVaso3sup.setPrefSize(80,40);

        vaso1.getChildren().addAll(lblVaso1sup,lblVaso1inf);
        vaso2.getChildren().addAll(lblVaso2sup,lblVaso2inf);
        vaso3.getChildren().addAll(lblVaso3sup,lblVaso3inf);

        btnIniciar.setPrefSize(90,65);
        btnSalir.setPrefSize(90,65);
        contenedorVasos.setPrefSize(300,180);
        contenedorVasos.setId("panelPadre");
        contenedorVasos.setPadding(new Insets(30));
        contenedorVasos.setSpacing(20);

        vaso1.setPrefSize(100,60);
        vaso1.setId("vaso");
        vaso1.setPadding(new Insets(10));
        vaso1.setSpacing(15);

        vaso2.setPrefSize(100,60);
        vaso2.setId("vaso");
        vaso2.setPadding(new Insets(10));
        vaso2.setSpacing(15);

        vaso3.setPrefSize(100,60);
        vaso3.setId("vaso");
        vaso3.setPadding(new Insets(10));
        vaso3.setSpacing(15);

        contenedorVasos.getChildren().addAll(vaso1, vaso2, vaso3);

        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(contenedorVasos,borderPane);
        borderPane.setLeft(btnIniciar);
        borderPane.setRight(btnSalir);

        btnIniciar.setOnAction(event -> llenadoColores());
        btnSalir.setOnAction(event -> {System.exit(0);});

        agregarImagenIniciar();
        agregarImagenSalir();

        escena = new Scene(vBox, 400, 300);
        escena.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

    }

    private void llenadoColores() {
        System.out.println("Se ejecuta el metodo correspondiente");
        btnIniciar.setDisable(true);
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
