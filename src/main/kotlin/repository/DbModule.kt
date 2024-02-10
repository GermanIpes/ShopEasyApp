package org.example.repository

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients

class DbModule() {
    private fun setDbModule() {
        val connectionString = ConnectionString("mongodb://localhost:27017") // Change connection string as needed
        val settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()
        val mongoClient = MongoClients.create(settings)
    }

    companion object {
        fun create(): DbModule {
            return DbModule(
            )
        }
    }
}