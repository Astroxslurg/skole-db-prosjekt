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
	@FXML ToggleGroup type_maal;
	@FXML TextField styrke_boks_belastning;
	@FXML TextField styrke_boks_repetisjoner;
	@FXML TextField styrke_boks_sett;
	@FXML TextField kondisjon_boks_lengde;
	@FXML TextField kondisjon_boks_tid;
	@FXML MenuButton gruppe;
	@FXML DatePicker startdato;
	@FXML DatePicker maaldato;
	@FXML DatePicker naddato;
	@FXML Label styrke_belastning;
	@FXML Label styrke_repetisjoner;
	@FXML Label styrke_sett;
	@FXML Label kondisjon_lengde;
	@FXML Label kondisjon_tid;
	
	
	
	@FXML
	void styrkeButtonIsActivatedInMaal(Event event) {
		if (!(styrke_knapp.isDisabled())){
			styrke_boks_belastning.setVisible(true);
			styrke_boks_repetisjoner.setVisible(true);
			styrke_boks_sett.setVisible(true);
			styrke_belastning.setVisible(true);
			styrke_repetisjoner.setVisible(true);
			styrke_sett.setVisible(true);
			kondisjon_boks_lengde.setVisible(false);
			kondisjon_boks_tid.setVisible(false);
			kondisjon_lengde.setVisible(false);
			kondisjon_tid.setVisible(false);
		}	
	}
	
	@FXML
	void kondisjonButtonIsActivatedInMaal(Event event) {
		if (!(kondisjon_knapp.isDisabled())){
			styrke_boks_belastning.setVisible(false);
			styrke_boks_repetisjoner.setVisible(false);
			styrke_boks_sett.setVisible(false);
			styrke_belastning.setVisible(false);
			styrke_repetisjoner.setVisible(false);
			styrke_sett.setVisible(false);
			kondisjon_boks_lengde.setVisible(true);
			kondisjon_boks_tid.setVisible(true);
			kondisjon_lengde.setVisible(true);
			kondisjon_tid.setVisible(true);
		}	
	}
	
	@FXML
	private void submitExercise(){
		
		Database.insertExercise("Franskpress", "Ligg på ryggen, hold ei stang med vekter med knokene mot deg og løft fra hode og opp bare med bruk av triceps", 1);
	}
}
