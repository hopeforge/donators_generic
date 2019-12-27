package br.com.graac.mailingmaisvida.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TB_CAMPANHA")
public class Campanha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true, nullable = false)
	private int id;
	
	@Column(name="DS_CAMPANHA")
	private String campanha;
	
	@Column(name="DT_CAMPANHA")
	private Date dt_campanha;
	
	@Column(name="ST_CAMPANHA")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampanha() {
		return campanha;
	}

	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}

	public Date getDt_campanha() {
		return dt_campanha;
	}

	public void setDt_campanha(Date dt_campanha) {
		this.dt_campanha = dt_campanha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
