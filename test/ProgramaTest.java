import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.io.File;

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
}