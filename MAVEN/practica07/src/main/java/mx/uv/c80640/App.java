package mx.uv.c80640;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App{
    public static Gson gson = new Gson();
    //Base de datos en memoria
    public static Map<String, Usuario> usuarios = new HashMap<>();  
    public static void main( String[] args ) {
        port(80);
        //Inicialización de datos
        Usuario u1 = new Usuario("1", "Pablo", "1234");
        Usuario u2 = new Usuario("2", "Ana", "7890");

        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);

        System.out.println( "Hello World!" );
        //before((req, res)-> res.type("application/json"));
        get("/usuario", (req, res)-> gson.toJson(u1)); //Convierte un objeto en un objeto gson
        get("/usuarios", (req, res)-> gson.toJson(usuarios));

        //Post -> Nos permite recibir datos que vienen en formato JSon
        post("/", (req,res)->{
            String datosF = req.body(); //Devielve los datos del formulario
            Usuario u = gson.fromJson(datosF, Usuario.class);
            usuarios.put(u.getId(), u);
            return "Usuario agregado"; //return Necesario para que post no marque error
        });

    }
}
