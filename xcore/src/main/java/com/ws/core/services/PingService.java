package com.ws.core.services;

import java.net.InetAddress;

import com.ws.core.interceptors.Common;
import com.ws.core.models.Ping;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PingService {

	@Inject
	private Ping ping;
	@PersistenceContext
	private EntityManager em;

	public void save()
	{

		Ping ping = new Ping();
		ping.setCommand(this.ping.getCommand());
		ping.setReceived(this.ping.getReceived());
		em.persist(ping);

	}

	@Common
	public Ping  doPing(String to) {
		InetAddress inet;

		try {
			
			inet = InetAddress.getByName(to);
			ping.setCommand("Sending Ping Request to " + inet);
			ping.setReceived(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
			save();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ping;

	}

}
