package org.example.service

import org.example.domain.Product
import java.util.UUID

interface ProductService {
    fun createProduct(product: Product)
    fun getProductById(productId: UUID): Product?
    fun updateProduct(product: Product)
    fun deleteProductById(productId: UUID)
}