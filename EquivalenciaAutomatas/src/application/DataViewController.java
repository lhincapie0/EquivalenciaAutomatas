package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DataViewController {

	
	@FXML
	private TextField estados1Txt;

	@FXML
	private TextField estados2Txt;
	
	@FXML
	private TextArea entrada1Txt;
	
	@FXML
	private TextArea entrada2Txt;
	
	@FXML
	private TextArea salidas1Txt;
	
	
	@FXML
	private TextArea salidas2Txt;
	
	@FXML
	private Button continuarBut;
	private Main main; 
	
	
	@FXML
	public void continuar()
	{
		String estadosM1 = estados1Txt.getText();
		String estadosM2 = estados2Txt.getText();
		String entradaM1 = entrada1Txt.getText();
		String entradaM2 = entrada2Txt.getText();
		String salidaM1 = salidas1Txt.getText();
		String salidaM2 = salidas2Txt.getText();
		
		main.getMainData(estadosM1, entradaM1, salidaM1, estadosM2, entradaM2, salidaM2);
	
	}
	

}