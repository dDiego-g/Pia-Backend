package com.example.pia.repositorys;

import java.util.List;

public interface Crud <T,P>{

	T find(P primary);
	void insert(T entity);
	void update(T entity);
	void delete(P primary);
	List<T> findAll();
}
