package com.srmasset.manager.repository;

import com.srmasset.manager.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}