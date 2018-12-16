package com.akulinski.poolsapplication.core.components.controllers

import com.akulinski.poolsapplication.core.components.entites.OptionEntity
import com.akulinski.poolsapplication.core.components.entites.PoolEntity
import com.akulinski.poolsapplication.core.components.entites.users.UserEntity
import com.akulinski.poolsapplication.core.components.repositories.OptionRepository
import com.akulinski.poolsapplication.core.components.repositories.PoolRepository
import com.akulinski.poolsapplication.core.components.repositories.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller()
@RequestMapping(value = ["/pools"])
class PoolsController {

    private val USERNAME = "USERNAME"

    @Autowired
    private var userRepository: UserRepository? = null

    @Autowired
    private var poolRepository: PoolRepository? = null

    @Autowired
    private var optionRepository: OptionRepository? = null;

    @GetMapping("/getAll")
    fun renderPoolsSite(httpServletRequest: HttpServletRequest, model: Model): String {

        val username: String = httpServletRequest.userPrincipal.name;

        model.addAttribute(USERNAME, username)

        val userEntity: UserEntity = userRepository!!.findAllByUsername(username)

        model.addAttribute("pools", poolRepository?.findBy_userEntity(userEntity))

        return "PoolsSite"
    }


    @GetMapping("/pool/{id}")
    fun renderPool(httpServletRequest: HttpServletRequest, model: Model, @PathVariable id: String): String {
        val poolEntity: PoolEntity = poolRepository!!.findBy_id(Integer.parseInt(id))
        val options : Array<OptionEntity> = optionRepository!!.findBy_poolEntity(poolEntity).toList().toTypedArray()

        model.addAttribute("pool", poolEntity)
        model.addAttribute("options",options)

        return "Pool"
    }

}