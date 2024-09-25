package ar.edu.unlam.cuentas.personas;

import ar.edu.unlam.cuentas.Persona;
import ar.edu.unlam.cuentas.enums.TipoPersoneria;

public class Titular extends Persona {

	

	private TipoPersoneria tipoPersoneria;

	public Titular(String nombre, String apellido, Integer dni, TipoPersoneria tipoPersoneria) {
		super(nombre,apellido,dni);
		
		this.setTipoPersoneria(tipoPersoneria);
	}

	/**
	 * @return the tipoPersoneria
	 */
	public TipoPersoneria getTipoPersoneria() {
		return tipoPersoneria;
	}

	/**
	 * @param tipoPersoneria the tipoPersoneria to set
	 */
	public void setTipoPersoneria(TipoPersoneria tipoPersoneria) {
		this.tipoPersoneria = tipoPersoneria;
	}

	

}
