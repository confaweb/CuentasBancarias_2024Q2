package ar.edu.unlam.cuentas;

import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.personas.Titular;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Titular titular, Integer numDeCuenta, Integer cbu, Double saldo, TipoOperacion tipoOperacion) {
		super(titular, numDeCuenta, cbu, saldo, tipoOperacion);
		
	}

	
	

}
