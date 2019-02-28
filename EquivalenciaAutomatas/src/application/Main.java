package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import mundo.Control;
import mundo.Machine;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private Control control;
	
	//Llamado a la clase principal del mundo
	public Control getControl()
	{
		return control;
	}
	
	
	
	//Carga la ventana inicial 
	@Override
	public void start(Stage primaryStage) throws IOException, InterruptedException, ClassNotFoundException {
		
		control = new Control();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Equivalencia de Máquinas");
		showMain();
	   showMainView();
		
	}
	
	
	public static void showMain() throws IOException
	{
		
		FXMLLoader loader = new  FXMLLoader();
		loader.setLocation(Main.class.getResource("MainLayout.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void showMainView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainView.fxml"));
		BorderPane menu = loader.load();
		mainLayout.setCenter(menu);
	}
	
	public static void getDataView(String option) throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("DataView.fxml"));
		AnchorPane menu = loader.load();
		mainLayout.setCenter(menu);
		Machine m1 = new Machine(option);
		Machine me = new Machine(option);
	}
	
	
	public static void getMainData(String estadosM1,String entradaM1,String salidaM1,String estadosM2,String entradaM2,String salidaM2)
	{
		control.crearMaquina(estadosM1, entradaM1,salidaM1);
	}
	

	
	public static void main(String[] args) {
		launch(args);
		Main m = new Main();
	}
}
