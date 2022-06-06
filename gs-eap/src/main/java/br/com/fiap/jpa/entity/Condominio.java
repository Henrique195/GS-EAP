package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_condominio")
@SequenceGenerator(name = "condominio", sequenceName = "sq_t_gco_condominio", allocationSize = 1)
public class Condominio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 74952083373586519L;
	
	public Condominio() {
		
	}

	public Condominio(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataFundacao) {
		this();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
	}


	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominio")
	private Long id;
	
	@Column(name = "nr_cnpj")
	private String cnpj;
	
	@Column(name = "ds_razao_social")
	private String razaoSocial;
	
	@Column(name = "nm_fantasia")
	private String nomeFantasia;
	
	@Column(name = "dt_fundacao")
	private LocalDate dataFundacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	@Override
	public String toString() {
		
		return "\nNumero CNPJ: " + this.getCnpj()
				+"\nRazão Social: " + this.getRazaoSocial()
				+"\nNome Fantasia: " + this.getNomeFantasia()
				+"\nData Fundação: " + this.getDataFundacao();
	}

}
