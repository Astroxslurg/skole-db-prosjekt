package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ProgramController {
	
	
	@FXML RadioButton ovelse_styrke_knapp;
	@FXML RadioButton ovelse_kondisjon_knapp;
	@FXML TextField ovelse_navn;
	@FXML TextArea ovelse_beskrivelse;
	@FXML ToggleGroup ovelse_type;
	
	@FXML RadioButton kondisjon_knapp;
	@FXML RadioButton styrke_knapp;
	@FXML ToggleGroup type_mal;
	@FXML TextField styrke_bosk_belastning;
	@FXML TextField styrke_boks_repetisjoner;
	@FXML TextField styrke_bosk_sett;
	@FXML TextField kondisjon_boks_lengde;
	@FXML TextField kondisjon_boks_tid;
	@FXML MenuButton gruppe;
	@FXML DatePicker startdato;
	@FXML DatePicker maldato;
	@FXML DatePicker naddato;
	@FXML Label styrke_belastning;
	@FXML Label styrke_repetisjoner;
	@FXML Label styrke_sett;
	@FXML Label kondisjon_lengde;
	@FXML Label kondisjon_tid;
	
	
	
	@FXML
	void styrkeButtonIsActivated(Event event) {
		
	}
	
	@FXML
	private void submitExercise(){
		
		Database.insertExercise("Franskpress", "Ligg på ryggen, hold ei stang med vekter med knokene mot deg og løft fra hode og opp bare med bruk av triceps", 1);
	}
}
