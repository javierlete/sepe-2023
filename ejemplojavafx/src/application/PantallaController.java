package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PantallaController {
	@FXML
	private Button btnPulsar;

	@FXML
	void onPulsar(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Hola");
	}
}
