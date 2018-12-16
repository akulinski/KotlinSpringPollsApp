package com.akulinski.poolsapplication.config

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.MimeMappings
import org.springframework.boot.web.server.WebServerFactoryCustomizer


class ServletCustomizer : WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    override fun customize(factory: TomcatServletWebServerFactory?) {
        val mappings = MimeMappings(MimeMappings.DEFAULT)
        mappings.add("woff", "application/x-font-woff")
        factory?.mimeMappings = mappings
    }
}