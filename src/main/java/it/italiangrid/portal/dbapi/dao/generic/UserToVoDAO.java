package it.italiangrid.portal.dbapi.dao.generic;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.UserInfo;
import it.italiangrid.portal.dbapi.domain.UserToVo;
import it.italiangrid.portal.dbapi.domain.UserToVoId;
import it.italiangrid.portal.dbapi.domain.Vo;

public interface UserToVoDAO extends GenericDAO<UserToVo, UserToVoId> {

	public List<UserToVo> findById(UserInfo userInfo);

	public Vo getVoByUserToVo(UserToVo userToVo);

	public void delete(int userId, int idVo);

	public UserToVo findByIds(int userId, int idVo);

	public int getNumberOfUserToVo(int userId);

	public void deleteByIdCert(int idCert);
	
	public List<UserToVo> findUserByVo(Vo vo);

	public UserInfo getUserByUserToVo(UserToVo utv);

}
