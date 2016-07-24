package curso.g801.Factory;

public class FactoriaFacturas {

	public static Factura getFactura(String tipo) {

		if (tipo.equals("iva")) {

			return new FacturaIva();
		} else {
			return new FacturaIvaReducido();
		}

	}
}
