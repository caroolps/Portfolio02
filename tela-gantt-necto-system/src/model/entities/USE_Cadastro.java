package model.entities;

import java.io.Serializable;

public class USE_Cadastro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String use_nome;
	private String use_sobrenome;
	private String use_departamento;
	private String use_estag_efetivo;
	private String  use_horas_usuario;
	
	
	public USE_Cadastro() {
		
	}


	public USE_Cadastro(Integer id, String use_nome, String use_sobrenome, String use_departamento,
			String use_estag_efetivo, String use_horas_usuario) {
		super();
		this.id = id;
		this.use_nome = use_nome;
		this.use_sobrenome = use_sobrenome;
		this.use_departamento = use_departamento;
		this.use_estag_efetivo = use_estag_efetivo;
		this.use_horas_usuario = use_horas_usuario;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUse_nome() {
		return use_nome;
	}


	public void setUse_nome(String use_nome) {
		this.use_nome = use_nome;
	}


	public String getUse_sobrenome() {
		return use_sobrenome;
	}


	public void setUse_sobrenome(String use_sobrenome) {
		this.use_sobrenome = use_sobrenome;
	}


	public String getUse_departamento() {
		return use_departamento;
	}


	public void setUse_departamento(String use_departamento) {
		this.use_departamento = use_departamento;
	}


	public String getUse_estag_efetivo() {
		return use_estag_efetivo;
	}


	public void setUse_estag_efetivo(String use_estag_efetivo) {
		this.use_estag_efetivo = use_estag_efetivo;
	}


	public String getUse_horas_usuario() {
		return use_horas_usuario;
	}


	public void setUse_horas_usuario(String use_horas_usuario) {
		this.use_horas_usuario = use_horas_usuario;
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
		USE_Cadastro other = (USE_Cadastro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "USE_Cadastro [id=" + id + ", use_nome=" + use_nome + ", use_sobrenome=" + use_sobrenome
				+ ", use_departamento=" + use_departamento + ", use_estag_efetivo=" + use_estag_efetivo
				+ ", use_horas_usuario=" + use_horas_usuario + "]";
	}
	
}