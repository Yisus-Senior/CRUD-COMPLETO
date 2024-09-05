package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import domain.Menus;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuBar;

import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;

public class GUIMenuHomeController {
	@FXML
	private MenuBar mbarSodaU;
	@FXML
	private Menu menuStudent;
	@FXML
	private MenuItem mItemConsultBalance;
	@FXML
	private MenuItem mItemAddStudent;
	@FXML
	private Menu menuSoda;
	@FXML
	private MenuItem mItemAddFood;
	@FXML
	private Menu menuService;
	@FXML
	private MenuItem mItemRequestService;
	@FXML
	private MenuItem mItemMakeRecharge;

	private static Menus menuTemp; 
	// Event Listener on MenuItem[#mItemConsultBalance].onAction
	@FXML
	public void consultBalance(ActionEvent event) {
		try {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/presentation/GUIConsultBalance.fxml"));
		Parent root = loader.load();
		GUIConsultBalanceController controllerCreate = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(
				e-> controllerCreate.closeWindows());
		Stage temp = (Stage)
				this.mbarSodaU.getScene().getWindow();
		temp.close();
		}catch(IOException e) {
			//e.printStackTrace();
		}
	}
	// Event Listener on MenuItem[#mItemAddStudent].onAction
	@FXML
	public void addStudent(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/presentation/GUIAddNewStudentForm.fxml"));
			Parent root = loader.load();
			GUIAddNewStudentFormController controllerCreate = loader.getController();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(
					e-> controllerCreate.closeWindows());
			Stage temp = (Stage)
					this.mbarSodaU.getScene().getWindow();
			temp.close();
			}catch(IOException e) {
				//e.printStackTrace();
			}
	}
	// Event Listener on MenuItem[#mItemAddFood].onAction
	@FXML
	public void addFood(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/presentation/GUIFormAddNewAliment.fxml"));
			Parent root = loader.load();
			GUIFormAddNewAlimentController controllerCreate = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(
					e-> controllerCreate.closeWindows());
			Stage temp = (Stage)
					this.mbarSodaU.getScene().getWindow();
			temp.close();
			}catch(IOException e) {
				//e.printStackTrace();
			}
	}
	// Event Listener on MenuItem[#mItemRequestService].onAction
	@FXML
	public void requestService(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/presentation/GUIRequestServices.fxml"));
			Parent root = loader.load();
			GUIRequestServicesController controllerCreate = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(
					e-> controllerCreate.closeWindows());
			Stage temp = (Stage)
					this.mbarSodaU.getScene().getWindow();
			temp.close();
			}catch(IOException e) {
				//e.printStackTrace();
			}
	}
	
	public void makeRecharge(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/presentation/GUIStudentRechargeForm.fxml"));
			Parent root = loader.load();
			GUIStudentRechargeFormController controllerCreate = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(
					e-> controllerCreate.closeWindows());
			Stage temp = (Stage)
					this.mbarSodaU.getScene().getWindow();
			temp.close();
			}catch(IOException e) {
				//e.printStackTrace();
			}
	}
	
}
