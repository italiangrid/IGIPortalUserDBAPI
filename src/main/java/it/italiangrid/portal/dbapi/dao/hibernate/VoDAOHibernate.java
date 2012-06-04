package it.italiangrid.portal.dbapi.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.italiangrid.portal.dbapi.dao.generic.VoDAO;
import it.italiangrid.portal.dbapi.domain.Vo;

@Repository
public class VoDAOHibernate extends GenericHibernateDAO<Vo, Integer> implements VoDAO {

	private static final Logger log = Logger
			.getLogger(VoDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<String> getAllDiscipline() {
		log.debug("Getting all Disciplines of all VO istances");
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.setProjection(Projections.distinct(Projections.property("discipline")));
		crit.add(Restrictions.sqlRestriction("1=1 ORDER BY discipline"));
		return crit.list();
	}
	
	public List<Vo> findAll() {
		log.debug("Getting all VO instances");
        return findByCriteria( Restrictions.sqlRestriction("1=1 ORDER BY vo"));
    }
	
	public List<Vo> findAll(String search) {
		log.debug("Searching VO instances");
        return findByCriteria( Restrictions.ilike("vo", search, MatchMode.ANYWHERE), Restrictions.sqlRestriction("1=1 ORDER BY vo"));
    }
	
	
}
