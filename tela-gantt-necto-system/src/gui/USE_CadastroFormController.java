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
import model.entities.USE_Cadastro;
import model.services.USE_CadastroService;

public class USE_CadastroFormController implements Initializable {
	
	private USE_Cadastro entity;
	
	private USE_CadastroService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtUse_nome;
	
	@FXML
	private TextField txtUse_sobrenome;
	
	@FXML
	private TextField txtUse_departamento;
	
	@FXML
	private TextField txtUse_estag_efetivo;
	@FXML
	private TextField txtUse_horas_usuario;
	
	
		
	@FXML
	private Label labelErrorTaskname;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setUSE_Cadastro(USE_Cadastro entity) {
		this.entity = entity;
	}
	
	
	public void setUSE_CadastroService(USE_CadastroService service) {
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


	private USE_Cadastro getFormData() {
		USE_Cadastro obj = new USE_Cadastro ();
		
		
		
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
			
		obj.setUse_nome(txtUse_nome.getText());
		obj.setUse_sobrenome(txtUse_sobrenome.getText());
		obj.setUse_departamento(txtUse_departamento.getText());
		obj.setUse_estag_efetivo(txtUse_estag_efetivo.getText());
		obj.setUse_horas_usuario(txtUse_horas_usuario.getText());

	
		
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
		Constraints.setTextFieldMaxLength(txtUse_nome,30);
		Constraints.setTextFieldMaxLength(txtUse_sobrenome,30);
		Constraints.setTextFieldMaxLength(txtUse_departamento,30);
		Constraints.setTextFieldMaxLength(txtUse_estag_efetivo,30);
		Constraints.setTextFieldMaxLength(txtUse_horas_usuario,30);
	


	

			
	}
	
	public void updateFormData() {
		
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		txtId.setText(String.valueOf(entity.getId()));
		txtUse_nome.setText(entity.getUse_nome());
		txtUse_sobrenome.setText(entity.getUse_sobrenome());
		txtUse_departamento.setText(entity.getUse_departamento());
		txtUse_estag_efetivo.setText(entity.getUse_estag_efetivo());
		txtUse_horas_usuario.setText(entity.getUse_horas_usuario());
		
		

		

	}


	

	}
	
	
