package ar.edu.unlam.cuentas;

import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.personas.Titular;

public class CajaDeAhorro extends Cuenta {

	private Double COMISIONPOREXTRACCION = 100.0;
	private int contadorExtracciones = 1;

	public CajaDeAhorro(Titular titular, Integer numDeCuenta, Integer cbu, Double saldo, TipoOperacion tipoOperacion) {
		super(titular, numDeCuenta, cbu, saldo, tipoOperacion);

	}

	public Double getCOMISIONPOREXTRACCION() {
		return COMISIONPOREXTRACCION;
	}

	public void setCOMISIONPOREXTRACCION(Double cOMISIONPOREXTRACCION) {
		COMISIONPOREXTRACCION = cOMISIONPOREXTRACCION;
	}

	@Override
	public Boolean extraer(Double importe) {
		Boolean extraccionExitosa = false;

		if (getSaldo() >= importe) {
			Double nuevoSaldo = getSaldo() - importe;
			setSaldo(nuevoSaldo);
			extraccionExitosa = true;
			this.contadorExtracciones++;
			caclcularComision();
		}

		return extraccionExitosa;
	}

	private void caclcularComision() {
		if (contadorExtracciones % 6 == 0) {
			Double nuevoSaldo = getSaldo() - COMISIONPOREXTRACCION;
			setSaldo(nuevoSaldo);
		}

	}

}
