package com.ws.core.dao;

import java.util.List;

import jakarta.transaction.Transactional;

@Transactional
public interface IDao<T>
{

	public void persist(T entity);

	public void update(T entity);

	public void delete(T entity);

	public T fetch(Long id);

	public List<T> fetchAll();

}
