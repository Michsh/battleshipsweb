package battleshipsweb.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

import battleshipsweb.exceptions.NoSuchUserException;
import battleshipsweb.exceptions.SessionExistsException;

import battleshipsweb.*;

public class SessionListener implements ApplicationListener<ApplicationEvent> {
	
	private BattleshipsDAO dao;
	
	private List<UserDetails> onlineUsers = new ArrayList<UserDetails>();
	
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event instanceof AuthenticationSuccessEvent) {
			
			AuthenticationSuccessEvent asEvent = (AuthenticationSuccessEvent)event;
			
			String username = asEvent.getAuthentication().getName();
			
			if(!this.listContains(username)) {
				
				this.addUser(username);
			}
		}
		
		if(event instanceof SessionDestroyedEvent) {
			
			SessionDestroyedEvent sdEvent = (SessionDestroyedEvent)event;
			
			if(sdEvent.getSecurityContexts().size() > 0) {
				
				String username = sdEvent.getSecurityContexts().get(0).getAuthentication().getName();
				
				this.removeUser(username);
			}
		}
	}
	
	public int getNumberOfOnlineUsers() {
		
		return onlineUsers.size();
	}
	
	private boolean listContains(String username) {
		
		for(UserDetails ud : onlineUsers) {
			
			if(ud.getUsername().equals(username)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private void addUser(String username) {
		
		onlineUsers.add(dao.getDetailsByUsername(username));
	}
	
	private void removeUser(String username) {
		
		UserDetails toRemove = null;
		
		for(UserDetails ud : onlineUsers) {
			
			if(ud.getUsername().equals(username)) {
				
				toRemove = ud;
			}
		}
		
		onlineUsers.remove(toRemove);
	}
	
	public void setDao(BattleshipsDAO dao) {
		
		this.dao = dao;
	}
}
