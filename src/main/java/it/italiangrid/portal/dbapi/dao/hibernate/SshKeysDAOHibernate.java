package it.italiangrid.portal.dbapi.dao.hibernate;

import java.util.List;

import it.italiangrid.portal.dbapi.dao.generic.SshKeysDAO;
import it.italiangrid.portal.dbapi.domain.SshKeys;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SshKeysDAOHibernate  extends GenericHibernateDAO<SshKeys, Integer> implements SshKeysDAO  {

	public SshKeys findByUserInfo(UserInfo userInfo) {
		List<SshKeys> results = findByCriteria(Restrictions.eq("userInfo", userInfo));
		if(results.isEmpty())
			return null;
		return results.get(0);
	}

}
