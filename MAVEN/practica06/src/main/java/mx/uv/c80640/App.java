package mx.uv.c80640;

import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello", (req, res) -> "Hello World");
        get("/eduardo", (req, res) -> "Hello Eduardo");
        get("/alex", (req, res) -> "Hello Alex");
        get("/brandon", (req, res) -> "Hello Brandon");
        get("/", (req, res) -> "<h1> Bienvenido </h1><img src='https://www.adictosaltrabajo.com/wp-content/uploads/2016/12/spark-logo.png'>");

        post("/", (req, res) ->{
            System.out.println(req.queryParams("email")+" "+ req.queryParams("password"));
            System.out.println(req.body());
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticionCliente = new JsonObject(); 
            System.out.println(peticionCliente.get("email"));
            System.out.println(peticionCliente.get("password"));
            System.out.println(arbol);


            res.status(200);
            JsonObject oRespuesta= new JsonObject();
            oRespuesta.addProperty("msj","hola");
            oRespuesta.addProperty("email", req.queryParams("email"));
            return oRespuesta;
            
        });

    }
}
