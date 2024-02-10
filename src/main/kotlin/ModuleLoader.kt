package org.example

import HttpServerModule
import org.example.httpServer.controller.ControllerModule
import org.example.repository.DbModule
import org.example.repository.imp.ProductRepositoryImplementation
import org.example.service.ServiceModule

object ModuleLoader {

    fun loadModules() {
        val dbModule = DbModule.create()
        val serviceModule = ServiceModule.create(dbModule.productRepositoryImplementation)
        val controllerModule = ControllerModule.create(serviceModule.productService)
        HttpServerModule(controllerModule.productController).startJavalin()
    }
}