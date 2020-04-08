package com.qintess.webapi.dao;

import java.util.List;

public interface GenericDao<T> {

	public void salvarOuAlterarDAO(T item);
	
	public T buscarPorIdDAO(Class<T> clazz,int id);
	
	public List<T> buscarTodosDAO(Class<T> clazz);
	
	public void deletarDAO(Class<T> clazz, int id);
	
}
