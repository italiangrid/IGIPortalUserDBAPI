package it.italiangrid.portal.dbapi.dao.generic;

import it.italiangrid.portal.dbapi.domain.SshKeys;
import it.italiangrid.portal.dbapi.domain.UserInfo;

public interface SshKeysDAO extends GenericDAO<SshKeys, Integer> {
	
	SshKeys findByUserInfo(UserInfo userInfo);

}
