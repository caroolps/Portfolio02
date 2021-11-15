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
import model.entities.USE_Cadastro;
import model.services.USE_CadastroService;



public class USE_CadastroListController implements Initializable, DataChangeListener {

	private USE_CadastroService service;

	@FXML
	private TableView<USE_Cadastro> tableViewProjetos3;

	@FXML
	private TableColumn<USE_Cadastro, Integer> tableColumnId;

	@FXML
	private TableColumn<USE_Cadastro, String> tableColumnUse_nome;

	@FXML
	private TableColumn<USE_Cadastro, String> tableColumUse_sobrenome;

	@FXML
	private TableColumn<USE_Cadastro, String> tableColumnUse_departamento;
	
	@FXML
	private TableColumn<USE_Cadastro, String> tableColumnUse_estag_efetivo;
	
	@FXML
	private TableColumn<USE_Cadastro, String> tableColumnUse_horas_usuario;
	
	
	@FXML
	private TableColumn<USE_Cadastro, USE_Cadastro> tableColumnEDIT;

	@FXML
	private TableColumn<USE_Cadastro, USE_Cadastro> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<USE_Cadastro> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		USE_Cadastro obj = new USE_Cadastro();
		createDialogForm(obj, "/gui/USE_CadastroForm.fxml", parentStage);
	}

	

	public void setUSE_CadastroService(USE_CadastroService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnUse_nome.setCellValueFactory(new PropertyValueFactory<>("use_nome"));
		tableColumUse_sobrenome.setCellValueFactory(new PropertyValueFactory<>("use_sobrenome"));
		tableColumnUse_departamento.setCellValueFactory(new PropertyValueFactory<>("use_departamento"));
		tableColumnUse_estag_efetivo.setCellValueFactory(new PropertyValueFactory<>("use_estag_efetivo"));
		tableColumnUse_horas_usuario.setCellValueFactory(new PropertyValueFactory<>("use_horas_usuario"));
		

	
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewProjetos3.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

			List<USE_Cadastro> list = service.findAll();
			obsList = FXCollections.observableArrayList(list);
			tableViewProjetos3.setItems(obsList);
			initEditButtons();
			initRemoveButtons();
		}

	
	private void createDialogForm(USE_Cadastro obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			USE_CadastroFormController controller = loader.getController();
			controller.setUSE_Cadastro(obj);
			controller.setUSE_CadastroService(new USE_CadastroService());
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
		tableColumnEDIT.setCellFactory(param -> new TableCell<USE_Cadastro, USE_Cadastro>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(USE_Cadastro obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> createDialogForm(obj, "/gui/USE_CadastroForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<USE_Cadastro, USE_Cadastro>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(USE_Cadastro obj, boolean empty) {
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

	private void removeEntity(USE_Cadastro obj) {
		
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


