import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

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
	public void testGenerarMemes() throws Exception {
		List<Memes> memes = Programa.generarMemes();
		
		assertNotNull(memes, "La lista no debe ser null");
	}
}