package almacenes;
import almacenes.AlmacenImpl;

import static org.junit.Assert.*;

import org.junit.Test;



public class PedidoMockTest extends MockObjectTestCase{

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	 private Almacen almacen = new AlmacenImpl();

	
	//private Almacen almacen = Mockito.mock(Almacen.class);

	
	
	@Test
	public void testPedidoSeRellenaSiHaySuficienteEnElAlmacen() throws Exception {
		Pedido pedido = new Pedido(TALISKER, 50);
		Mock almacenMock = new Mock(Almacen.class);

		 //setup - expectations
		 almacenMock.expects(once()).method("tieneInventario")
		 .with(eq(TALISKER),eq(50))
		 .will(returnValue(true));
		 almacenMock.expects(once()).method("quitar")
		 .with(eq(TALISKER), eq(50))
		 .after("hasInventory");
		 
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
