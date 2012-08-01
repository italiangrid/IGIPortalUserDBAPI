package it.italiangrid.portal.dbapi.services;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.italiangrid.portal.dbapi.dao.generic.NotifyDAO;
import it.italiangrid.portal.dbapi.domain.Notify;
import it.italiangrid.portal.dbapi.domain.UserInfo;

@Service
public class NotifyServiceImpl implements NotifyService {

	private static final Logger log = Logger.getLogger(NotifyServiceImpl.class);

	@Autowired
	private NotifyDAO notifyDAO;

	@Transactional
	public void save(Notify transientInstance) {
		log.debug("persisting Notify instance");
		notifyDAO.makePersistent(transientInstance);
	}

	@Transactional
	public void delete(Notify persistentInstance) {
		log.debug("removing Notify instance");
		notifyDAO.makeTransient(persistentInstance);
	}

	@Transactional
	public Notify findById(Integer id) {
		log.debug("getting Notify instance with id: " + id);
		return notifyDAO.findById(id,false);
	}

	@Transactional
	public Notify findByUserInfo(UserInfo userInfo) {
		log.debug("getting Notify instance");
		return notifyDAO.findByUserInfo(userInfo);
	}

	@Transactional
	public List<Notify> getAllNotify() {
		log.debug("getting all Notify instance");
		return notifyDAO.findAll();
	}
}
