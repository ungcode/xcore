package com.ws.core.services;

import java.util.Properties;

import com.ws.core.dao.user.UserDao;
import com.ws.core.interceptors.Timed;
import com.ws.core.models.Tuser;
import com.ws.core.security.PasswordManager;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class UserService
{

	@Inject
	UserDao<Tuser> dao;
	@Inject
	PasswordManager passwordManager;

	@Timed
	public Tuser persist(Tuser user, String password)
	{

		Properties properties = passwordManager.getProperties(password);
		user.setHash(properties.getProperty(PasswordManager.HASHED));
		user.setSalt(properties.getProperty(PasswordManager.SALT));
		dao.persist(user);
		return user;
	}


}
