package com.ws.core.services;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.ws.core.i18n.I18nConfig;
import com.ws.core.interceptors.Timed;
import com.ws.core.models.Ping;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// to be removed
@ApplicationScoped
@Transactional
public class PingService  extends StandardService<Ping>{

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

	@Timed
	public PingService  doPing(String to) 
	{
		InetAddress inet;
		
		PingService pingService = new PingService();
		StandardResponse<Ping>response = new StandardResponse<Ping>();
		
		try {
			
			inet = InetAddress.getByName(to);
			ping.setCommand("Sending Ping Request to " + inet);
			ping.setReceived(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
			
			buildResponse(pingService, response);
			
			save();

		} catch (Exception e) 
		{
			setResponseError(Error.CODE,
							 Error.LEVEL,
							 Error.TEXT,
							 pingService,
							 response);
			return pingService;
			
		}
		
		return pingService;

	}

	private void setResponseError(int errorCode,
								  int errorLevel,
								  String errorText,
								  PingService pingService, 
								  StandardResponse<Ping> response) 
	{
		response.setData(asArray(new Ping()));
		setResponse(response);
		setError(errorCode,
				 errorLevel,
				 I18nConfig.getMessage(errorText));
		pingService.setResponse(response);
	}

	private void buildResponse(PingService pingService, StandardResponse<Ping> response) {
		response.setData(asArray(ping));
		setResponse(response);
		pingService.setResponse(response);
	}

}
