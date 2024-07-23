package ru.lebedev.dao;

import java.util.List;

public interface Dao<K, T> {

	T add(T t);
	List<T> findAll();
	T findById(K k);
	boolean create(T t);
	boolean delete(K k);
}
