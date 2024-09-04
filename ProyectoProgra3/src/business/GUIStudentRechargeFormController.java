package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import data.StudentsRechargeData;
import domain.StudentRecharge;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GUIStudentRechargeFormController {
	@FXML
	private TextField tfCarnet;
	@FXML
	private TextField tfRechargeAmount;
	@FXML
	private Button btnRecharge;
	@FXML
	private Label labelAlert;
	@FXML
	private Button btnReturnHome;
	// Event Listener on Button[#btnRecharge].onAction
	@FXML
	public void recharge(ActionEvent event) {
		String message = validForm(); //mensaje de error
		if(message.equals("")) { //si el mensaje de error esta vacio
			if(LogicStudents.validRecharge(Integer.parseInt(tfRechargeAmount.getText()))) { //valida si el monto esta en el rango permitido
				if(StudentsRechargeData.existStudent(tfCarnet.getText())) { //verifica que el estudiante exista
				//crea una nueva recarga
				StudentRecharge sR = new StudentRecharge();
				sR.setAmount(Integer.parseInt(tfRechargeAmount.getText()));
				sR.setCarnet(tfCarnet.getText());
				sR.setRechargeDate(LocalDate.now());
				//guarda la recarga
				StudentsRechargeData.saveRecharge(sR); //guarda la recarga realizada en archivo de recargas
				JOptionPane.showMessageDialog(null,"Recarga realizada con exito");
				cleanForm();
				StudentsRechargeData.makeRecharge(sR); //le realiza la recarga al estudiante
				}else {
					notifyAction("El carnet no existe,registre el estudiante");
				}
			}else {
				notifyAction("El monto de la recarga debe estar entre 1000 y 10000");
			}
			
		}else {
			notifyAction(message); //notifica los errores
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
			Stage temp = (Stage)btnRecharge.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void returnHome(ActionEvent event) {
		closeWindows();
	}
	
	private String validForm() {
		String message = "";
		if(tfCarnet.getText().isBlank() || tfCarnet.getText().isEmpty() || tfCarnet.getText()==null){
			message += "Ingrese un carnet valido\n";
		}
		if(tfRechargeAmount.getText().isBlank() || tfRechargeAmount.getText().isEmpty() || tfRechargeAmount.getText()==null){
			message += "Ingrese un monto valido\n";
		}
		
		try {
			if(Integer.parseInt(tfRechargeAmount.getText())<0) {
				message += "Ingrese un monto valido(positivo)\n";
				
			}
		}catch(NumberFormatException e) {
			message += "Ingrese un valor numerico\n";
			
		}
		return message;
	}
	
	private void notifyAction(String message) {
		labelAlert.setText(message);
		Timeline timeline = new Timeline(
				new KeyFrame(
						Duration.seconds(5),
						e->{labelAlert.setText("");
				
						}));
		timeline.setCycleCount(1);
		timeline.play();
		
	}
	private void cleanForm() {
		tfCarnet.clear();
		tfRechargeAmount.clear();
	}
}
