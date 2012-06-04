package it.italiangrid.portal.dbapi.dao.hibernate;

import it.italiangrid.portal.dbapi.dao.generic.IdpDAO;
import it.italiangrid.portal.dbapi.domain.Idp;

import org.springframework.stereotype.Repository;

@Repository
public class IdpDAOHibernate extends GenericHibernateDAO<Idp, Integer> implements IdpDAO {

}
