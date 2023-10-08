package curso.g10.junit0;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CreditoTest {


	Cuenta cuenta;
	Credito tarjeta;

	
	@BeforeEach
	public void setUp() throws Exception {
		cuenta = new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
		cuenta.ingresar(1000.0);
		Date hoy = new Date();
		long tiempo = Long.parseLong("12096000000");
		Date fecha = new Date(hoy.getTime() + tiempo); // Caduca en 4 a�os
		tarjeta = new Credito("1234567890123456", "Fulano de Tal", fecha, 1000.0); // 1000
																					// �
																					// de
																					// cr�dito
		tarjeta.setCuenta(cuenta);
	}

	
	@Test
	@DisplayName("Prueba de retirar 200 cuando en la cuenta solo hay 100")
	public void testRetirar200ConSaldo100() {
		
	}
	
	@Test
	public void testIngresar500() {
		try {
			double saldoAnteriorCuenta = cuenta.getSaldo();
			double saldoAnteriorTarjeta = tarjeta.getSaldo();
			double creditoAnterior = tarjeta.getCreditoDisponible();
			System.out.println(saldoAnteriorCuenta+"/"+saldoAnteriorTarjeta+"/"+creditoAnterior);
			System.out.println(tarjeta.getSaldo());
			tarjeta.ingresar(500.0);
			assertTrue(cuenta.getSaldo() == saldoAnteriorCuenta + 500);
			assertTrue(tarjeta.getSaldo() == saldoAnteriorTarjeta + 500);
			assertTrue(tarjeta.getCreditoDisponible() == creditoAnterior);
		} catch (Exception e) {
		}
	}
	@Test
	public void testRetirar300() {
		try {
			double saldoAnteriorCuenta = cuenta.getSaldo();
			double saldoAnteriorTarjeta = tarjeta.getSaldo();
			double creditoAnterior = tarjeta.getCreditoDisponible();
			tarjeta.retirar(300.0);
			assertTrue(cuenta.getSaldo() == saldoAnteriorCuenta);
			assertTrue(tarjeta.getSaldo() == saldoAnteriorTarjeta - 15);
			assertTrue(tarjeta.getCreditoDisponible() == creditoAnterior - 300);
		} catch (Exception e) {
		}
	}
	@Test
	public void testLiquidar() {
		try {
			double saldoAnteriorCuenta = cuenta.getSaldo();
			tarjeta.pagoEnEstablecimiento("Zara", 120.0);
			tarjeta.pagoEnEstablecimiento("El Corte Ingl�s", 230.0);
			tarjeta.liquidar(11, 2003);
			assertTrue(saldoAnteriorCuenta == cuenta.getSaldo() - 350.0);
		} catch (Exception e) {
		}
	}

	

}
