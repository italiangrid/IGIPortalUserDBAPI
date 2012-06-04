package it.italiangrid.portal.dbapi.dao.generic;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.Vo;

public interface VoDAO extends GenericDAO<Vo, Integer> {
	
	List<String> getAllDiscipline();
	
	List<Vo> findAll(String search);

}
