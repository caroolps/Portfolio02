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
import model.entities.Tarefa;
import model.services.TarefaService;

public class TarefaListController implements Initializable, DataChangeListener {

	private TarefaService service;

	@FXML
	private TableView<Tarefa> tableViewProjetos;

	@FXML
	private TableColumn<Tarefa, Integer> tableColumnId;

	@FXML
	private TableColumn<Tarefa, String> tableColumnTaskname;

	@FXML
	private TableColumn<Tarefa, String> tableColumnStarttime;

	@FXML
	private TableColumn<Tarefa, String> tableColumnOwner;

	@FXML
	private TableColumn<Tarefa, String> tableColumnDuration;
	
	@FXML
	private TableColumn<Tarefa, String> tableColumnProjeto;

	@FXML
	private TableColumn<Tarefa, Tarefa> tableColumnEDIT;

	@FXML
	private TableColumn<Tarefa, Tarefa> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<Tarefa> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Tarefa obj = new Tarefa();
		createDialogForm(obj, "/gui/TarefaForm.fxml", parentStage);
	}

	public void setProjetosService(TarefaService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnTaskname.setCellValueFactory(new PropertyValueFactory<>("taskname"));
		tableColumnStarttime.setCellValueFactory(new PropertyValueFactory<>("starttime"));
		tableColumnOwner.setCellValueFactory(new PropertyValueFactory<>("owner"));
		tableColumnDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
		tableColumnProjeto.setCellValueFactory(new PropertyValueFactory<>("projeto"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewProjetos.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		List<Tarefa> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewProjetos.setItems(obsList);
		initEditButtons();
		initRemoveButtons();

	}

	private void createDialogForm(Tarefa obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			TarefaFormController controller = loader.getController();
			controller.setProjetos(obj);
			controller.setProjetosService(new TarefaService());
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
		tableColumnEDIT.setCellFactory(param -> new TableCell<Tarefa, Tarefa>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Tarefa obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> createDialogForm(obj, "/gui/TarefaForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Tarefa, Tarefa>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Tarefa obj, boolean empty) {
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

	private void removeEntity(Tarefa obj) {
		
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


