package org.example.service

import org.example.repository.ProductRepository
import org.example.service.imp.ProductServiceImplementation

class ServiceModule(val productService: ProductService) {
    companion object {
        fun create(productRepository: ProductRepository) = ServiceModule(
            productService = ProductServiceImplementation(productRepository)
        )
    }
}