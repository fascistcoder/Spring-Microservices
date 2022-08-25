package com.photoappapi.users.repository;

import com.photoappapi.users.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
	Users findByEmail(String email);

	Users findByUserId(String userId);
}
