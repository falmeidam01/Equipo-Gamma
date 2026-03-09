import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Programa{
    public static void main(String[] args)throws Exception{
        String nombreFichero = "..\\datos\\memes.txt";
        try {
            List<String> lineas = leerFichero(nombreFichero);
            System.out.println("Leyendo el fichero....");
            for(String linea : lineas){
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un erro");
        }
    }
    public static List<String> leerFichero(String nombreFichero) throws Exception{
        Path ruta = Paths.get(nombreFichero);
        if (!Files.exists(ruta)) {
            throw new IOException("El fichero '" + nombreFichero + "' no existe.");
        }
        return Files.readAllLines(ruta);
    }
}