package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hoja_de_ruta {
	private int cfhd;
	private String numero;
	private LocalDate fechaReg;
	private int cantPer ;
	private String obs;
	private FormlarioRegistro form;
	private boolean legal,refugio,atencion,accionAlbergue,accionSerMedico,accionAlimentacion,accionAyudaHum,accionPasajes, accionCondonacion ;
	private String asignacion;
	private LocalDate fechaAsig;
	public Hoja_de_ruta(int cfhd, String numero, LocalDate fechaReg, int cantPer, String obs, boolean legal,
			boolean refugio, boolean atencion, boolean accionAlbergue, boolean accionSerMedico,
			boolean accionAlimentacion, boolean accionAyudaHum, boolean accionPasajes, boolean accionCondonacion,
			String asignacion, LocalDate fechaAsig, FormlarioRegistro form) {
		this.cfhd = cfhd;
		this.numero = numero;
		this.fechaReg = fechaReg;
		this.cantPer = cantPer;
		this.obs = obs;
		this.legal = legal;
		this.refugio = refugio;
		this.atencion = atencion;
		this.accionAlbergue = accionAlbergue;
		this.accionSerMedico = accionSerMedico;
		this.accionAlimentacion = accionAlimentacion;
		this.accionAyudaHum = accionAyudaHum;
		this.accionPasajes = accionPasajes;
		this.accionCondonacion = accionCondonacion;
		this.asignacion = asignacion;
		this.fechaAsig =fechaAsig;
		this.form=form;
	}
	
	public Hoja_de_ruta(int cfhd, String numero, int cantPer, String obs, boolean legal,
			boolean refugio, boolean atencion, boolean accionAlbergue, boolean accionSerMedico,
			boolean accionAlimentacion, boolean accionAyudaHum, boolean accionPasajes, boolean accionCondonacion,
			String asignacion, LocalDate fechaAsig, FormlarioRegistro form) {
		this.cfhd = cfhd;
		this.numero = numero;
		this.fechaReg = LocalDate.now();
		this.cantPer = cantPer;
		this.obs = obs;
		this.legal = legal;
		this.refugio = refugio;
		this.atencion = atencion;
		this.accionAlbergue = accionAlbergue;
		this.accionSerMedico = accionSerMedico;
		this.accionAlimentacion = accionAlimentacion;
		this.accionAyudaHum = accionAyudaHum;
		this.accionPasajes = accionPasajes;
		this.accionCondonacion = accionCondonacion;
		this.asignacion = asignacion;
		this.fechaAsig=fechaAsig;
		this.form=form;

	}
	public Hoja_de_ruta(int cfhd, String numero, int cantPer, String obs, boolean legal,
			boolean refugio, boolean atencion, boolean accionAlbergue, boolean accionSerMedico,
			boolean accionAlimentacion, boolean accionAyudaHum, boolean accionPasajes, boolean accionCondonacion, FormlarioRegistro form) {
		this.cfhd = cfhd;
		this.numero = numero;
		this.fechaReg = LocalDate.now();
		this.cantPer = cantPer;
		this.obs = obs;
		this.legal = legal;
		this.refugio = refugio;
		this.atencion = atencion;
		this.accionAlbergue = accionAlbergue;
		this.accionSerMedico = accionSerMedico;
		this.accionAlimentacion = accionAlimentacion;
		this.accionAyudaHum = accionAyudaHum;
		this.accionPasajes = accionPasajes;
		this.accionCondonacion = accionCondonacion;
		this.asignacion = "";
		this.fechaAsig=null;
		this.form=form;

	}

	
	

	public String getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}
	public LocalDate getFechaAsig() {
		return fechaAsig;
	}
	public void setFechaAsig(LocalDate fechaAsig) {
		this.fechaAsig = fechaAsig;
	}
	public FormlarioRegistro getForm() {
		return form;
	}
	public void setForm(FormlarioRegistro form) {
		this.form = form;
	}
	public int getCfhd() {
		return cfhd;
	}
	public void setCfhd(int cfhd) {
		this.cfhd = cfhd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	public int getCantPer() {
		return cantPer;
	}
	public void setCantPer(int cantPer) {
		this.cantPer = cantPer;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public boolean isLegal() {
		return legal;
	}
	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	public boolean isRefugio() {
		return refugio;
	}
	public void setRefugio(boolean refugio) {
		this.refugio = refugio;
	}
	public boolean isAtencion() {
		return atencion;
	}
	public void setAtencion(boolean atencion) {
		this.atencion = atencion;
	}
	public boolean isAccionAlbergue() {
		return accionAlbergue;
	}
	public void setAccionAlbergue(boolean accionAlbergue) {
		this.accionAlbergue = accionAlbergue;
	}
	public boolean isAccionSerMedico() {
		return accionSerMedico;
	}
	public void setAccionSerMedico(boolean accionSerMedico) {
		this.accionSerMedico = accionSerMedico;
	}
	public boolean isAccionAlimentacion() {
		return accionAlimentacion;
	}
	public void setAccionAlimentacion(boolean accionAlimentacion) {
		this.accionAlimentacion = accionAlimentacion;
	}
	public boolean isAccionAyudaHum() {
		return accionAyudaHum;
	}
	public void setAccionAyudaHum(boolean accionAyudaHum) {
		this.accionAyudaHum = accionAyudaHum;
	}
	public boolean isAccionPasajes() {
		return accionPasajes;
	}
	public void setAccionPasajes(boolean accionPasajes) {
		this.accionPasajes = accionPasajes;
	}
	public boolean isAccionCondonacion() {
		return accionCondonacion;
	}
	public void setAccionCondonacion(boolean accionCondonacion) {
		this.accionCondonacion = accionCondonacion;
	}
	@Override
	public String toString() {
		return "Hoja_de_ruta [cfhd=" + cfhd + ", numero=" + numero + ", fechaReg=" + fechaReg + ", cantPer=" + cantPer
				+ ", obs=" + obs + ", form=" + form + ", legal=" + legal + ", refugio=" + refugio + ", atencion="
				+ atencion + ", accionAlbergue=" + accionAlbergue + ", accionSerMedico=" + accionSerMedico
				+ ", accionAlimentacion=" + accionAlimentacion + ", accionAyudaHum=" + accionAyudaHum
				+ ", accionPasajes=" + accionPasajes + ", accionCondonacion=" + accionCondonacion + ", asignacion="
				+ asignacion + ", fechaAsig=" + fechaAsig + "]";
	}
	
}
