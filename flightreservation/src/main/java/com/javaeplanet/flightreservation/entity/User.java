package com.javaeplanet.flightreservation.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@ManyToMany
//	@JoinTable(name = "std_role", joinColumns = @JoinColumn(name = "std_id"),
//	inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JoinTable(name="std_role",joinColumns = @JoinColumn(name="std_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
}
