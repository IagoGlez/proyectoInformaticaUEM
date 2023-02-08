package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PPT extends Application {
	private String opcionJugador;
	private String opcionRival;
	private String ganador;

public static void main(String[] args) {
	launch(args);
	//Return 0 or 1 dependiendo de victoria y devuelve a  menu
	}
@Override
public void start(Stage stage) {
	try {
		Label labelInicial = new Label("Selecciona una de las 3 opciones: ¡Piedra, Papel o Tijera!\n ");
		Label labelSeleccion = new Label("");
		Button buttonPiedra = new Button("Piedra");
		Button buttonPapel = new Button("Papel");
		Button buttonTijera = new Button("Tijera");
		HBox hBoxSeleccion = new HBox(buttonPiedra, buttonPapel, buttonTijera);
		hBoxSeleccion.setAlignment(Pos.CENTER);
		VBox vBoxSeleccion = new VBox(labelInicial, hBoxSeleccion,labelSeleccion);
		vBoxSeleccion.setAlignment(Pos.CENTER);
		Scene escena = new Scene(vBoxSeleccion, 400, 300);
		stage.setScene(escena);
		stage.setTitle("Piedra papel tijera");
		stage.show();
		buttonPiedra.setOnAction(e -> {
			opcionRival = eleccionRandom();
			opcionJugador = "Piedra";
			ganador = comprobarGanador();
			labelSeleccion.setText(mensajeFinal());
		});
		buttonPapel.setOnAction(e -> {
			opcionRival = eleccionRandom();
			opcionJugador = "Papel";
			ganador = comprobarGanador();
			labelSeleccion.setText(mensajeFinal());
		});
		buttonTijera.setOnAction(e -> {
			opcionRival = eleccionRandom();
			opcionJugador = "Tijera";
			ganador = comprobarGanador();
			labelSeleccion.setText(mensajeFinal());
		});
	} catch(Exception e) {
		e.printStackTrace();
	}
}
private String mensajeFinal() {
	return "\n Jugador selecciona: " + opcionJugador + ".\n"
	+ " El rival selecciona: " + opcionRival + ".\n"
	+ " El resultado es... " + ganador + "!";
}
private String comprobarGanador() {
	if (opcionJugador.equals("Piedra")) {
		if (opcionRival.equals("Piedra")) {
			return "EMPATE";
		} else if (opcionRival.equals("Papel")) {
			return "DERROTA";
		} else {
			return "VICTORIA";
	}
} else if (opcionJugador.equals("Papel")) {
	if (opcionRival.equals("Piedra")) {
		return "VICTORIA";
	} else if (opcionRival.equals("Papel")) {
		return "EMPATE";
	} else {
		return "DERROTA";
	}
	} else {
	if (opcionRival.equals("Piedra")) {
		return "DERROTA";
	} else if (opcionRival.equals("Papel")) {
		return "VICTORIA";
	} else {
		return "EMPATE";
	}
	}
}
private String eleccionRandom() {
	 int randomNumber = (int) (Math.random() * 3);
	 switch (randomNumber) {
		case 0:
			return "Piedra";
		case 1:
			return "Papel";
		default:
			return "Tijera";
		}
	}
}