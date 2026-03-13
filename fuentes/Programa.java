import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import org.json.*;
import java.nio.file.*;
import java.util.*;
import java.io.File;

public class Programa{
    public static void main(String[] args)throws Exception{
        
        
        /*try {
            List<String> lineas = leerFichero(nombreFichero);
            System.out.println("Leyendo el fichero....");
            for(String linea : lineas){
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un erro");
        }
		*/
		List<Memes> memes = generarMemes();
        List<Realidades> realidad = leerRealidades();
        System.out.println(realidad);
		System.out.println(memes);
    }
	
	public static List<Memes> generarMemes() throws Exception{
		String nombreFichero = "datos" + File.separator + "memes.txt";
		Path ruta = Paths.get(nombreFichero);
        if (!Files.exists(ruta)) {
            throw new IOException("El fichero '" + nombreFichero + "' no existe.");
        }
		
		List<Memes> memes = new ArrayList<>();
		List<String> lineas = Files.readAllLines(ruta);	
		for (String linea : lineas){
			String[] trozos = linea.split(",");
			Integer id = Integer.valueOf(trozos[0].trim());
			String texto = trozos[1].trim();
			Memes meme = new Memes(id, texto);
			memes.add(meme);
		}
        return memes;
		
	}

    /*public static List<String> leerFichero(String nombreFichero) throws Exception{
        Path ruta = Paths.get(nombreFichero);
        if (!Files.exists(ruta)) {
            throw new IOException("El fichero '" + nombreFichero + "' no existe.");
        }
        return Files.readAllLines(ruta);
    }*/
    /**
     * Leer el fichero de realidades datos.json
     * @return List<Realidades> Lista realidades que guarda los id y el texto de cada realidad.
     * @throws IOException cuando el fichero no existe o se produce un error
     */
    public static List<Realidades> leerRealidades() throws IOException{
        Path path = Paths.get("datos" + File.separator + "datos.json");
        String contenido = new String(Files.readAllBytes(path));

        JSONArray arrayJson = new JSONArray(contenido);
        List<Realidades> realidad = new ArrayList<>();

        for (int i = 0; i < arrayJson.length(); i++){
            JSONObject objetoJson = arrayJson.getJSONObject(i);
            Integer id = objetoJson.getInt("id");
            String texto = objetoJson.getString("texto");

            Realidades datos = new Realidades(id, texto);
            realidad.add(datos);
        }
        return realidad;
    }
}