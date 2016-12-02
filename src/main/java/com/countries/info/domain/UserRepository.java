package com.countries.info.domain;

import org.springframework.data.repository.CrudRepository;

/*The CrudRepository provides CRUD functionality for the entity
class(User)
*  By extending CrudRepository the UserRepository inherits
	methods for working with User persistence
	* findByUsername - CrudRepository can derive the query from 
    the field name
 */

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}