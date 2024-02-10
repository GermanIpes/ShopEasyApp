package org.example.httpServer.controller

import org.example.service.ProductService

class ControllerModule(val productController: ProductController) {
    companion object {
        fun create(productService: ProductService) = ControllerModule(
            productController = ProductController(productService)
        )
    }
}