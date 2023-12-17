package src.poo;

import java.time.LocalDate;

public class HojaRutaAcciones {
	private int cpmh;
	private String accionRealizada,derivado,instruccion,observaciones;
	private LocalDate fechaAccion;
	private Hoja_de_ruta hjr;
	private boolean estado;
	public HojaRutaAcciones(int cpmh, String accionRealizada, String derivado, String instruccion, String observaciones,
			LocalDate fechaAccion,Hoja_de_ruta hjr,boolean estado) {
		this.cpmh = cpmh;
		this.accionRealizada = accionRealizada;
		this.derivado = derivado;
		this.instruccion = instruccion;
		this.observaciones = observaciones;
		this.fechaAccion = fechaAccion;
		this.hjr=hjr;
		this.estado=estado;

	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Hoja_de_ruta getHjr() {
		return hjr;
	}
	public void setHjr(Hoja_de_ruta hjr) {
		this.hjr = hjr;
	}
	public int getCpmh() {
		return cpmh;
	}
	public void setCpmh(int cpmh) {
		this.cpmh = cpmh;
	}
	public String getAccionRealizada() {
		return accionRealizada;
	}
	public void setAccionRealizada(String accionRealizada) {
		this.accionRealizada = accionRealizada;
	}
	public String getDerivado() {
		return derivado;
	}
	public void setDerivado(String derivado) {
		this.derivado = derivado;
	}
	public String getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public LocalDate getFechaAccion() {
		return fechaAccion;
	}
	public void setFechaAccion(LocalDate fechaAccion) {
		this.fechaAccion = fechaAccion;
	}
	@Override
	public String toString() {
		return "HojaRutaAcciones [cpmh=" + cpmh + ", accionRealizada=" + accionRealizada + ", derivado=" + derivado
				+ ", instruccion=" + instruccion + ", observaciones=" + observaciones + ", fechaAccion=" + fechaAccion
				+ "]";
	}
	
	
}
