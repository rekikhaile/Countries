package com.countries.info.domain;

import javax.persistence.*;

/*Users are used from database*/
/*An entity represents a table in relational database
 * An entity class is annotated with @Entity annotation
 * by default the table name is the name of the entity class*/
@Entity
public class User {
/* @Id annotation is used for creating id column of the table
 * @GeneratedValue(strategy = GenerationType.IDENTITY) will enable the Entity to leverage on the AUTO_INCREMENT feature in automatically generating a 
  sequential number as primary key when inserted into the database.
 * @Column can be used to specify mapped column
  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Username with unique constraint
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    private String role;
    
    public User() {
    }

	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}