package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	@FXML MenuButton ovelse_gruppe;
	@FXML Button ovelse_submit;
	
	@FXML RadioButton kondisjon_knapp;
	@FXML RadioButton styrke_knapp;
	@FXML ToggleGroup type_maal;
	@FXML TextField styrke_boks_belastning;
	@FXML TextField styrke_boks_repetisjoner;
	@FXML TextField styrke_boks_sett;
	@FXML TextField kondisjon_boks_lengde;
	@FXML TextField kondisjon_boks_tid;
	@FXML DatePicker startdato;
	@FXML DatePicker maaldato;
	@FXML DatePicker naddato;
	@FXML Label styrke_belastning;
	@FXML Label styrke_repetisjoner;
	@FXML Label styrke_sett;
	@FXML Label kondisjon_lengde;
	@FXML Label kondisjon_tid;
	@FXML Button legg_til_maal_btn;
	
	@FXML RadioButton styrke_knapp1;
	@FXML RadioButton kondisjon_knapp1;
	@FXML ToggleGroup resultat_radio;
	@FXML TextField resultat_boks_belastning;
	@FXML TextField resultat_boks_lengde;
	@FXML TextField resultat_boks_repetisjoner;
	@FXML TextField resultat_boks_tid;
	@FXML TextField resultat_boks_sett;
	@FXML Label resultat_kondisjon_lengde;
	@FXML Label resultat_kondisjon_tid;
	@FXML Label resultat_styrke_belastning;
	@FXML Label resultat_styrke_repetisjon;
	@FXML Label resultat_styrke_sett;
	@FXML Button resultat_submit;
	@FXML ComboBox ovelse_boks;
	
	
	
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
	void styrkeButton1IsActivatedInResultater(Event event) {
		if (!(styrke_knapp1.isDisabled())){
			resultat_boks_belastning.setVisible(true);
			resultat_boks_repetisjoner.setVisible(true);
			resultat_boks_sett.setVisible(true);
			resultat_styrke_belastning.setVisible(true);
			resultat_styrke_repetisjon.setVisible(true);
			resultat_styrke_sett.setVisible(true);
			resultat_boks_lengde.setVisible(false);
			resultat_kondisjon_tid.setVisible(false);
			resultat_kondisjon_lengde.setVisible(false);
			resultat_kondisjon_tid.setVisible(false);
		}	
	}
	
	@FXML
	void kondisjonButton1IsActivatedInResultater(Event event) {
		if (!(kondisjon_knapp1.isDisabled())){
			resultat_boks_belastning.setVisible(false);
			resultat_boks_repetisjoner.setVisible(false);
			resultat_boks_sett.setVisible(false);
			resultat_styrke_belastning.setVisible(false);
			resultat_styrke_repetisjon.setVisible(false);
			resultat_styrke_sett.setVisible(false);
			resultat_boks_lengde.setVisible(true);
			resultat_boks_tid.setVisible(true);
			resultat_kondisjon_lengde.setVisible(true);
			resultat_kondisjon_tid.setVisible(true);
		}	
	}
	
	@FXML
	private void submitExercise(){
		boolean type = true;
		if (ovelse_kondisjon_knapp.isSelected()) {
			type = false;
		}
		
		Exercise ex = new Exercise(ovelse_navn.getText(), ovelse_beskrivelse.getText(), type);
//		Database.insertExercise(ovelse_navn.getText(), ovelse_beskrivelse.getText(), type);
	}
	
	@FXML
	private void submitResult(){
		
	}
	
	private void submitGoal(){
		startdato.getValue();
	}
	
}
