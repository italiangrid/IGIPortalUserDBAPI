package it.italiangrid.portal.dbapi.services;

// Generated 1-giu-2011 15.47.08 by Hibernate Tools 3.4.0.CR1

//import javax.ejb.Stateless;
//import javax.persistence.sessionFactory;
//import javax.persistence.PersistenceContext;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.italiangrid.portal.dbapi.dao.generic.CertificateDAO;
import it.italiangrid.portal.dbapi.dao.generic.UserInfoDAO;
import it.italiangrid.portal.dbapi.dao.generic.UserToVoDAO;
import it.italiangrid.portal.dbapi.domain.Certificate;
import it.italiangrid.portal.dbapi.domain.UserInfo;

/**
 * Home object for domain model class UserInfo.
 * 
 * @see it.italiangrid.portal.dbapi.services.UserInfo
 * @author Hibernate Tools
 */
@Service
public class CertificateServiceImpl implements CertificateService {

	private static final Logger log = Logger
			.getLogger(CertificateServiceImpl.class);

	@Autowired
	private CertificateDAO certificateDAO;
	
	@Autowired
	private UserToVoDAO userToVoDAO;

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Transactional
	public Integer save(Certificate transientInstance) {
		log.debug("NEW *** persisting Certificate instance");
		//return certificateDAO.save(transientInstance);
		return certificateDAO.makePersistent(transientInstance).getIdCert();
	}

	@Transactional
	public void delete(Certificate persistentInstance) {
		log.debug("NEW *** removing Certificate instance");
		//certificateDAO.delete(persistentInstance);
		certificateDAO.makeTransient(persistentInstance);
	}

	@Transactional
	public void delete(int idCert) {
		log.debug("NEW *** removing Certificate instance");
		
		userToVoDAO.deleteByIdCert(idCert);
		Certificate persistentInstance = certificateDAO.findById(idCert,false);
		
		certificateDAO.makeTransient(persistentInstance);
	}

	@Transactional
	public int save(Certificate certificate, int userId) {
		log.debug("NEW *** persisting Certificate instance");
		UserInfo userInfo = userInfoDAO.findById(userId,false);
		List<Certificate> lc = certificateDAO.findById(userInfo);

		certificate.setUserInfo(userInfo);
		certificate.setUsernameCert(userInfo.getUsername() + "_"
				+ certificate.getIdCert());

		if (certificate.getPrimaryCert().equals("true")) {

			Certificate tmp = null;

			int i = 0;

			for (i = 0; i < lc.size(); i++) {
				tmp = lc.get(i);
				tmp.setPrimaryCert("false");
				certificateDAO.makePersistent(tmp);
			}
		}

		int result = certificateDAO.makePersistent(certificate).getIdCert();

		certificate.setUsernameCert(userInfo.getUsername() + "_" + result);

		certificateDAO.makePersistent(certificate);

		return result;
	}

	@Transactional
	public List<Certificate> findById(int userId) {
		UserInfo userInfo = userInfoDAO.findById(userId,false);
		return certificateDAO.findById(userInfo);
	}

	@Transactional
	public boolean setDefault(int idCert) {
		log.debug("NEW *** ugrading Certificate instance");
		Certificate persistentInstance = certificateDAO.findById(idCert,false);

		if (persistentInstance.getPrimaryCert().equals("false")) {
			List<Certificate> lc = certificateDAO.findById(persistentInstance
					.getUserInfo());
			Certificate tmp = null;

			int i = 0;

			for (i = 0; i < lc.size(); i++) {
				tmp = lc.get(i);
				tmp.setPrimaryCert("false");
				certificateDAO.makePersistent(tmp);
			}

			persistentInstance.setPrimaryCert("true");
			certificateDAO.makePersistent(persistentInstance);
			return true;
		}

		return false;
	}

	@Transactional
	public Certificate findBySubject(String subject) {
		return certificateDAO.findBySubject(subject);
	}

	@Transactional
	public Certificate findByIdCert(Certificate certificate) {
		return certificateDAO.findById(certificate.getIdCert(),false);
	}

	@Transactional
	public Certificate findByIdCert(int idCert) {
		return certificateDAO.findById(idCert,false);
	}

	@Transactional
	public void update(Certificate cert) {
		certificateDAO.makePersistent(cert);
	}

	@Transactional
	public Certificate findByCertificateUsername(String username) {
		return certificateDAO.findById(username);
	}

}
