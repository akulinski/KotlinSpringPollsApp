package com.akulinski.poolsapplication.core.components.repositories

import com.akulinski.poolsapplication.core.components.entites.OptionEntity
import com.akulinski.poolsapplication.core.components.entites.PoolEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OptionRepository : CrudRepository<OptionEntity, Int>{


    fun findBy_poolEntity(_poolEntity: PoolEntity):Iterable<OptionEntity>
}