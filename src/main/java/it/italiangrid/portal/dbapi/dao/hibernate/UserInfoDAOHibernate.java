package it.italiangrid.portal.dbapi.dao.hibernate;

import it.italiangrid.portal.dbapi.dao.generic.UserInfoDAO;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDAOHibernate extends
		GenericHibernateDAO<UserInfo, Integer> implements UserInfoDAO {

	private static final Logger log = Logger
			.getLogger(UserInfoDAOHibernate.class);

	public List<UserInfo> searchUserInfo(String search) {
		log.debug("Searching specific UserInfo istances oreder by lastname and firstname");
		return findByCriteria(
				Restrictions
						.disjunction()
						.add(Restrictions.ilike("lastName", search,
								MatchMode.ANYWHERE))
						.add(Restrictions.ilike("firstName", search,
								MatchMode.ANYWHERE)),
				Restrictions.sqlRestriction("1=1 ORDER BY lastname, firstname"));
	}

	public UserInfo findByUsername(String username) {
		log.debug("Getting UserInfo istance by username");
		return findByCriteria(Restrictions.eq("username", username)).get(0);
	}

	public List<UserInfo> findAll() {
		log.debug("Getting all UserInfo istances oreder by lastname and firstname");
		return findByCriteria(Restrictions
				.sqlRestriction("1=1 ORDER BY lastname, firstname"));
	}

}
