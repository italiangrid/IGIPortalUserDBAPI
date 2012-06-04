package it.italiangrid.portal.dbapi.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import it.italiangrid.portal.dbapi.dao.generic.CertificateDAO;
import it.italiangrid.portal.dbapi.dao.generic.DAOFactory;
import it.italiangrid.portal.dbapi.dao.generic.IdpDAO;
import it.italiangrid.portal.dbapi.dao.generic.UserInfoDAO;
import it.italiangrid.portal.dbapi.dao.generic.UserToVoDAO;
import it.italiangrid.portal.dbapi.dao.generic.VoDAO;

public class HibernateDAOFactory extends DAOFactory {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	private GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO dao = (GenericHibernateDAO) daoClass
					.newInstance();
			// dao.setSession(getCurrentSession());
			return dao;
		} catch (Exception ex) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass,
					ex);
		}
	}

	// You could override this if you don't want HibernateUtil for lookup
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// Inline concrete DAO implementations with no business-related data access
	// methods.
	// If we use public static nested classes, we can centralize all of them in
	// one source file.

	/*
	 * public static class CommentDAOHibernate extends
	 * GenericHibernateDAO<Comment, Long> implements CommentDAO {}
	 * 
	 * public static class ShipmentDAOHibernate extends
	 * GenericHibernateDAO<Shipment, Long> implements ShipmentDAO {}
	 */

	@Override
	public CertificateDAO getCertificateDAO() {
		// TODO Auto-generated method stub
		return (CertificateDAO) instantiateDAO(CertificateDAO.class);
	}

	@Override
	public IdpDAO getIdpDAO() {
		// TODO Auto-generated method stub
		return (IdpDAO) instantiateDAO(IdpDAO.class);
	}

	@Override
	public UserInfoDAO getUserInfoDAO() {
		// TODO Auto-generated method stub
		return (UserInfoDAO) instantiateDAO(UserInfoDAO.class);
	}

	@Override
	public UserToVoDAO getUserToVoDAO() {
		// TODO Auto-generated method stub
		return (UserToVoDAO) instantiateDAO(UserToVoDAO.class);
	}

	@Override
	public VoDAO getVoDAO() {
		// TODO Auto-generated method stub
		return (VoDAO) instantiateDAO(VoDAO.class);
	}

}
