package org.example.service.imp

import org.example.domain.Product
import org.example.repository.ProductRepository
import org.example.service.ProductService
import java.util.*

class ProductServiceImplementation(val productRepository: ProductRepository) : ProductService {
    override fun createProduct(product: Product) {
        productRepository.insertProduct(product)
    }

    override fun getProductById(productId: UUID) =
        productRepository.getProductById(productId)


    override fun updateProduct(product: Product) {
        productRepository.updateProduct(product)
    }

    override fun deleteProductById(productId: UUID) {
        productRepository.deleteProduct(productId)
    }
}