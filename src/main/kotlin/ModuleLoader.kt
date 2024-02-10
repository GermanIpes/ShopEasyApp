package org.example

import HttpServerModule

object ModuleLoader {

    fun loadModules() {

        HttpServerModule.startJavalin()
    }
}