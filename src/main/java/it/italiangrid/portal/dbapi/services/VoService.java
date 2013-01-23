package it.italiangrid.portal.dbapi.services;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.Vo;

public interface VoService {

	public List<Vo> getAllVo();

	public Vo findById(Integer id);

	public String findByVo(Vo vo);

	public List<String> getAllDiscplines();

	public List<Vo> getAllVoByName(String search);

	public Vo findByName(String search);
	
	public void save(Vo vo);
	
	public void delete(Integer id);

}
