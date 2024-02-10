import io.javalin.Javalin
import org.example.httpServer.controller.ProductController

class HttpServerModule(val productController: ProductController) {
    fun startJavalin() {
        Javalin.create().start(8080)
            .post("/api/Products") { ctx -> productController.postProduct(ctx) }
            .get("/api/Products/{ProductId}") { ctx -> productController.getProduct(ctx) }
            .put("/api/Products") { ctx -> productController.updateProduct(ctx) }
            .delete("/api/Products/{ProductId}") { ctx -> productController.deleteProduct(ctx) }
    }
}