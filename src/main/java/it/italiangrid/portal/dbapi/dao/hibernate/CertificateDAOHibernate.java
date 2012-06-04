package it.italiangrid.portal.dbapi.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.italiangrid.portal.dbapi.dao.generic.CertificateDAO;
import it.italiangrid.portal.dbapi.domain.Certificate;
import it.italiangrid.portal.dbapi.domain.UserInfo;

@Repository
public class CertificateDAOHibernate extends
		GenericHibernateDAO<Certificate, Integer> implements CertificateDAO {

	private static final Logger log = Logger
			.getLogger(CertificateDAOHibernate.class);

	public List<Certificate> findById(UserInfo userInfo) {
		log.debug("getting all Certificate instance of user");
		return findByCriteria(Restrictions.eq("userInfo", userInfo));
	}

	public Certificate findBySubject(String subject) {
		log.debug("getting Certificate instance of specific Subject");
		return findByCriteria(Restrictions.eq("subject", subject)).get(0);
	}

}
