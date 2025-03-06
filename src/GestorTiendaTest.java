import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GestorTiendaTest {
    private GestorTienda gestor;

    @Before
    public void setUp() {
        gestor = new GestorTienda();
    }

    @Test
    public void testCalcularDescuento() {
        assertEquals(10.0, gestor.calcularDescuento(100, 10), 0.01);	// 10% descuento
        assertEquals(5.0, gestor.calcularDescuento(100, 5), 0.01);		// 5% descuento
        assertEquals(0.0, gestor.calcularDescuento(100, 4), 0.01);		// Sin descuento
    }

    @Test
    public void testCategorizarProducto() {
        assertEquals("Económico", gestor.categorizarProducto(5));		// menos de 10
        assertEquals("Estándar", gestor.categorizarProducto(20));		// menos de 50
        assertEquals("Premium", gestor.categorizarProducto(100));		// más de 50
    }

    @Test
    public void testBuscarProducto() {
    	String [] inventario = {"Rodillo", "Rastrillo"};
        assertEquals("Rodillo", gestor.buscarProducto(inventario, "Rodillo"));	// encontrar producto
        assertNull(gestor.buscarProducto(inventario, "Pala"));					// no devolver nada
    }
}