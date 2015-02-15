package org.kitchenstudio.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	public Authority() {
	}

	public Authority(String authority) {
		this.authority = authority;
	}

	@Id
	private String authority;

	@Override
	public String getAuthority() {
		return authority;
	}

}
