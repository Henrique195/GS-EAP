package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.FuncionarioPortaria;

public class FuncionarioPortariaDAOImpl extends HibernateGenericDAO<FuncionarioPortaria, Long> {
	
private static FuncionarioPortariaDAOImpl instance = null;
	
	private FuncionarioPortariaDAOImpl() {
		super(FuncionarioPortaria.class);
	}

	public static FuncionarioPortariaDAOImpl getInstance() {
		if (instance == null) {
			instance = new FuncionarioPortariaDAOImpl();
		}
		return instance;
}
}
