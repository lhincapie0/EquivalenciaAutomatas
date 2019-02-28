package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class MainViewController implements Initializable{

	
	private String option;
	
	@FXML
	//Radio Button para indicar que se trabajará con máquina de Mealy
	private RadioButton mealyBut;

	@FXML
	//Radio Button para indicar que se trabajará con máquina de Moore
	private RadioButton mooreBut;
	
	@FXML
	//Boton para continuar a llenar la tabla de estados
	private Button continueBut;
	
	
	private Main main;

	@FXML
	public void showNextWindow() throws IOException {
		if(option!= null)
		{
			main.getDataView(option);	
		} else 
		{
			
		}
	}
	
	@FXML
	public void handleFirstBox()
	{
		if(mealyBut.isSelected())
		{
			option = "Mealy";
			mooreBut.setSelected(false);
		}
	}
	
	@FXML
	public void secondFirstBox()
	{
		if(mooreBut.isSelected())
		{
			option = "Moore";
			mealyBut.setSelected(false);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	
}

