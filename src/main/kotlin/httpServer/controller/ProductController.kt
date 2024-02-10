package org.example.httpServer.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse
import org.example.httpServer.dto.ProductDto
import org.example.service.ProductService
import java.util.*

class ProductController(private val productService: ProductService) {

    private val mapper = jacksonObjectMapper()
    private val productIdParam = "ProductId"

    fun postProduct(ctx: Context) {
        val product = mapper.readValue(ctx.body(), ProductDto::class.java)
        ctx.json(productService.createProduct(product.toModel()))
    }

    fun getProduct(ctx: Context) {
        ctx.json(productService.getProductById(UUID.fromString(ctx.pathParam(productIdParam))) ?: NotFoundResponse())
    }

    fun updateProduct(ctx: Context) {
        val product = mapper.readValue(ctx.body(), ProductDto::class.java)
        ctx.json(productService.updateProduct(product.toModel()))
    }

    fun deleteProduct(ctx: Context) {
        ctx.json(productService.deleteProductById(UUID.fromString(ctx.pathParam(productIdParam))))
    }
}