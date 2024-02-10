package org.example.domain

import org.example.repository.dao.ProductDao
import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val category: String
) {

    fun toDao() = ProductDao(
        this.id,
        this.name,
        this.description,
        this.price,
        this.category,
    )
}