package it.italiangrid.portal.dbapi.services;

import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.italiangrid.portal.dbapi.dao.generic.IdpDAO;
import it.italiangrid.portal.dbapi.dao.generic.UserInfoDAO;
import it.italiangrid.portal.dbapi.domain.Idp;
import it.italiangrid.portal.dbapi.domain.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger log = Logger
			.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private IdpDAO idpDAO;

	@Transactional
	public Integer save(UserInfo transientInstance) {
		log.debug("NEW *** persisting UserInfo instance");
		//return userInfoDAO.save(transientInstance);
		return userInfoDAO.makePersistent(transientInstance).getUserId();
	}

	@Transactional
	public void delete(UserInfo persistentInstance) {
		log.debug("NEW *** removing UserInfo instance");
		//userInfoDAO.delete(persistentInstance);
		userInfoDAO.makeTransient(persistentInstance);
	}

	@Transactional
	public void delete(int userId) {
		log.debug("NEW *** removing UserInfo instance");
		UserInfo persistentInstance = userInfoDAO.findById(userId, false);//.findById(userId);
		//userInfoDAO.delete(persistentInstance);
		userInfoDAO.makeTransient(persistentInstance);
		
	}

	@Transactional
	public UserInfo findById(Integer id) {
		log.debug("NEW *** getting UserInfo instance with id: " + id);
		//return userInfoDAO.findById(id);
		return userInfoDAO.findById(id, false);
	}

	@Transactional
	public List<UserInfo> getAllUserInfo() {
		log.debug("NEW *** getting all UserInfo instance");
		//return userInfoDAO.getAllUserInfo();
		return userInfoDAO.findAll();
	}

	@Transactional
	public void edit(UserInfo userInfo) {
		log.debug("NEW *** Editing existing userInfo");
		//userInfoDAO.edit(userInfo);
		userInfoDAO.makePersistent(userInfo);
	}

	@Transactional
	public int save(UserInfo userInfo, int idIDP) {
		log.debug("NEW *** persisting UserInfo instance");
		Idp idp = idpDAO.findById(idIDP,false);
		userInfo.setIdp(idp);
		//return userInfoDAO.save(userInfo);
		return userInfoDAO.makePersistent(userInfo).getUserId();
	}

	@Transactional
	public List<UserInfo> getAllUserInfoByName(String search) {
		log.debug("NEW *** getting all UserInfo instance");
		//return userInfoDAO.getAllUserInfoByName(search);
		return userInfoDAO.searchUserInfo(search);
	}
	
	@Transactional
	public UserInfo findByUsername(String username) {
		log.debug("NEW *** getting all UserInfo instance");
		return userInfoDAO.findByUsername(username);
		//return userInfoDAO.getUserInfoByUsername(username);
	}
	
	@Transactional
	public UserInfo findByMail(String mail) {
		log.debug("NEW *** getting all UserInfo instance");
		return userInfoDAO.findByMail(mail);
		//return userInfoDAO.getUserInfoByUsername(username);
	}

}
