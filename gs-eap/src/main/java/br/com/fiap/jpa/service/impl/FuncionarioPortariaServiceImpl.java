package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.FuncionarioPortariaDAOImpl;
import br.com.fiap.jpa.dao.impl.HibernateGenericDAO;
import br.com.fiap.jpa.dao.impl.VisitanteDAOImpl;
import br.com.fiap.jpa.entity.FuncionarioPortaria;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.GenericService;

public class FuncionarioPortariaServiceImpl extends GenericService<FuncionarioPortaria, Long> {

private static FuncionarioPortariaServiceImpl instance = null;
	
	private FuncionarioPortariaDAOImpl funcionarioPortariaDAO;
	
	private FuncionarioPortariaServiceImpl() {
		this.funcionarioPortariaDAO = FuncionarioPortariaDAOImpl.getInstance();
	}
	
	public static FuncionarioPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncionarioPortariaServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(FuncionarioPortaria instance) {
		try {
			funcionarioPortariaDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(FuncionarioPortaria instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuncionarioPortaria obter(Long id) {
		FuncionarioPortaria funcionario = null;
		try {
			funcionario = funcionarioPortariaDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return funcionario;
		
	}

	@Override
	public List<FuncionarioPortaria> listar() {
		// TODO Auto-generated method stub
		return null;
	}	
}
