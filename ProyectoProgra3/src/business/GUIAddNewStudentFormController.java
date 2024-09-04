package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;

import data.StudentsData;
import domain.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

public class GUIAddNewStudentFormController {
	@FXML
	private Label labelAlert;
	@FXML
	private Button btnMakeRecharge;
	@FXML
	private ComboBox<String> cbGender;
	@FXML
	private TextField tfCarnet;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfPhoneNumber;
	@FXML
	private TextField tfGender;
	@FXML
	private TextField tfAvailableMoney;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnRegisterStudent;
	@FXML
	private LogicStudents logicStudents;

	private String errorMessage;
	
	public GUIAddNewStudentFormController() {
		this.logicStudents = new LogicStudents();
	}
	
	public void initialize() {
		cbGender.getItems().addAll("No especificar","Masculino","Femenino");
		cbGender.getSelectionModel().selectFirst();
	}
	
	@FXML
	public void makeRecharge(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIStudentRechargeForm.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnMakeRecharge.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void back(ActionEvent event) {
	closeWindows();
	}
	
	public String validateRequiredFields() {
		errorMessage = "";
		if(tfCarnet.getText().isBlank()) {
			errorMessage+="Requiere un carnet ";
		}else {
			if(tfCarnet.getText().length()>10) {
				errorMessage+="Carnet de maximo 10 caracteres ";
			}
		}
		if(tfName.getText().isBlank()) {
			errorMessage+="Requiere un nombre ";
		}
		if(tfPhoneNumber.getText().isBlank()) {
			errorMessage+="Requiere un numero celular ";
		}else {
			if(tfPhoneNumber.getText().length()<8 || tfPhoneNumber.getText().length()>10) {
				errorMessage+="Numero celular de entre 8 a 10 digitos ";
			}
		}
		
		if(tfAvailableMoney.getText().isBlank()) {
			errorMessage+="Requiere un dinero disponible";
		}else {
			try {
				if(Integer.parseInt(tfAvailableMoney.getText())<0) {
					errorMessage += "Ingrese un monto valido(positivo)\n";
					
				}else {
					if(Double.parseDouble(tfAvailableMoney.getText())<5000|| Double.parseDouble(tfAvailableMoney.getText())>15000) {
						errorMessage+="Dinero disponible requiere rango de 5000 a 15000";
					}
				}
			}catch(NumberFormatException e) {
				errorMessage += "Ingrese un valor numerico\n";
				
			}
		}
		return errorMessage;
	}
	
	@FXML
	public void registerStudent() {
		if(validateRequiredFields().equals("")) {
			if(!logicStudents.isAlreadyAdded(tfCarnet.getText())) {
				
				Student student = new Student(tfCarnet.getText(),
						tfName.getText(),(!tfEmail.getText().isBlank())?tfEmail.getText():"No especificado",
						Integer.parseInt(tfPhoneNumber.getText()),
						(cbGender.getValue().equals("Masculino")?'M':(cbGender.getValue().equals("Femenino")?'F':' ')),
						true,LocalDate.now(),Double.parseDouble(tfAvailableMoney.getText()));
				
				if(StudentsData.saveStudent(student)) {
					labelAlert.setTextFill(Color.GREEN);
					notifyAction("Estudiante registrado correctamente");
					clearForm();
					errorMessage="";
				}
			}else {
				labelAlert.setTextFill(Color.RED);
				notifyAction("El estudiante ya esta registrado en el sistema");
			}
		}else {
			labelAlert.setTextFill(Color.RED);
			notifyAction(errorMessage);
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
			Stage temp = (Stage)btnBack.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void notifyAction(String message) {
		labelAlert.setText(message);
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),e->labelAlert.setText("")));
		timeline.setCycleCount(1);
		timeline.play();
		
	}
	
	public void clearForm() {
		tfCarnet.clear();
		tfName.clear();
		tfEmail.clear();
		tfPhoneNumber.clear();
		tfAvailableMoney.clear();
	}
}
