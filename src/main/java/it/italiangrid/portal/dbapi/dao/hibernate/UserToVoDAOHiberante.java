package it.italiangrid.portal.dbapi.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import it.italiangrid.portal.dbapi.dao.generic.UserToVoDAO;
import it.italiangrid.portal.dbapi.domain.UserInfo;
import it.italiangrid.portal.dbapi.domain.UserToVo;
import it.italiangrid.portal.dbapi.domain.UserToVoId;
import it.italiangrid.portal.dbapi.domain.Vo;

@Repository
public class UserToVoDAOHiberante extends GenericHibernateDAO<UserToVo, UserToVoId> implements UserToVoDAO {

	private static final Logger log = Logger.getLogger(UserToVoDAOHiberante.class);

	@SuppressWarnings("unchecked")
	public List<UserToVo> findById(UserInfo userInfo) {
		log.debug("getting all Certificate instance of user");
		try {

			// Create a Hibernate query (HQL)
			Query query = getSession().createQuery("FROM  UserToVo WHERE userId = "
					+ userInfo.getUserId());

			// Retrieve all
			return query.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Vo getVoByUserToVo(UserToVo userToVo) {
		log.debug("getting all Certificate instance of user");
		try {
			return (Vo) getSession().get(Vo.class,
					getSession().getIdentifier(userToVo.getVo()));
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void delete(int userId, int idVo) {
		log.debug("getting all Certificate instance of user");
		try {
			UserToVo utv = findByIds(userId, idVo);
			getSession().delete(utv);
			flush();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	public UserToVo findByIds(int userId, int idVo) {
		log.debug("getting all Certificate instance of user");
		try {
			UserToVoId userToVoId = new UserToVoId(userId, idVo);
			return (UserToVo) getSession().get(UserToVo.class, userToVoId);

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;

		}
	}

	@SuppressWarnings("rawtypes")
	public int getNumberOfUserToVo(int userId) {
		log.debug("getting the number of Vo fo userId = " + userId);
		try {
			int count = 0;
			String QUERY = "FROM UserToVo WHERE userId = "
					+ userId;
			Query query = getSession().createQuery(QUERY);
			for (Iterator it = query.iterate(); it.hasNext();) {
				it.next();
				count++;
			}

			return count;

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;

		}
	}

	public void deleteByIdCert(int idCert) {
		log.debug("deleting istances with idCert = " + idCert);
		try {
		
			Query query = getSession().createQuery("FROM UserToVo WHERE idCert = " + idCert);
			flush();
			
			@SuppressWarnings("unchecked")
			List<UserToVo> utvs = query.list();
			
			for (Iterator<UserToVo> iterator = utvs.iterator(); iterator.hasNext();) {
				UserToVo userToVo = (UserToVo) iterator.next();
				getSession().delete(userToVo);
			}
			

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;

		}
		
	}

	@SuppressWarnings("unchecked")
	public List<UserToVo> findUserByVo(Vo vo) {
		log.debug("getting all Certificate instance of user");
		try {

			// Create a Hibernate query (HQL)
			Query query = getSession().createQuery("FROM  UserToVo WHERE idVO = "
					+ vo.getIdVo());

			// Retrieve all
			return query.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public UserInfo getUserByUserToVo(UserToVo utv) {
		log.debug("getting all Certificate instance of user");
		try {
			return (UserInfo) getSession().get(UserInfo.class,
					getSession().getIdentifier(utv.getUserInfo()));
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
