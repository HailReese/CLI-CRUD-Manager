package com.github.hailreese.repository.interfaces;

import java.util.List;

public interface GenericRepository<T, ID> {
	T getById(ID id);

	List<T> getAll();

	T save(T entity);

	T update(T entity);

	void deleteById(ID id);
}
