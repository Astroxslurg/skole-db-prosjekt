package application;

import javafx.fxml.FXML;

public class ProgramController {
	
	@FXML
	private void test(){
		System.out.println("Knappen funker");
		Database.test();
	}
}
