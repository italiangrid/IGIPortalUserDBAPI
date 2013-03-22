package it.italiangrid.portal.dbapi.services;

import it.italiangrid.portal.dbapi.dao.generic.SshKeysDAO;
import it.italiangrid.portal.dbapi.domain.SshKeys;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SshKeysServiceImpl implements SshKeysService {

	private static final Logger log = Logger.getLogger(SshKeysServiceImpl.class);

	@Autowired
	private SshKeysDAO sshKeysDAO;

	@Transactional
	public void save(SshKeys transientInstance) {
		log.debug("persisting SshKeys instance");
		sshKeysDAO.makePersistent(transientInstance);
	}

	@Transactional
	public void delete(SshKeys persistentInstance) {
		log.debug("removing SshKeys instance");
		sshKeysDAO.makeTransient(persistentInstance);
	}

	@Transactional
	public SshKeys findById(Integer id) {
		log.debug("getting SshKeys instance with id: " + id);
		return sshKeysDAO.findById(id,false);
	}

	@Transactional
	public SshKeys findByUserInfo(UserInfo userInfo) {
		log.debug("getting SshKeys instance");
		return sshKeysDAO.findByUserInfo(userInfo);
	}

	@Transactional
	public List<SshKeys> getAllSshKeys() {
		log.debug("getting all SshKeys instance");
		return sshKeysDAO.findAll();
	}

}
