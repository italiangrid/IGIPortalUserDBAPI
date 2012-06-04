package it.italiangrid.portal.dbapi.dao;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.UserInfo;
import it.italiangrid.portal.dbapi.domain.UserToVo;
import it.italiangrid.portal.dbapi.domain.Vo;

public interface UserToVoDAO {

	public void save(UserToVo transientInstance);

	public List<UserToVo> findById(UserInfo userInfo);

	public Vo getVoByUserToVo(UserToVo userToVo);

	public void delete(int userId, int idVo);

	public UserToVo findByIds(int userId, int idVo);

	public void update(UserToVo temp);

	public int getNumberOfUserToVo(int userId);

	public void deleteByIdCert(int idCert);

}
