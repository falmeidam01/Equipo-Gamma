import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.io.File;
import org.junit.jupiter.api.BeforeEach;

public class ProgramaTest{
    @Test 
    public void testConstructor(){
        Programa programa1 = new Programa();
        assertNotEquals (null, programa1);
    }

   @Test
    public void testLeerRealidades() throws Exception {
        List<Realidades> lista = Programa.leerRealidades();

        assertNotNull(lista, "La lista no debe ser null");
        assertEquals(10, lista.size(), "Debe haber 10 realidades");

        Realidades r1 = lista.get(0);
        assertEquals(1, r1.getId());
        assertEquals("Las denuncias falsas representan solo el 0,01 % de los casos investigados. Fuente: Fiscalía General del Estado, Memoria 2023.", r1.getTexto());

        Realidades r2 = lista.get(1);
        assertEquals(2, r2.getId());
        assertEquals("En España la brecha salarial de género es del 18,36 % en salario medio anual. Fuente: Instituto Nacional de Estadística (INE), Encuesta Anual de Estructura Salarial.", r2.getTexto());
    }
	
	@Test
	public void testComprobarFichero() throws Exception {
		Programa.comprobarFichero();
		
		Path directorio = Path.of("resultados");
		assertTrue(Files.exists(directorio)&& Files.isDirectory(directorio), "El directorio 'resultados' debería existir");
		
		Path fichero = Path.of("resultados", "resultados.txt");
		assertTrue(Files.exists(fichero) && Files.isRegularFile(fichero), "El fichero 'resultados.txt' debería existir");
	}

	@Test
	public void testGenerarMemes() throws Exception {
		List<Memes> memes = Programa.generarMemes();
		
		assertNotNull(memes, "La lista no debe ser null");
	}
   @Test
    public void testElegirMemes() {
        List<Memes> lista = new ArrayList<>();
        lista.add(new Memes(1, "Las denuncias falsas por violencia de género son muy comunes."));
        lista.add(new Memes(2, "Las mujeres cobran menos porque trabajan menos horas."));
        lista.add(new Memes(3, "La igualdad entre hombres y mujeres ya está conseguida."));

        // Ejecutamos el método
        Integer idElegido = Programa.elegirMemes(lista);

        // Comprobaciones básicas
        assertNotNull(idElegido, "El id elegido no debe ser null");
    }

    @BeforeEach
    public void resetPuntos() {
        Programa.contadorPuntos = 0; // Reiniciamos antes de cada test
    }

    @Test
    public void testRespuestaCorrecta() throws Exception {
        Programa.comprobarRespuesta(3, 4);
        assertEquals(1, Programa.contadorPuntos, "Debe sumar un punto si la respuesta es correcta");
    }

    @Test
    public void testRespuestaIncorrecta() throws Exception {
        Programa.comprobarRespuesta(2, 7);
        assertEquals(0, Programa.contadorPuntos, "No debe sumar puntos si la respuesta es incorrecta");
    }

    @Test
    public void testRespuestaFueraDeRango() {
        assertThrows(Exception.class, () -> {
            Programa.comprobarRespuesta(1, -1);
        });
    }
}