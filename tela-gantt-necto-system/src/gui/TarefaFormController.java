package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Tarefa;
import model.services.TarefaService;

public class TarefaFormController implements Initializable {
	
	private Tarefa entity;
	
	private TarefaService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtTaskname;
	
	@FXML
	private TextField txtStarttime;
	
	@FXML
	private TextField txtOwner;
	
	@FXML
	private TextField txtDuration;
	
	@FXML
	private TextField txtProjeto;
	
	@FXML
	private Label labelErrorTaskname;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setProjetos(Tarefa entity) {
		this.entity = entity;
	}
	
	
	public void setProjetosService(TarefaService service) {
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
			
		}
		
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		try {
		entity = getFormData();
		service.saveOrUpdate(entity);
		notifyDataChangeListeners();
		Utils.currentStage(event).close();
		
		
		}
		catch(DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener: dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}


	private Tarefa getFormData() {
		Tarefa obj = new Tarefa ();
		
		
		
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
			
		obj.setTaskname(txtTaskname.getText());
		obj.setStarttime(txtStarttime.getText());
		obj.setOwner(txtOwner.getText());
		obj.setDuration(txtDuration.getText());
		obj.setProjeto(txtProjeto.getText());

	
		
		return obj;
	}
	

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtTaskname,30);
		Constraints.setTextFieldMaxLength(txtStarttime,30);
		Constraints.setTextFieldMaxLength(txtOwner,30);
		Constraints.setTextFieldMaxLength(txtDuration,30);
		Constraints.setTextFieldMaxLength(txtProjeto,30);

			
	}
	
	public void updateFormData() {
		
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		txtId.setText(String.valueOf(entity.getId()));
		txtTaskname.setText(entity.getTaskname());
		txtStarttime.setText(entity.getStarttime());
		txtOwner.setText(entity.getOwner());
		txtDuration.setText(entity.getDuration());
		txtProjeto.setText(entity.getProjeto());

	}
	

	}
	
	
