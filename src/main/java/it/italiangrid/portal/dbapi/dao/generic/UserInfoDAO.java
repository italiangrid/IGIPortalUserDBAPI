package it.italiangrid.portal.dbapi.dao.generic;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.UserInfo;

public interface UserInfoDAO extends GenericDAO<UserInfo, Integer> {

	List<UserInfo> searchUserInfo(String search);

	UserInfo findByUsername(String search);
	
	UserInfo findByMail(String search);

}
