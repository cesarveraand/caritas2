package poo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormlarioRegistro {
	private int cfr;
	private String lugar;
	private LocalDate fechaRegistro;
	private String telefono;
	private String paisOrigen;
	private LocalDate fechaSalida;
	private boolean transporte;//0-aereo/1-tierra
	private String razon;
	private LocalDate fechaIngreso;
	private String fronteraIngreso;
	private String documentoIngreso;
	private String diasPermanencia;
	private boolean destinoFinal;//0-no/1-si
	private String paisSiguiente;
	private String porquePais;
	private String alojamiento;
	private boolean enviaDinero;//0-no/1-si
	private boolean sustento;//0-formal / 1-informal
	private boolean leEnviaDienro;//0-no/1-si
	private String medioEvniaDinero;
	private String comunicaFamilia;
	private String obs;
	private boolean transito,refugio,atencion;
	private Familias fam;
	private boolean estado;
	public FormlarioRegistro(int cfr, String lugar,LocalDate fechaRegistro, String telefono, String paisOrigen,
			LocalDate fechaSalida, boolean transporte, String razon, LocalDate fechaIngreso, String fronteraIngreso,
			String documentoIngreso, int diasPermanencia, boolean destinoFinal, String paisSiguiente, String porquePais,
			String alojamiento,boolean enviaDinero, boolean sustento, boolean leEnviaDienro, String medioEvniaDinero, String comunicaFamilia,
			String obs,boolean transito, boolean refugio, boolean atencion, Familias fam,boolean estado) {
		this.cfr = cfr;
		this.lugar = lugar;
		this.fechaRegistro =fechaRegistro;
		this.telefono = telefono;
		this.paisOrigen = paisOrigen;
		this.fechaSalida = fechaSalida;
		this.transporte = transporte;
		this.razon = razon;
		this.fechaIngreso = fechaIngreso;
		this.fronteraIngreso = fronteraIngreso;
		this.documentoIngreso = documentoIngreso;
		this.diasPermanencia = diasPermanencia+"";
		this.destinoFinal = destinoFinal;
		this.paisSiguiente = paisSiguiente;
		this.porquePais = porquePais;
		this.alojamiento = alojamiento;
		this.enviaDinero= enviaDinero;
		this.sustento = sustento;
		this.leEnviaDienro = leEnviaDienro;
		this.medioEvniaDinero = medioEvniaDinero;
		this.comunicaFamilia = comunicaFamilia;
		this.obs = obs;
		this.transito=transito;
		this.refugio=refugio;
		this.atencion=atencion;
		this.fam=fam;
		this.estado=estado;

	}
	
	public FormlarioRegistro(int cfr, String lugar, String telefono, String paisOrigen,
			LocalDate fechaSalida, boolean transporte, String razon, LocalDate fechaIngreso, String fronteraIngreso,
			String documentoIngreso, String diasPermanencia, boolean destinoFinal, String paisSiguiente, String porquePais,
			String alojamiento,boolean enviaDinero, boolean sustento, boolean leEnviaDienro, String medioEvniaDinero, String comunicaFamilia,
			String obs,boolean transito, boolean refugio, boolean atencion, Familias fam,boolean estado) {
		this.cfr = cfr;
		this.lugar = lugar;
		this.fechaRegistro =LocalDate.now();
		this.telefono = telefono;
		this.paisOrigen = paisOrigen;
		this.fechaSalida = fechaSalida;
		this.transporte = transporte;
		this.razon = razon;
		this.fechaIngreso = fechaIngreso;
		this.fronteraIngreso = fronteraIngreso;
		this.documentoIngreso = documentoIngreso;
		this.diasPermanencia = diasPermanencia;
		this.destinoFinal = destinoFinal;
		this.paisSiguiente = paisSiguiente;
		this.porquePais = porquePais;
		this.alojamiento = alojamiento;
		this.enviaDinero= enviaDinero;
		this.sustento = sustento;
		this.leEnviaDienro = leEnviaDienro;
		this.medioEvniaDinero = medioEvniaDinero;
		this.comunicaFamilia = comunicaFamilia;
		this.obs = obs;
		this.transito=transito;
		this.refugio=refugio;
		this.atencion=atencion;
		this.fam=fam;
		this.estado=estado;

	}
	public FormlarioRegistro( String lugar, String telefono, String paisOrigen,
			LocalDate fechaSalida, boolean transporte, String razon, LocalDate fechaIngreso, String fronteraIngreso,
			String documentoIngreso, String diasPermanencia, boolean destinoFinal, String paisSiguiente, String porquePais,
			String alojamiento,boolean enviaDinero, boolean sustento, boolean leEnviaDienro, String medioEvniaDinero, String comunicaFamilia,
			String obs,boolean transito, boolean refugio, boolean atencion, Familias fam,boolean estado) {
		try {
			this.cfr = Conexion.ultimoFormularioRegistro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.lugar = lugar;
		this.fechaRegistro = LocalDate.now();
		this.telefono = telefono;
		this.paisOrigen = paisOrigen;
		this.fechaSalida = fechaSalida;
		this.transporte = transporte;
		this.razon = razon;
		this.fechaIngreso = fechaIngreso;
		this.fronteraIngreso = fronteraIngreso;
		this.documentoIngreso = documentoIngreso;
		this.diasPermanencia = diasPermanencia;
		this.destinoFinal = destinoFinal;
		this.paisSiguiente = paisSiguiente;
		this.porquePais = porquePais;
		this.alojamiento = alojamiento;
		this.enviaDinero= enviaDinero;
		this.sustento = sustento;
		this.leEnviaDienro = leEnviaDienro;
		this.medioEvniaDinero = medioEvniaDinero;
		this.comunicaFamilia = comunicaFamilia;
		this.obs = obs;
		this.transito=transito;
		this.refugio=refugio;
		this.atencion=atencion;
		this.fam=fam;
		this.estado=estado;

	}
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Familias getFam() {
		return fam;
	}

	public void setFam(Familias fam) {
		this.fam = fam;
	}

	public boolean isTransito() {
		return transito;
	}

	public void setTransito(boolean transito) {
		this.transito = transito;
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

	public int getCfr() {
		return cfr;
	}
	public void setCfr(int cfr) {
		this.cfr = cfr;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public boolean isTransporte() {
		return transporte;
	}
	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFronteraIngreso() {
		return fronteraIngreso;
	}
	public void setFronteraIngreso(String fronteraIngreso) {
		this.fronteraIngreso = fronteraIngreso;
	}
	public String getDocumentoIngreso() {
		return documentoIngreso;
	}
	public void setDocumentoIngreso(String documentoIngreso) {
		this.documentoIngreso = documentoIngreso;
	}
	public String getDiasPermanencia() {
		return diasPermanencia;
	}
	public void setDiasPermanencia(String diasPermanencia) {
		this.diasPermanencia = diasPermanencia;
	}
	public boolean isDestinoFinal() {
		return destinoFinal;
	}
	public void setDestinoFinal(boolean destinoFinal) {
		this.destinoFinal = destinoFinal;
	}
	public String getPaisSiguiente() {
		return paisSiguiente;
	}
	public void setPaisSiguiente(String paisSiguiente) {
		this.paisSiguiente = paisSiguiente;
	}
	public String getPorquePais() {
		return porquePais;
	}
	public void setPorquePais(String porquePais) {
		this.porquePais = porquePais;
	}
	public String getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(String alojamiento) {
		this.alojamiento = alojamiento;
	}
	public boolean getSustento() {
		return sustento;
	}
	public void setSustento(boolean sustento) {
		this.sustento = sustento;
	}
	
	
	public boolean isEnviaDinero() {
		return enviaDinero;
	}
	public void setEnviaDinero(boolean enviaDinero) {
		this.enviaDinero = enviaDinero;
	}
	public boolean isLeEnviaDienro() {
		return leEnviaDienro;
	}
	public void setLeEnviaDienro(boolean leEnviaDienro) {
		this.leEnviaDienro = leEnviaDienro;
	}
	public String getMedioEvniaDinero() {
		return medioEvniaDinero;
	}
	public void setMedioEvniaDinero(String medioEvniaDinero) {
		this.medioEvniaDinero = medioEvniaDinero;
	}
	public String getComunicaFamilia() {
		return comunicaFamilia;
	}
	public void setComunicaFamilia(String comunicaFamilia) {
		this.comunicaFamilia = comunicaFamilia;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "FormlarioRegistro [cfr=" + cfr + ", lugar=" + lugar + ", fechaRegistro=" + fechaRegistro + ", telefono="
				+ telefono + ", paisOrigen=" + paisOrigen + ", fechaSalida=" + fechaSalida + ", transporte="
				+ transporte + ", razon=" + razon + ", fechaIngreso=" + fechaIngreso + ", fronteraIngreso="
				+ fronteraIngreso + ", documentoIngreso=" + documentoIngreso + ", diasPermanencia=" + diasPermanencia
				+ ", destinoFinal=" + destinoFinal + ", paisSiguiente=" + paisSiguiente + ", porquePais=" + porquePais
				+ ", alojamiento=" + alojamiento + ", enviaDinero=" + enviaDinero + ", sustento=" + sustento
				+ ", leEnviaDienro=" + leEnviaDienro + ", medioEvniaDinero=" + medioEvniaDinero + ", comunicaFamilia="
				+ comunicaFamilia + ", obs=" + obs + ", transito=" + transito + ", refugio=" + refugio + ", atencion="
				+ atencion + ", fam=" + fam.toString() + "]";
	}
	
	
}
