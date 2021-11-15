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
import model.entities.PRO_Cadastro;
import model.services.PRO_CadastroService;

public class PRO_CadastroFormController implements Initializable {
	
	private PRO_Cadastro entity;
	
	private PRO_CadastroService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtPro_Titulo;
	
	@FXML
	private TextField txtPro_Data_Inicio;
	
	@FXML
	private TextField txtPro_Data_Final;
	
	@FXML
	private TextField txtPro_Horas;
	@FXML
	private TextField txtPro_Progresso;
	@FXML
	private TextField txtPro_Dep_Posterior;
	@FXML
	private TextField txtPro_Cliente;
	
		
	@FXML
	private Label labelErrorTaskname;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setPRO_Cadastro(PRO_Cadastro entity) {
		this.entity = entity;
	}
	
	
	public void setPRO_CadastroService(PRO_CadastroService service) {
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


	private PRO_Cadastro getFormData() {
		PRO_Cadastro obj = new PRO_Cadastro ();
		
		
		
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
			
		obj.setPro_Titulo(txtPro_Titulo.getText());
		obj.setPro_Data_Inicio(txtPro_Data_Inicio.getText());
		obj.setPro_Data_Final(txtPro_Data_Final.getText());
		obj.setPro_Horas(txtPro_Horas.getText());
		obj.setPro_Progresso(txtPro_Progresso.getText());
		obj.setPro_Dep_Posterior(txtPro_Dep_Posterior.getText());
		obj.setPro_Cliente(txtPro_Cliente.getText());

	
		
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
		Constraints.setTextFieldMaxLength(txtPro_Titulo,30);
		Constraints.setTextFieldMaxLength(txtPro_Data_Inicio,30);
		Constraints.setTextFieldMaxLength(txtPro_Data_Final,30);
		Constraints.setTextFieldMaxLength(txtPro_Horas,30);
		Constraints.setTextFieldMaxLength(txtPro_Progresso,30);
		Constraints.setTextFieldMaxLength(txtPro_Dep_Posterior,30);
		Constraints.setTextFieldMaxLength(txtPro_Cliente,30);


	

			
	}
	
	public void updateFormData() {
		
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		txtId.setText(String.valueOf(entity.getId()));
		txtPro_Titulo.setText(entity.getPro_Titulo());
		txtPro_Data_Inicio.setText(entity.getPro_Data_Inicio());
		txtPro_Data_Final.setText(entity.getPro_Data_Final());
		txtPro_Horas.setText(entity.getPro_Horas());
		txtPro_Progresso.setText(entity.getPro_Progresso());
		txtPro_Dep_Posterior.setText(entity.getPro_Dep_Posterior());
		txtPro_Cliente.setText(entity.getPro_Cliente());
		

		

	}


	

	}
	
	
