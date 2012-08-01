package it.italiangrid.portal.dbapi.dao.generic;

import it.italiangrid.portal.dbapi.domain.Notify;
import it.italiangrid.portal.dbapi.domain.UserInfo;

public interface NotifyDAO extends GenericDAO<Notify, Integer> {
	
	Notify findByUserInfo(UserInfo userInfo);

}
