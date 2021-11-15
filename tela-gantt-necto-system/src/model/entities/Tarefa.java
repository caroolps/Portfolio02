package model.entities;

import java.io.Serializable;

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String taskname;
	private String starttime;
	private String owner;
	private String duration;
	private String projeto;

	
	
	public Tarefa() {
	}

	
	public Tarefa(Integer id, String taskname, String starttime, String owner, String duration, String projeto) {
		
		this.id = id;
		this.taskname = taskname;
		this.starttime = starttime;
		this.owner = owner;
		this.duration = duration;
		this.projeto = projeto;

		
	}


	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTaskname() {
		return taskname;
	}


	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getProjeto() {
		return projeto;
	}


	public void setProjeto(String projeto) {
		this.projeto = projeto;
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Projetos [id=" + id + ", taskname=" + taskname + ", starttime=" + starttime + ", owner=" + owner
				+ ", duration=" + duration + ", projeto=" + projeto + "]";
	}


	}

	
