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
import java.util.Random;

public class Main extends Application {

    private BorderPane borderPane;
    private VBox vBox;
    private Scene escena;
    private Button btnGenerarColor_Vaciar, btnSalir;
    private HBox contenedorVasos, contenedorVasos10ml;
    private VBox vaso1, vaso2, vaso3;
    private Label lblLiquido1, lblLiquido2;
    private Label[] lblLiquidosVaso3;
    private Label separadorVasos;
    private int ColoresGenerados;
    private byte contadorVaso100ml = 0;

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
        borderPane = new BorderPane(); // Contenedor donde se muestran los botones de btnGenerarColor y btnSalir
        vBox = new VBox(); // Contenedor principal
        contenedorVasos = new HBox(); // Contenedor donde se muestran todos los vasos
        contenedorVasos10ml = new HBox(); // Contenedor donde se muestran los vasos de 10ml (mas chicos)
        vaso1 = new VBox(); // Contenedor que representa al vaso 1
        vaso2 = new VBox(); // Contenedor que representa al vaso 2
        vaso3 = new VBox(); // Contenedor que representa al vaso 3
        separadorVasos = new Label(""); // label que sirve para generar un espacio entre los vasos de 10ml y el de 100
        btnGenerarColor_Vaciar = new Button("");
        btnSalir = new Button("");
        btnSalir.setDisable(true);

        // Label que muestra el contenido de cada vaso
        lblLiquido1 = new Label();
        lblLiquido2 = new Label();
        lblLiquidosVaso3 = new Label[10];

        for (int i = 0; i < 10; i++) {
            lblLiquidosVaso3[i] = new Label();
        }

        // Se define un ancho y alto preferido para los vasos de 10ml
        lblLiquido1.setPrefSize(80,40);
        lblLiquido2.setPrefSize(80,40);

        // Se le agrega el lbl correspondiente a cada vaso
        vaso1.getChildren().add(lblLiquido1);
        vaso2.getChildren().add(lblLiquido2);

        for (int i = 9; i >= 0; i--) {
           vaso3.getChildren().add(lblLiquidosVaso3[i]);
        }

        //Se le agrega un tamaño preferido a cada boton
        btnGenerarColor_Vaciar.setPrefSize(90,40);
        btnSalir.setPrefSize(90,40);

