package it.italiangrid.portal.dbapi.services;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.UserInfo;

public interface UserInfoService {

	public Integer save(UserInfo transientInstance);

	public void delete(UserInfo persistentInstance);

	public void delete(int userId);

	public UserInfo findById(Integer id);

	public List<UserInfo> getAllUserInfo();

	public void edit(UserInfo userInfo);

	public int save(UserInfo userInfo, int idIDP);

	public List<UserInfo> getAllUserInfoByName(String search);
	
	public UserInfo findByUsername(String username);
	
	public UserInfo findByMail(String username);

}
