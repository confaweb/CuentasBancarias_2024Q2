package ar.edu.unlam.cuentas;

import java.util.Objects;

import ar.edu.unlam.cuentas.enums.TipoOperacion;
import ar.edu.unlam.cuentas.personas.Titular;

public class Cuenta {

	private Titular titular;
	private Integer numDeCuenta;
	private Integer cbu;
	private Double saldo;
	private TipoOperacion tipoOperacion;

	public Cuenta(Titular titular, Integer numDeCuenta, Integer cbu, Double saldo, TipoOperacion tipoOperacion) {
		this.setTitular(titular);
		this.numDeCuenta = numDeCuenta;
		this.cbu = cbu;
		this.saldo = saldo;
		this.tipoOperacion = tipoOperacion;
	}

	public Integer getNumDeCuenta() {
		return numDeCuenta;
	}

	public void setNumDeCuenta(Integer numDeCuenta) {
		this.numDeCuenta = numDeCuenta;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	public Boolean  depositar(Double importe) {
		Boolean depositoExisoto=false;
		if (importe>0) {
			this.saldo+=importe;
			depositoExisoto=true;
		}		
		return depositoExisoto;
	}
	
	public  Boolean extraer(Double importe) {
		Boolean extraccionExitosa=false;		
		if(this.saldo>=importe) {
		this.saldo-= importe;		
		extraccionExitosa=true;
		}
		return extraccionExitosa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cbu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(cbu, other.cbu);
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", numDeCuenta=" + numDeCuenta + ", cbu=" + cbu + ", saldo=" + saldo
				+ ", tipoOperacion=" + tipoOperacion + "]";
	}

	

}
