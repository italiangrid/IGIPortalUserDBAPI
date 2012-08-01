package it.italiangrid.portal.dbapi.dao.hibernate;

import it.italiangrid.portal.dbapi.dao.generic.NotifyDAO;
import it.italiangrid.portal.dbapi.domain.Notify;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class NotifyDAOHibernate extends GenericHibernateDAO<Notify, Integer> implements NotifyDAO {

	public Notify findByUserInfo(UserInfo userInfo) {
		
		return findByCriteria(Restrictions.eq("userInfo", userInfo)).get(0);
	}

}