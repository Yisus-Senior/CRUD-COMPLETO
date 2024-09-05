package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.JOptionPane;

import data.MenuBreakfastData;
import data.MenuLunchData;
import domain.Menus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.css.CssParser.ParseError;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ComboBox;

import javafx.scene.control.RadioButton;

public class GUIFormAddNewAlimentController {
	@FXML
	private Button btnReturnHome;
	@FXML
	private TextField tfPriceOfService;
	@FXML
	private TextField tfNameOfService;
	@FXML
	private ComboBox<String> cbSelectServiceDay;
	@FXML
	private RadioButton rbServiceScheduleBreakfast;
	@FXML
	private ToggleGroup serviceSchedule;
	@FXML
	private RadioButton rbServiceScheduleLunch;
	@FXML
	private Button btnSaveDataService;
	@FXML
	private Label lMessageErrors;
	
	public Menus tempMenu;
	public byte tempDay;
	public boolean tempTime;
	// Event Listener on Button[#btnReturnHome].onAction
	@FXML
	public void returnToHome(ActionEvent event) {
		if(tempMenu!=null) {
			int  a = JOptionPane.showConfirmDialog(null,"Esta editando un menu,esta seguero de salir?");
			if(a==0) {
				closeWindows();
			}
		}else {
			closeWindows();
		}
	}
	// Event Listener on Button[#btnSaveDataService].onAction
	@FXML
	public void saveDataService(ActionEvent event) {
		String message = validForm(); // igual al string de errores
		
		if(message.equals("")) { // si el string de errores esta vacio 
			//varifica el guardado al usuario
			int op = JOptionPane.showConfirmDialog(null,"Esta seguro de agregar un nuevo servicio para el dia " + 
					cbSelectServiceDay.getSelectionModel().getSelectedItem()+
					" al horario " + (rbServiceScheduleBreakfast.isSelected()?"Desayuno":"Almuerzo"));
			
			if(op==0) { 
			//crea una instancia menu con los datos ingresados
			Menus menu = new Menus();
			
			menu.setNamePlate(tfNameOfService.getText());
			menu.setPrice(Integer.parseInt(tfPriceOfService.getText()));
			// le pasa al logic el menu, junto al index para saber el dia y el horario seleccionado
				if(LogicMenus.setAliments(menu,(byte) cbSelectServiceDay.getSelectionModel().getSelectedIndex(),rbServiceScheduleBreakfast.isSelected())) {
					LogicMenus.removeAliments(menu,tempDay,tempTime);
					tempMenu=null;
					notifyAction("Alimento guardado exitosamente");
				}else {
					notifyAction("no se puedo guardar la comida");
				}
			// limpia el form
			cleanForm();
			}
		}else {
			notifyAction(message);
		}
	}
	public void closeWindows() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIMenuHome.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnReturnHome.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void initialize() {
		//inicializa el comboBox de los dias
		cbSelectServiceDay.getItems().addAll("Lunes","Martes","Miercoles","Jueves","Viernes");
		cbSelectServiceDay.getSelectionModel().selectFirst();
	}
	
	private String validForm() { //valida el formulario
		String message ="";
		
		if(tfNameOfService.getText().isBlank() || tfNameOfService.getText().isEmpty() || tfNameOfService.getText()==null) {
			message +="\t Ingrese el nombre del servicio correctamente";
		}
		
		try {
			if(Integer.parseInt(tfPriceOfService.getText())<0) {
				message +="\t Ingrese un precio valido";
			}
		}catch(NumberFormatException e) {
			message+="\t ingrese el precio correctamente";
		}
		
		return message;
	}
	
	private void notifyAction(String message) {
		lMessageErrors.setText(message);
		Timeline timeline = new Timeline(
				new KeyFrame(
						Duration.seconds(3),
						e->{lMessageErrors.setText("");
				
						}));
		timeline.setCycleCount(1);
		timeline.play();
		
	}
	
	private void cleanForm() {
		tfNameOfService.clear();
		tfPriceOfService.clear();
		cbSelectServiceDay.getSelectionModel().selectFirst();
	}
	
	public void setUpdateMenu(Menus menu,byte dayService,boolean timeService) {
		cbSelectServiceDay.getSelectionModel().select(dayService);
		rbServiceScheduleBreakfast.selectedProperty().set(timeService);
		
		tfNameOfService.setText(menu.getNamePlate());
		tfPriceOfService.setText(String.valueOf(menu.getPrice()));
		
		tempDay=dayService;
		tempTime=timeService;
		
		tempMenu=menu;
	}
}
