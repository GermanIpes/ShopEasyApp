package org.example.repository.imp

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.Document
import org.example.domain.Product
import org.example.repository.DbCollectionNames
import org.example.repository.ProductRepository
import org.example.repository.dao.ProductDao
import org.litote.kmongo.eq
import org.litote.kmongo.json
import org.litote.kmongo.updateOne
import java.util.*

class ProductRepositoryImplementation(mongoClient: MongoClient) : ProductRepository {
    private val database = mongoClient.getDatabase("ShoppEasyApp")
    private val collection: MongoCollection<ProductDao> =
        database.getCollection(DbCollectionNames.PRODUCT.collectionName, ProductDao::class.java)

    override fun insertProduct(product: Product) {
        collection.insertOne(product.toDao())
    }

    override fun getProductById(productId: UUID): Product? =
        collection.find(ProductDao::id eq productId).first()?.toModel()


    override fun updateProduct(product: Product) {
        collection.replaceOne(ProductDao::id eq product.id, product.toDao())
    }

    override fun deleteProduct(productId: UUID) =
        collection.deleteOne(ProductDao::id eq productId)

}