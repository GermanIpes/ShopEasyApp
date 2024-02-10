package org.example.repository

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.bson.UuidRepresentation
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.example.repository.dao.ProductDao // Import the ProductDao class
import org.example.repository.imp.ProductRepositoryImplementation

class DbModule(val productRepositoryImplementation: ProductRepositoryImplementation) {
    companion object {
        private fun initializeMongoClient(): MongoClient {
            val pojoCodecRegistry = CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).register(ProductDao::class.java).build()
            )
            val codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry
            )
            val connectionString = ConnectionString("mongodb://localhost:27017")
            val settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build()
            return MongoClients.create(settings)
        }

        fun create(): DbModule {
            val mongodbClient = initializeMongoClient()
            return DbModule(
                productRepositoryImplementation = ProductRepositoryImplementation(mongoClient = mongodbClient)
            )
        }
    }
}
