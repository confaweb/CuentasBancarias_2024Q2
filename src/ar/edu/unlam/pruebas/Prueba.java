package ar.edu.unlam.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.cuentas.CajaDeAhorro;
import ar.edu.unlam.cuentas.Cuenta;
import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.enums.TipoPersoneria;
import ar.edu.unlam.cuentas.personas.Titular;

public class Prueba {

	@Test
	public void SePuedaRealizarUnDepositoEnUnaCajaDeAhorros() {
		//ENTRADA
		String nombre = "Pedro",apellido = "Sanchez";		 
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular= new Titular(nombre,apellido,dni,tipoPersoneria);
		Integer numDeCuenta = 990001,cbu = 400000440;		
		Double  saldo = 100.0;
		TipoOperacion tipoOperacion = TipoOperacion.DEPOSITO;
		 
		Cuenta cuenta= new Cuenta(titular,numDeCuenta,cbu,saldo,tipoOperacion);
		CajaDeAhorro cajaDeAhorro= new CajaDeAhorro(titular,numDeCuenta,cbu,saldo,tipoOperacion);
		Double importe=10.0;
		//PROCESO
		cajaDeAhorro.depositar(importe);
		//SALIDA
		Double ve=110.0;
		double vo=cajaDeAhorro.getSaldo();
		assertEquals(ve,vo,0.1);
	}
	@Test
	public void SePuedaRealizarUnaExtraccionEnUnaCajaDeAhorros() {
		//ENTRADA
		String nombre = "Pedro",apellido = "Sanchez";		 
		Integer dni = 111111;
		TipoPersoneria tipoPersoneria = TipoPersoneria.FISICA;
		Titular titular= new Titular(nombre,apellido,dni,tipoPersoneria);
		Integer numDeCuenta = 990001,cbu = 400000440;		
		Double  saldo = 100.0;
		TipoOperacion tipoOperacion = TipoOperacion.DEPOSITO;
		 
		CajaDeAhorro cajaDeAhorro= new CajaDeAhorro(titular,numDeCuenta,cbu,saldo,tipoOperacion);
		Double importe=10.0;
		//PROCESO
		cajaDeAhorro.extraer(importe);
		//SALIDA
		Double ve=90.0;
		double vo=cajaDeAhorro.getSaldo();
		assertEquals(ve,vo,0.1);
	}

}
