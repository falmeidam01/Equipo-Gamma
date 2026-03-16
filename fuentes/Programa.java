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
import java.util.Random;

public class Programa{
    public static void main(String[] args)throws Exception{

		List<Memes> memes = generarMemes();
        List<Realidades> realidad = leerRealidades();
        System.out.println(realidad);
		System.out.println(memes);
		
    }
	/**
     * Leer el fichero de memes y generar una lista.
     * @return List<Memes> Lista de memes que guarda los id y los memes.
     * @throws IOException cuando el fichero no existe o se produce un error
     */
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
	
	/**
     * Comprueba si el directorio resultados y el fichero resultados.txt existe y si no los crea.
     * @throws IOException cuando no puede crear el directorio o fichero.
     */
	public static void comprobarFichero() throws Exception{
		Path directorio = Paths.get("resultados");
		Path fichero = Paths.get("resultados" + File.separator + "resultados.txt");
		
		try{
			//Comprobar si existe el directorio
			if(!Files.exists(directorio)){
				Files.createDirectory(directorio);
				System.out.println("El directorio 'resultados' creado correctamente.");
			}else{
				System.out.println("El directorio ya existe.");
			}
			
			//Comprobar si existe el fichero
			if(!Files.exists(fichero)){
				Files.createFile(fichero);
				System.out.println("El fichero 'resultados.txt' creado correctamente.");
			}else{
				System.out.println("El fichero ya existe.");
			}
			
			//si ocurre un error, mostrar el mensaje
		}catch (IOException e){
			System.out.println("Error al crear el directorio o fichero: " + e.getMessage());
		}
	}
	
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
    
    /**
     * Elige un meme al azar de la lista y muestra su texto
     */
    /*public static Integer elegirMemes(List<Memes> memes){
        Random aleatorio = new Random();
        Integer idElegido = random.nextInt(memes.size());
        Meme elegido = memes.get(idElegido);
        System.out.println("Meme elegido: " + elegido.getTexto());
        return idElegido;
    }

    public static void comprobarRespuesta(Integer idElegido, String respuestaUsuario){
        Integer contadorPuntos = 0;
        Integer conversorRespuesta = Integer.valueOf(respuestaUsuario);
        Integer parseadorRespuesta = conversorRespuesta - 1;
        if ( idElegido == parseadorRespuesta ){
            System.out.println("¡Correcto! te sumamos un punto");
            contadorPuntos++;
        }else{
            System.out.println("Has fallado intentalo otra vez");
        }
    }*/
}