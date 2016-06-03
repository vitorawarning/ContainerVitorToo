package br.dftrans.wiki.dao;

import java.util.List;

import br.dftrans.wiki.exceptions.ExceptionDAO;

public interface DAO<T> {
	
	
	
	public void save(T t) throws ExceptionDAO;
	public List<T> getAll() throws ExceptionDAO;
	public T findByChave(String chave) throws ExceptionDAO;
	public boolean delete (T t) throws ExceptionDAO;
	public boolean update (T t) throws ExceptionDAO;
	public List<T> findByCod(Long cod) throws ExceptionDAO;
	public List<T> findByObj (T t) throws ExceptionDAO;
}
