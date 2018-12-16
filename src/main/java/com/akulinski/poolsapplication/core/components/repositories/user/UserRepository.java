package com.akulinski.poolsapplication.core.components.repositories.user;

import com.akulinski.poolsapplication.core.components.entites.users.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    UserEntity findAllByUsernameAndPassword(String username,String password);
    UserEntity findAllByUsername(String username);
}
