package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_portaria")
@SequenceGenerator(name = "portaria", sequenceName = "sq_t_gco_portaria", allocationSize = 1)
public class Portaria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7609998739432086468L;
	
	public Portaria() {
		
	}
	
	
	public Portaria(int numeroPortaria, String nomePortaria, 
			 Condominio condominio) {
		
		this.numeroPortaria = numeroPortaria;
		this.nomePortaria = nomePortaria;
		this.condominio = condominio;
	}


	@Id 
	@Column(name = "id_portaria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portaria")
	private Long id;
	
	@Column(name = "nr_portaria")
	private int numeroPortaria;
	
	@Column(name = "nm_portaria")
	private String nomePortaria;
	
	@Column(name = "st_status")
	private String status;
	
	@Column(name = "dt_inicio")
	private LocalDateTime dataInicio;
	
	@Column (name = "dt_termino")
	private LocalDateTime dataTermino;
	
	@ManyToOne
	@JoinColumn(name ="id_condominio")
	private Condominio condominio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroPortaria() {
		return numeroPortaria;
	}
	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}
	public String getNomePortaria() {
		return nomePortaria;
	}
	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	
	@Override
	public String toString() {
		
		return "\nNumero: " + this.getNumeroPortaria()
				+"\nNome: " + this.getNomePortaria()
				+"\nStatus: " + this.getStatus()
				+"\nData inicio: " + this.getDataInicio()
				+"\n Data Término: " + this.getDataTermino();
	}

	
	

}
