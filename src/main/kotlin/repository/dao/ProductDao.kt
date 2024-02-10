package org.example.repository.dao

import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.example.domain.Product
import java.util.UUID
data class ProductDao @BsonCreator constructor(
    @BsonId @BsonProperty("id") val id: UUID,
    @BsonProperty("name") val name: String,
    @BsonProperty("description") val description: String,
    @BsonProperty("price") val price: Double,
    @BsonProperty("category") val category: String
) {
    fun toModel() = Product(
        this.id,
        this.name,
        this.description,
        this.price,
        this.category,
    )
}
