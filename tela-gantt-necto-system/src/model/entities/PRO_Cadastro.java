package model.entities;

import java.io.Serializable;

public class PRO_Cadastro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String pro_Titulo;
	private String pro_Data_Inicio;
	private String pro_Data_Final;
	private String pro_Horas;
	private String pro_Progresso;
	private String pro_Dep_Posterior;
	private String pro_Cliente;
	
	public PRO_Cadastro() {
	}

	public PRO_Cadastro(Integer id, String pro_Titulo, String pro_Data_Inicio, String pro_Data_Final, String pro_Horas,
			String pro_Progresso, String pro_Dep_Posterior, String pro_Cliente) {
		super();
		this.id = id;
		this.pro_Titulo = pro_Titulo;
		this.pro_Data_Inicio = pro_Data_Inicio;
		this.pro_Data_Final = pro_Data_Final;
		this.pro_Horas = pro_Horas;
		this.pro_Progresso = pro_Progresso;
		this.pro_Dep_Posterior = pro_Dep_Posterior;
		this.pro_Cliente = pro_Cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPro_Titulo() {
		return pro_Titulo;
	}

	public void setPro_Titulo(String pro_Titulo) {
		this.pro_Titulo = pro_Titulo;
	}

	public String getPro_Data_Inicio() {
		return pro_Data_Inicio;
	}

	public void setPro_Data_Inicio(String pro_Data_Inicio) {
		this.pro_Data_Inicio = pro_Data_Inicio;
	}

	public String getPro_Data_Final() {
		return pro_Data_Final;
	}

	public void setPro_Data_Final(String pro_Data_Final) {
		this.pro_Data_Final = pro_Data_Final;
	}

	public String getPro_Horas() {
		return pro_Horas;
	}

	public void setPro_Horas(String pro_Horas) {
		this.pro_Horas = pro_Horas;
	}

	public String getPro_Progresso() {
		return pro_Progresso;
	}

	public void setPro_Progresso(String pro_Progresso) {
		this.pro_Progresso = pro_Progresso;
	}

	public String getPro_Dep_Posterior() {
		return pro_Dep_Posterior;
	}

	public void setPro_Dep_Posterior(String pro_Dep_Posterior) {
		this.pro_Dep_Posterior = pro_Dep_Posterior;
	}

	public String getPro_Cliente() {
		return pro_Cliente;
	}

	public void setPro_Cliente(String pro_Cliente) {
		this.pro_Cliente = pro_Cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PRO_Cadastro other = (PRO_Cadastro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PRO_Cadastro [id=" + id + ", pro_Titulo=" + pro_Titulo + ", pro_Data_Inicio=" + pro_Data_Inicio
				+ ", pro_Data_Final=" + pro_Data_Final + ", pro_Horas=" + pro_Horas + ", pro_Progresso=" + pro_Progresso
				+ ", pro_Dep_Posterior=" + pro_Dep_Posterior + ", pro_Cliente=" + pro_Cliente + "]";
	}
	
	

}
