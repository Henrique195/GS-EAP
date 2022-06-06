package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
@Table(name= "t_gce_movimentacao_portaria")
@SequenceGenerator(name = "movimentacao", sequenceName = "sq_t_gco_movimentacao_portaria", allocationSize = 1)
public class MovimentacaoPortaria implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4311269632155395401L;
	
	public MovimentacaoPortaria() {
		
	}
	

	public MovimentacaoPortaria(String tipoMovimentacao, LocalDateTime dataMovimentacao, Portaria portaria,
			Visitante visitante, FuncionarioPortaria funcionarioPortaria) {
		
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataMovimentacao = dataMovimentacao;
		this.portaria = portaria;
		this.visitante = visitante;
		this.funcionarioPortaria = funcionarioPortaria;
	}




	@Id
	@Column(name = "id_movimentacao")
	@GeneratedValue(generator = "movimentacao", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "tp_movimentacao")
	private String tipoMovimentacao;
	
	@Column(name = "dt_movimentacao")
	private LocalDateTime dataMovimentacao;
	
	
	@ManyToOne
	@JoinColumn(name = "id_portaria")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "id_visitante")
	private Visitante visitante;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario_portaria")
	private FuncionarioPortaria funcionarioPortaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public FuncionarioPortaria getFuncionarioPortaria() {
		return funcionarioPortaria;
	}

	public void setFuncionarioPortaria(FuncionarioPortaria funcionarioPortaria) {
		this.funcionarioPortaria = funcionarioPortaria;
	}
	
	@Override
	public String toString() {
		
		return "\nTipo Movimentação: " + this.getTipoMovimentacao()
		+"\nData Movimentaçaõ: " + this.getDataMovimentacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
		+"\nPortaria: " + this.getPortaria().getNomePortaria()
		+"\nVisitante: " + this.getVisitante();
	}
	
	
	

}
