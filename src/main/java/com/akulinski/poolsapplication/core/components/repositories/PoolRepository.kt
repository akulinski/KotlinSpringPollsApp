package com.akulinski.poolsapplication.core.components.repositories

import com.akulinski.poolsapplication.core.components.entites.PoolEntity
import com.akulinski.poolsapplication.core.components.entites.users.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PoolRepository : CrudRepository<PoolEntity,Long> {

    fun findBy_title(_title:String): Iterable<PoolEntity>
    fun findBy_userEntity(_userEntity:UserEntity):Iterable<PoolEntity>

    fun findBy_id(_id:Int):PoolEntity
}