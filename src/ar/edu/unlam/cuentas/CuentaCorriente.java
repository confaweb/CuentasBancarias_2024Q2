package ar.edu.unlam.cuentas;

import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.personas.Titular;

public class CuentaCorriente extends Cuenta {

	private Double comisionesPendientes=0.0;
	private Double descubierto;
	private Double comisionPorDescubierto;

	public CuentaCorriente(Titular titular, Integer numDeCuenta, Integer cbu, Double saldo, Double descubierto,
			Double comisionPorDescubierto, TipoOperacion tipoOperacion) {
		super(titular, numDeCuenta, cbu, saldo, tipoOperacion);
		this.descubierto = descubierto;
		this.comisionPorDescubierto = comisionPorDescubierto;
	}

	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}

	public Double getComisionPorDescubierto() {
		return comisionPorDescubierto;
	}

	public void setComisionPorDescubierto(Double comisionPorDescubierto) {
		this.comisionPorDescubierto = comisionPorDescubierto;
	}

	public Double getComisionesPendientes() {
		return comisionesPendientes;
	}

	public void setComisionesPendientes(Double comisionesPendientes) {
		this.comisionesPendientes = comisionesPendientes;
	}

	@Override
	public Boolean extraer(Double importe) {
		Boolean extraccionExitosa = false;
		Double nuevoSaldo = super.getSaldo() - importe;
		super.setSaldo(nuevoSaldo);
		if (super.getSaldo() < 0) {
			calcularComision();
			extraccionExitosa=true;
		}

		return extraccionExitosa;
	}

	@Override
	public Boolean depositar(Double importe) {
		Boolean depositoExitoso = false;
		if (importe > 0) {			
			super.setSaldo(super.getSaldo() + importe);
			depositoExitoso = true;
			cobrarComisionesPendientes();
			
		}

		return depositoExitoso;
	}

	private Boolean cobrarComisionesPendientes() {
		Boolean comisionesCobradas = false;
		if (super.getSaldo() > 0) {
			Double nuevoSaldo = super.getSaldo() - this.getComisionesPendientes();
			super.setSaldo(nuevoSaldo);
			comisionesCobradas = true;
		}
		return comisionesCobradas;

	}

	private void calcularComision() {
		
		if (super.getSaldo() < 0) {
			Double comision = (-1) * super.getSaldo() * 100 * this.comisionPorDescubierto;
			this.comisionesPendientes += comision;
		} 
			setComisionesPendientes (0.0);

		
		

	}

}
