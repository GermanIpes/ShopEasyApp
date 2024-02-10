package org.example.httpServer.dto

import org.bson.codecs.pojo.annotations.BsonId
import org.example.domain.Product
import java.util.UUID

data class ProductDto(
    @BsonId
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val price: Double,
    val category: String
) {
    fun toModel() = Product(
        this.id,
        this.name,
        this.description,
        this.price,
        this.category,
    )
}