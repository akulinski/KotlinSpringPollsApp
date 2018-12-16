package com.akulinski.poolsapplication.core.components.repositories.user;

import com.akulinski.poolsapplication.core.components.entites.users.AuthorityEntity;
import com.akulinski.poolsapplication.core.components.entites.users.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends CrudRepository<AuthorityEntity, Integer> {

    List<AuthorityEntity> findAllByUserEntity(UserEntity userEntity);

}

