package model.entities;

import java.io.Serializable;

public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idproject;
	private String projectname;
	private String starttime;	
	private String duration;
	private String progress;
	private Integer iddependence;
	
	
	public Projeto() {
	}

	
	public Projeto(Integer idproject, String projectname, String starttime, String duration, String progress, Integer iddependence ) {
		
		this.idproject = idproject;
		this.projectname = projectname;
		this.starttime = starttime;		
		this.duration = duration;
		this.progress = progress;
		this.iddependence = iddependence;
		
		
	}



	public Integer getIdproject() {
		return idproject;
	}


	public void setIdproject(Integer id) {
		this.idproject = id;
	}


	public String getProjectname() {
		return projectname;
	}


	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getProgress() {
		return progress;
	}
	
	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	
	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Integer getIddependence() {
		return iddependence;
	}


	public void setIddependence(Integer iddependence) {
		this.iddependence = iddependence;
	}
	
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idproject == null) ? 0 : idproject.hashCode());
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
		Projeto other = (Projeto) obj;
		if (idproject == null) {
			if (other.idproject != null)
				return false;
		} else if (!idproject.equals(other.idproject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projetos [id=" + idproject + ", taskname=" + projectname + ", starttime=" + starttime + ", progress=" + progress
				+ ", duration=" + duration + "]";
	}

	
}