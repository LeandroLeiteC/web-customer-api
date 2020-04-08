package com.qintess.webapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.qintess.webapi.entity.EntidadeBase;

@Repository
public class GenericDaoImpl<T extends EntidadeBase> implements GenericDao<T> {

	@PersistenceContext
	EntityManager em;

	@Override
	public void salvarOuAlterarDAO(T item) {
		if (item.getId() == null || item.getId() == 0) {
			em.persist(item);
		} else {
			em.merge(item);
		}
	}

	@Override
	public T buscarPorIdDAO(Class<T> clazz, int id) {
		return em.find(clazz, id);
	}

	@Override
	public List<T> buscarTodosDAO(Class<T> clazz) {
		return em.createQuery("select c from " + clazz.getSimpleName() + " c order by id", clazz).getResultList();
	}

	@Override
	public void deletarDAO(Class<T> clazz, int id) {
		System.out.println("ID GENERIC DAO " + id);
		em.remove(em.find(clazz, id));
	}
}
