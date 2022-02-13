package com.peyman.data.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="persistent_logins")
public class PersistentLogin {

	@Column(nullable=false,length=64)
	private String username;
	
	@Id
	@Column(nullable=false,length=64)
	private String series;
	
	@Column(nullable=false,length=64)
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_used",nullable=false)
	private Date date;

	
	public PersistentLogin() {
		
	}
	
	public PersistentLogin(PersistentRememberMeToken token){
		
		        this.series = token.getSeries();
		
		        this.username = token.getUsername();
		
		        this.token = token.getTokenValue();
		
		        this.date = token.getDate();
		
		    }


	
}
