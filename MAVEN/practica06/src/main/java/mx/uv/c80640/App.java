package mx.uv.c80640;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        get("/hello", (req, res) -> "Hello World");
        get("/alex", (req, res) -> "Hello Alex");
        get("/Erick", (req, res) -> "Hello Erick");
        get("/", (req, res) -> "<h1>Bienvenido</h1><img src='https://www.uv.mx/v2/images/logouv.jpg'>");


    }
}
