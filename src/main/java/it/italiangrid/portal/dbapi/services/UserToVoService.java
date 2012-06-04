package it.italiangrid.portal.dbapi.services;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.UserToVo;
import it.italiangrid.portal.dbapi.domain.Vo;

public interface UserToVoService {

	public void save(UserToVo transientInstance);

	public void save(int userId, int idVo, String subject);

	public List<UserToVo> findById(int userId);

	public List<Vo> findVoByUserId(int userId);

	public void delete(int userId, int idVo);

	public boolean setDefault(int userId, int idVo);

	public UserToVo findById(int userId, int idVo);

	public void update(UserToVo utv);

	public String findDefaultVo(int userId);

	public String getDefaultFqan(int userId);

	public int getNumberOfUserToVo(int userId);

}
