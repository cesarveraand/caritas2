package poo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Beneficiarios {
	private int codBen;
	private String nombre;
	private int edad;
	private String sexo;
	private String ci;
	private LocalDate fechaExpedido;
	private boolean ingreso;//0-regular/1-irregular
	private String educacion;
	private ArrayList<PaisVisita> pais;
	private boolean estado;
	public Beneficiarios(int codBen, String nombre, int edad, String sexo, String ci, LocalDate fechaExpedido,
			boolean ingreso, String educacion, ArrayList<PaisVisita> pais,boolean estado) {
		this.codBen = codBen;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.ci = ci;
		this.fechaExpedido = fechaExpedido;
		this.ingreso = ingreso;
		this.educacion = educacion;
		this.pais=pais;
		this.estado=estado;
	}
	public Beneficiarios( String nombre, int edad, String sexo, String ci, LocalDate fechaExpedido,
			boolean ingreso, String educacion, ArrayList<PaisVisita> pais,boolean estado) {
		try {
			this.codBen = Conexion.ultimoBeneficiario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.ci = ci;
		this.fechaExpedido = fechaExpedido;
		this.ingreso = ingreso;
		this.educacion = educacion;
		this.pais=pais;
		this.estado=estado;

	}
	public boolean isPais() {
		return pais==null;
	}
	public ArrayList<PaisVisita> getPais() {
		return pais;
	}

	public void setPais(ArrayList<PaisVisita> pais) {
		this.pais = pais;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getCodBen() {
		return codBen;
	}
	public void setCodBen(int codBen) {
		this.codBen = codBen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public LocalDate getFechaExpedido() {
		return fechaExpedido;
	}
	public void setFechaExpedido(LocalDate fechaExpedido) {
		this.fechaExpedido = fechaExpedido;
	}
	public boolean isIngreso() {
		return ingreso;
	}
	public void setIngreso(boolean ingreso) {
		this.ingreso = ingreso;
	}
	public String getEducacion() {
		return educacion;
	}
	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}
	@Override
	public String toString() {
		return "Beneficiarios [codBen=" + codBen + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", ci="
				+ ci + ", fechaExpedido=" + fechaExpedido + ", ingreso=" + ingreso + ", educacion=" + educacion
				+ ", pais=" + pais.toString() + "]";
	}
	
}
