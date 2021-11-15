package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import application.ShowGantt;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.PRO_CadastroService;

import model.services.TarefaService;
import model.services.USE_CadastroService;

public class MainViewController implements Initializable {
	
	
	
	@FXML
	private MenuItem menuItemTarefa;
	
	@FXML
	private MenuItem menuItemProjetos;
	
	@FXML
	private MenuItem menuItemFuncionarios;
	
	//@FXML
	//private MenuItem menuItemAbout;

		@FXML
		public void onMenuItemTarefaAction() {
			loadView("/gui/TarefaList.fxml", (TarefaListController controller) -> {
				controller.setProjetosService(new TarefaService());
				controller.updateTableView();
			});
		
	}
		
		
		@FXML
		public void onMenuItemProjetosAction() {
			loadView("/gui/PRO_CadastroList.fxml", (PRO_CadastroListController controller) -> {
				controller.setPRO_CadastroService(new PRO_CadastroService());
				controller.updateTableView();
			});
		}
	
		@FXML
		public void onMenuItemFuncionariosAction() {
			loadView("/gui/USE_CadastroList.fxml", (USE_CadastroListController controller) -> {
				controller.setUSE_CadastroService(new USE_CadastroService());
				controller.updateTableView();
			});
		}
		
		
	@FXML
	public void onMenuItemAboutAction() {
//		loadView("/gui/About.fxml", x -> {});
		ShowGantt teste = new ShowGantt();
		teste.mostrarGrafico();
		
	}
	
		
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	
		
	}
	
	private synchronized <T >void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		
		Scene mainScene = Main.getMainScene();
		
		VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(mainMenu);
		mainVBox.getChildren().addAll(newVBox.getChildren());
		
		T controller = loader.getController();
		initializingAction.accept(controller);
	}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
	
	
}
