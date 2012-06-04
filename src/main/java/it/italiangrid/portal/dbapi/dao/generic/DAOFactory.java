package it.italiangrid.portal.dbapi.dao.generic;

import it.italiangrid.portal.dbapi.dao.hibernate.HibernateDAOFactory;

public abstract class DAOFactory {

	/**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
    @SuppressWarnings("rawtypes")
	public static final Class HIBERNATE = HibernateDAOFactory.class;
 
    /**
     * Factory method for instantiation of concrete factories.
     */
    @SuppressWarnings("rawtypes")
	public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }
    
    public static DAOFactory instance() {
		return instance(HIBERNATE);
	}
 
    // Add your DAO interfaces here
    public abstract CertificateDAO getCertificateDAO();
    public abstract IdpDAO getIdpDAO();
    public abstract UserInfoDAO getUserInfoDAO();
    public abstract UserToVoDAO getUserToVoDAO();
    public abstract VoDAO getVoDAO();
	
}
