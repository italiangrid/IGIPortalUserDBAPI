package it.italiangrid.portal.dbapi.dao.hibernate;

import it.italiangrid.portal.dbapi.dao.generic.GenericDAO;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = Logger
			.getLogger(GenericHibernateDAO.class);

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		log.debug("Constuctor of GenericHibernateDAO");
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		log.debug("Persisten Class is: " + persistentClass.getCanonicalName());
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		log.debug("Getting " + persistentClass.getCanonicalName()
				+ " by Identifier");
		T entity;
		if (lock) {
			entity = (T) getSession().get(getPersistentClass(), id,
					LockMode.UPGRADE);
		} else {
			entity = (T) getSession().get(getPersistentClass(), id);
		}
		return entity;
	}

	public List<T> findAll() {
		log.debug("Getting all " + persistentClass.getCanonicalName()
				+ " istances");
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		log.debug("Find by exzample of " + persistentClass.getCanonicalName()
				+ " istance");
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	public T makePersistent(T entity) {
		log.debug("Saving or updating " + persistentClass.getCanonicalName()
				+ " istance");
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		log.debug("Deleting " + persistentClass.getCanonicalName() + " istance");
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

}
