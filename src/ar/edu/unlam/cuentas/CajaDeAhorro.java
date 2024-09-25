package ar.edu.unlam.cuentas;

import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.personas.Titular;

public class CajaDeAhorro extends Cuenta {

	public CajaDeAhorro(Titular titular, Integer numDeCuenta, Integer cbu, Double saldo, TipoOperacion tipoOperacion) {
		super(titular, numDeCuenta, cbu, saldo, tipoOperacion);
		
	}

	
	

}