        // Se agregan paddings y Spacing a los contenedores para obtener el formato adecuado
        contenedorVasos10ml.setPadding(new Insets(95, 0, 0, 0));
        contenedorVasos10ml.setSpacing(30);
        contenedorVasos.setPrefSize(300,180);
        contenedorVasos.setId("panelPadre");
        contenedorVasos.setPadding(new Insets(30, 30, 20, 30));
        contenedorVasos.setSpacing(20);
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);

        // Se agregan paddings y Spacing a los contenedores para obtener el formato adecuado
        vaso1.setPrefSize(60,40);
        vaso1.setId("vaso");
        vaso1.setPadding(new Insets(50,5,0,5));
        vaso1.setSpacing(15);
        vaso2.setPrefSize(60,40);
        vaso2.setId("vaso");
        vaso2.setPadding(new Insets(50, 5, 0, 5));
        vaso2.setSpacing(15);
        vaso3.setPrefSize(80,60);
        vaso3.setId("vaso");
        vaso3.setPadding(new Insets(5));
        vaso3.setSpacing(0);

        separadorVasos.setPrefSize(40,1); // Se define el ancho del separador

        // Se agregan los elementos a los diferentes contenedores
        contenedorVasos10ml.getChildren().addAll(vaso1,vaso2);
        contenedorVasos.getChildren().addAll(contenedorVasos10ml, separadorVasos, vaso3);
        vBox.getChildren().addAll(contenedorVasos,borderPane);

        // Se posicionan los botones en su contenedor de acuerdo al diseño
        borderPane.setPadding(new Insets(0, 20, 0, 20));
        borderPane.setLeft(btnGenerarColor_Vaciar);
        borderPane.setRight(btnSalir);

        // Se agrega los eventos correspondientes a cada boton
        btnGenerarColor_Vaciar.setOnAction(event -> ColocaColor());
        btnSalir.setOnAction(event -> {System.exit(0);});

        // Se agregan las imagenes a los botones mediante los metodos correspondientes
        agregarImagenGenerarColor();
        agregarImagenSalir();

        // Se le agrega el id "generarColor" al boton btnGenerarColor_Vaciar Para saber que imagen contiene
        // y que metodo se realizara al ser presionado
        btnGenerarColor_Vaciar.setId("generarColor");

        escena = new Scene(vBox, 400, 340);

        //Se le agrega un Stylesheet a la escena
        escena.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    }

    //Metodo que compara el liquido de los 2 vasos de 10ml y los vacia en el de 100ml
    private void vaciarColores() {
        String color = "";
        if (lblLiquido1.getText() == lblLiquido2.getText()) {
            color = lblLiquido1.getText();
        } else {
            switch (lblLiquido1.getText()) {
                case "rojo":
                    if (lblLiquido2.getText().equals("azul")) {
                        color = "lila";
                    } else {
                        color = "naranja";
                    }
                    break;
                case "azul":
                    if (lblLiquido2.getText().equals("rojo")) {
                        color = "lila";
                    } else {
                        color = "verde";
                    }
                    break;
                case "amarillo":
                    if (lblLiquido2.getText().equals("rojo")) {
                        color = "naranja";
                    } else {
                        color = "verde";
                    }
                    break;
            }
        }

        lblLiquidosVaso3[contadorVaso100ml].setText(color);
        contadorVaso100ml++;
        lblLiquidosVaso3[contadorVaso100ml].setText(color);
        contadorVaso100ml++;

        lblLiquido1.setText("");
        lblLiquido2.setText("");

        // cuando el contador llega a 10 significa que el vaso de 100ml esta lleno
        if (contadorVaso100ml == 10) {
            btnGenerarColor_Vaciar.setDisable(true); // se desabilita el boton de generar/vaciar
        }
    }

    private String GeneraColor() {
        Random rnd = new Random();
        String[] Colores = {"rojo", "amarillo", "azul"};//crea el string con colores
        int Indice;//variable indicadora
        String Color;//variable dondd se almacena el color
        Indice= (int) (rnd.nextDouble() * 3);
        Color= Colores[Indice];
        return Color;
    }

    //Metodo que coloca el color generado en el vaso 1 y 2
    private void ColocaColor(){
        String Color = GeneraColor();
        ColoresGenerados++;
        switch (ColoresGenerados){
            case 1:
                lblLiquido1.setText(Color);
                break;
            case 2:
                lblLiquido2.setText(Color);
                definirBoton();
                break;
            case 3:
                vaciarColores();
                btnSalir.setDisable(false);
                definirBoton();
                ColoresGenerados = 0;
                break;
        }
    }

    // Se maneja la imagen del boton y que accion realizara
    private void definirBoton() {
        // Se obtiene el estado del boton, es decir que funcion debe realizar
        if (btnGenerarColor_Vaciar.getId().equals("generarColor")) {
            // Se le cambia la imagen a la de vaciar
            agregarImagenVaciar();
            // Se cambia el Id del boton para saber que ahora tomara la funcion del boton vaciar
            btnGenerarColor_Vaciar.setId("vaciar");
        }else {
            // Se le cambia la imagen a la de generarColor
            agregarImagenGenerarColor();
            // Se cambia el Id del boton para saber que ahora tomara la funcion del boton generarColor
            btnGenerarColor_Vaciar.setId("generarColor");
        }
    }


    // Agrega la imagen especificada al boton btnGenerarColor_Vaciar
    private void agregarImagenGenerarColor() {
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
        btnGenerarColor_Vaciar.setBackground(new Background(myBI));
    }

    // Agrega la imagen especificada al boton btnGenerarColor_Vaciar
    private void agregarImagenVaciar() {
        BackgroundImage myBI= null;
        try {
            myBI = new BackgroundImage(new Image(Main.class.getResource("vaciar.png").toURI().toString(),320,320,false,true),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(1.0, 1.0, true, true, false, false));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        btnGenerarColor_Vaciar.setBackground(new Background(myBI));
    }

    // Agrega la imagen especificada al botn btnSalir
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
