package ar.edu.unlam.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.cuentas.CajaDeAhorro;
import ar.edu.unlam.cuentas.Cuenta;
import ar.edu.unlam.cuentas.CuentaCorriente;
import ar.edu.unlam.cuentas.CuentaSueldo;
import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.enums.TipoPersoneria;
import ar.edu.unlam.cuentas.personas.Titular;

public class PruebaCuentasBancariasTest {

	@Test // #1

	public void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 2000.0;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;

		CuentaSueldo cuentaSueldo = new CuentaSueldo(titular, numDeCuenta, cbu, saldo, tipoOperacion);

		// PROCESO
		Double importe = 1000.0;
		assertTrue(cuentaSueldo.extraer(importe));
		// SALIDA
		Double ve = 1000.0;
		double vo = cuentaSueldo.getSaldo();
		assertEquals(ve, vo, 0.1);
	}

	@Test // #2
	public void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 2000.0;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;

		CuentaSueldo cuentaSueldo = new CuentaSueldo(titular, numDeCuenta, cbu, saldo, tipoOperacion);

		// PROCESO
		Double importe = 2500.0;
		assertFalse(cuentaSueldo.extraer(importe));
		// SALIDA
		Double ve = 2000.0;
		Double vo = cuentaSueldo.getSaldo();
		assertEquals(ve, vo, 0.1);
	}

	@Test // #3
	public void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 5000.0;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;

		CuentaSueldo cuentaSueldo = new CuentaSueldo(titular, numDeCuenta, cbu, saldo, tipoOperacion);

		// PROCESO
		Double importe = 1000.0;
		Integer cantidadExtracciones = 0;

		do {
			cuentaSueldo.extraer(importe);
			cantidadExtracciones++;
		} while (cantidadExtracciones < 5);

		// SALIDA
		Double ve = 0.0;
		Double vo = cuentaSueldo.getSaldo();
		assertEquals(ve, vo, 0.1);

	}

	@Test // #4
	public void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900 () {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 10000.0;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;
		
		
		Cuenta cajadeAhorro = new CajaDeAhorro(titular, numDeCuenta, cbu, saldo, tipoOperacion);

		// PROCESO
		Double importe = 1000.0;
		Integer contadorExtracciones = 0;
		Integer cantidadDeseadaExtracciones=6;

		do {
			cajadeAhorro.extraer(importe);
			contadorExtracciones++;
		} while (contadorExtracciones < cantidadDeseadaExtracciones);

		// SALIDA
		Double ve = 3900.0;
		Double vo = cajadeAhorro.getSaldo();
		assertEquals(ve, vo, 0.1);

	}
	@Test // #5
	public void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000  () {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 0.0;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;		
		
		Double descubierto=3000.0;
		Double comisionPorDescubierto=0.05;
		Cuenta cuentCorriente = new CuentaCorriente(titular, numDeCuenta, cbu, saldo,descubierto,comisionPorDescubierto, tipoOperacion);		

		// PROCESO
		Double importe = 1000.0;
		
		assertTrue(cuentCorriente.depositar(importe));		

		// SALIDA
		Double ve = 1000.0;
		Double vo = cuentCorriente.getSaldo();
		assertEquals(ve, vo, 0.1);

	}
	@Test // #6
	public void queSeCobre5PorCientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldoEnUnaCuentaCorriente  () {
		// ENTRADA
		String nombre = "Pedro", apellido = "Sanchez";
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular = new Titular(nombre, apellido, dni, tipoPersoneria);
		Integer numDeCuenta = 990001, cbu = 400000440;
		Double saldo = 0.0;
		Double descubierto=2000.0;
		Double comisionPorDescubierto=0.05;
		TipoOperacion tipoOperacion = TipoOperacion.EXTRACCION;		
		
		Cuenta cuentCorriente = new CuentaCorriente(titular, numDeCuenta, cbu, saldo,descubierto,comisionPorDescubierto, tipoOperacion);		

		// PROCESO
		Double importe = 1000.0;
		Double importeDeposito=2000.0;
		
		assertTrue(cuentCorriente.extraer(importe));
		assertTrue(cuentCorriente.depositar(importeDeposito));

		// SALIDA
		Double ve = 950.0;
		Double vo = cuentCorriente.getSaldo();
		assertEquals(ve, vo, 0.1);

	}



}
