package it.italiangrid.portal.dbapi.services;

import it.italiangrid.portal.dbapi.domain.SshKeys;
import it.italiangrid.portal.dbapi.domain.UserInfo;

import java.util.List;

public interface SshKeysService {
	public void save(SshKeys transientInstance);

	public void delete(SshKeys persistentInstance);

	public SshKeys findById(Integer id);
	
	public SshKeys findByUserInfo(UserInfo userInfo);

	public List<SshKeys> getAllSshKeys();
}
