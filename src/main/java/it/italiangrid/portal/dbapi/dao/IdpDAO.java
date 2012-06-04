package it.italiangrid.portal.dbapi.dao;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.Idp;

public interface IdpDAO {

	public void save(Idp transientInstance);

	public void delete(Idp persistentInstance);

	public Idp findById(Integer id);

	public List<Idp> getAllIdp();
}
