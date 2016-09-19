package br.fiocruz.dao;

import java.io.Serializable;

import br.fiocruz.exc.AkulaRuntimeException;

public interface Dao {
	public void create(Object o) throws AkulaRuntimeException;
	public Object merge(Object o) throws AkulaRuntimeException;
	public void remove(Object o) throws AkulaRuntimeException;
	public <T> T find(Class<T> c, Serializable pk) throws AkulaRuntimeException;
}