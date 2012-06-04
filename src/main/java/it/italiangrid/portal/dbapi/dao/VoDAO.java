package it.italiangrid.portal.dbapi.dao;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.Vo;

public interface VoDAO {

	public List<Vo> getAllVo();

	public Vo findById(Integer id);

	public List<String> getAllDiscipline();

	public List<Vo> getAllVoByName(String search);

}
