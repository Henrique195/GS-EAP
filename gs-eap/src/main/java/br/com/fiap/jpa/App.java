package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.entity.FuncionarioPortaria;
import br.com.fiap.jpa.entity.MovimentacaoPortaria;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.impl.CondominioServiceImpl;
import br.com.fiap.jpa.service.impl.FuncionarioPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.PortariaServiceImpl;
import br.com.fiap.jpa.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		
		MovimentacaoPortariaServiceImpl movimentacaoPortariaService = MovimentacaoPortariaServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		FuncionarioPortariaServiceImpl funcionarioPortariaService = FuncionarioPortariaServiceImpl.getInstance();
		
		/**
		 * Cadastrando um novo condominio
		 */
		Condominio condominio = new Condominio("122242", "124452", "Condominio Edificio Ester", LocalDate.of(2022, 1, 1));
		condominioService.cadastrar(condominio);
		
		
		/**
		 * Cadastrar 2 entradas , uma com o nome Entra norte e outra com o nome 
		 * Entrada sul, associando elas ao evento cadastrado
		 */
		
		Portaria portaria1 = new Portaria(1, "Principal", condominio);
		Portaria portaria2 = new Portaria(2, "Serviço", condominio);
		
		portariaService.cadastrar(portaria1);
		portariaService.cadastrar(portaria2);
		
		
		/**
		 * Associada a portaria principal, cadastre as movimentacoes com os seguintes dados:
		 * -Participante com id 1, Tipo E, Data da Movimentacao 2022-01-01 11:15:00
		 * -Participante com id 2, Tipo E, Data da Movimentacao 2022-01-01 14:27:00
		 * -Participante com id 1, Tipo S, Data da Movimentacao 2022-01-01 15:52:00
		 * -Participante com id 2, Tipo S, Data da Movimentacao 2022-01-01 16:31:00
		 * 
		 */
		
		Visitante visitante1 = visitanteService.obter(1L);
		Visitante visitante2 = visitanteService.obter(2L);
		FuncionarioPortaria funcionario1 = funcionarioPortariaService.obter(1L);
		FuncionarioPortaria funcionario2 = funcionarioPortariaService.obter(2L);
		
		
		
		
		MovimentacaoPortaria movimentacao1 = new MovimentacaoPortaria("E",
				LocalDateTime.of(2022, 1, 1, 11, 15, 0), portaria1, visitante1, funcionario1);
		MovimentacaoPortaria movimentacao2 = new MovimentacaoPortaria("E",
				LocalDateTime.of(2022, 1, 1, 14, 27, 0), portaria1, visitante2, funcionario1);
		MovimentacaoPortaria movimentacao3 = new MovimentacaoPortaria("S",
				LocalDateTime.of(2022, 1, 1, 15, 52, 0), portaria1, visitante1,funcionario2);
	
		movimentacaoPortariaService.cadastrar(movimentacao1);
		movimentacaoPortariaService.cadastrar(movimentacao2);
		movimentacaoPortariaService.cadastrar(movimentacao3);
		
		
		/*
		 * Liste todas as movimentacoes com base no tipo da movimentacao
		 */
		movimentacaoPortariaService.listarPorTipo("S").forEach(System.out::println);
		
		/**
		 * Crie uma consulta que será montada
		 *  dinamicamente para pesquisar os participantes cadastrados
		 *   com base nos seguintes filtros:
		 *   nome, cpf e data de cadastro
		 */
		
		visitanteService.pesquisar("j", null, null).forEach(System.out::println);
		visitanteService.pesquisar("j", "111.111.111-11", null).forEach(System.out::println);
		
		
		
	
	}
}
