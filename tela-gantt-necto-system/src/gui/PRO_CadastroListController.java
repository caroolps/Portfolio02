package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.PRO_Cadastro;
import model.services.PRO_CadastroService;


public class PRO_CadastroListController implements Initializable, DataChangeListener {

	private PRO_CadastroService service;

	@FXML
	private TableView<PRO_Cadastro> tableViewProjetos2;

	@FXML
	private TableColumn<PRO_Cadastro, Integer> tableColumnId;

	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Titulo;

	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumPro_Data_Inicio;

	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Data_Final;
	
	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Horas;
	
	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Progresso;
	
	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Dep_Posterior;
	
	@FXML
	private TableColumn<PRO_Cadastro, String> tableColumnPro_Cliente;

	@FXML
	private TableColumn<PRO_Cadastro, PRO_Cadastro> tableColumnEDIT;

	@FXML
	private TableColumn<PRO_Cadastro, PRO_Cadastro> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<PRO_Cadastro> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		PRO_Cadastro obj = new PRO_Cadastro();
		createDialogForm(obj, "/gui/PRO_CadastroForm.fxml", parentStage);
	}

	

	public void setPRO_CadastroService(PRO_CadastroService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnPro_Titulo.setCellValueFactory(new PropertyValueFactory<>("pro_Titulo"));
		tableColumPro_Data_Inicio.setCellValueFactory(new PropertyValueFactory<>("pro_Data_Inicio"));
		tableColumnPro_Data_Final.setCellValueFactory(new PropertyValueFactory<>("pro_Data_Final"));
		tableColumnPro_Horas.setCellValueFactory(new PropertyValueFactory<>("pro_Horas"));
		tableColumnPro_Progresso.setCellValueFactory(new PropertyValueFactory<>("pro_Progresso"));
		tableColumnPro_Dep_Posterior.setCellValueFactory(new PropertyValueFactory<>("pro_Dep_Posterior"));
		tableColumnPro_Cliente.setCellValueFactory(new PropertyValueFactory<>("pro_Cliente"));

	
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewProjetos2.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

			List<PRO_Cadastro> list = service.findAll();
			obsList = FXCollections.observableArrayList(list);
			tableViewProjetos2.setItems(obsList);
			initEditButtons();
			initRemoveButtons();
		}

	
	private void createDialogForm(PRO_Cadastro obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			PRO_CadastroFormController controller = loader.getController();
			controller.setPRO_Cadastro(obj);
			controller.setPRO_CadastroService(new PRO_CadastroService());
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastro de dados do Projeto");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}

		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();

	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<PRO_Cadastro, PRO_Cadastro>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(PRO_Cadastro obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> createDialogForm(obj, "/gui/PRO_CadastroForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<PRO_Cadastro, PRO_Cadastro>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(PRO_Cadastro obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(PRO_Cadastro obj) {
		
	Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", " Tem certeza que deseja remover ? ");
	
		if (result.get() == ButtonType.OK) {
			try {
			service.remove(obj);
			updateTableView();
		}
		catch (DbIntegrityException e) {
			Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
		}
			
		}

		
	}


		
	}


