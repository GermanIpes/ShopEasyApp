import io.javalin.Javalin

object HttpServerModule {

    fun startJavalin(): Unit {
        val app = Javalin.create().start(8080)
        app.get("/") { ctx -> ctx.result("first endpoint")}
    }

}