package almacenes;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedidoTest {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Almacen almacen = new AlmacenImpl();

	protected void setUp() throws Exception {
		almacen.ingresar(TALISKER, 50);
		almacen.ingresar(HIGHLAND_PARK, 25);
	}
	@Test
	public void testPedidoSeRellenaSiHaySuficienteEnElAlmacen() throws Exception {
		Pedido pedido = new Pedido(TALISKER, 50);
		pedido.fill(almacen);
		assertTrue(pedido.getEstaRelleno());
		assertEquals(0, almacen.getInventory(TALISKER));
	}
	@Test
	public void testPedidoNoQuitaCantidadSiNoHaySuficienteEnAlmacen() throws Exception {
		Pedido pedido = new Pedido(TALISKER, 51);
		pedido.fill(almacen);
		assertFalse(pedido.getEstaRelleno());
		assertEquals(50, almacen.getInventory(TALISKER));
	}

}
