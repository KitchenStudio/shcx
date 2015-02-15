package org.kitchenstudio.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Account implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	@Column
	private String password;
	@Column
	private boolean accountNonExpired;
	@Column
	private boolean accountNonLocked;
	@Column
	private boolean credentialsNonExpired;
	@Column
	private boolean enabled;

	@JoinTable(name = "ACCOUNT_AUTH")
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authorities = new HashSet<>();

	@PrePersist
	protected void onCreated() {
		accountNonExpired = true;
		accountNonLocked = true;
		credentialsNonExpired = true;
		enabled = true;
	}

	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}

	@Override
	public Collection<Authority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
