package it.italiangrid.portal.dbapi.dao.generic;

import java.util.List;

import it.italiangrid.portal.dbapi.domain.Certificate;
import it.italiangrid.portal.dbapi.domain.UserInfo;

public interface CertificateDAO extends GenericDAO<Certificate, Integer>{

	//public Integer save(Certificate transientInstance);

	//public void delete(Certificate persistentInstance);

	public List<Certificate> findById(UserInfo userInfo);

	//public Certificate findById(Integer id);

	//public void edit(Certificate certificate);

	public Certificate findBySubject(String subject);

	public Certificate findById(String username);

	//public void update(Certificate cert);

}
