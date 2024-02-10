package org.example.repository

import com.mongodb.client.result.DeleteResult
import org.example.domain.Product
import java.util.*

interface ProductRepository {
    fun insertProduct(product: Product)
    fun getProductById(productId: UUID): Product?
    fun updateProduct(product: Product)
    fun deleteProduct(productId: UUID): DeleteResult?
}