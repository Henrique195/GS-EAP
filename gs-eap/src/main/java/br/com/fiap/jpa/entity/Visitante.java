package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "t_gco_visitante")
@SequenceGenerator(name = "visitante", sequenceName = "sq_t_gco_visitante", allocationSize = 1)
public class Visitante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5201102732055151476L;
	
	public Visitante() {
		
	}
	

	public Visitante(String nome, LocalDate dataNascimento, String cpf, String rg, LocalDate dataCadastro) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}


	@Id
	@Column(name = "id_visitante")
	@GeneratedValue(generator = "visitante", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_visitante")
	private String nome;
	
	@Column(name = "dt_nasc")
	private LocalDate dataNascimento;
	
	@Column(name = "nr_cpf")
	private String cpf;
	
	@Column(name = "nr_rg" )
	private String rg;
	
	@Column(name = "dt_cadastro")
	private LocalDate dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return "\nNome: " + this.getNome()
		+"\nNascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+ "\nCPF: " + this.getCpf()
		+ "\nRG: " + this.getRg()
		+ "\nData Cadastro: " + this.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	}

}
