package it.italiangrid.portal.dbapi.services;

import it.italiangrid.portal.dbapi.domain.Notify;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import java.util.List;

public interface NotifyService {
	
	public void save(Notify transientInstance);

	public void delete(Notify persistentInstance);

	public Notify findById(Integer id);
	
	public Notify findByUserInfo(UserInfo userInfo);

	public List<Notify> getAllNotify();

}
