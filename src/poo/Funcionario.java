package poo;
import java.sql.SQLException;
import java.time.LocalDate;
import Conexion.*;
public class Funcionario {
	private int cod;
	private String nombre,ci,correo,telefono,ciudad,direccion,contra;
	private LocalDate fechaNac, fechaCon;
	private boolean empleado,admin;
	
	public Funcionario( String nombre, String ci, String correo, String telefono, String ciudad,
			String direccion, String contra, LocalDate fechaNac, LocalDate fechaCon,
			boolean empleado, boolean admin) {
		try {
			this.cod = Conexion.ultimoFuncionario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nombre = nombre;
		this.ci = ci;
		this.correo = correo;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.contra = contra;
		this.fechaNac = fechaNac;
		this.fechaCon = fechaCon;
		this.empleado = empleado;
		this.admin = admin;
	}
	
	public Funcionario(int cod, String nombre, String ci, String correo, String telefono, String ciudad,
			String direccion, String contra, LocalDate fechaNac, LocalDate fechaCon,
			boolean empleado, boolean admin) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.ci = ci;
		this.correo = correo;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.contra = contra;
		this.fechaNac = fechaNac;
		this.fechaCon = fechaCon;
		this.empleado = empleado;
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Funcionario [cod=" + cod + ", nombre=" + nombre + ", ci=" + ci + ", correo=" + correo + ", telefono="
				+ telefono + ", ciudad=" + ciudad + ", direccion=" + direccion + ", contra=" + contra + ", fechaNac="
				+ fechaNac + ", LocalDate=" + fechaCon + ", empleado=" + empleado + ", admin=" + admin + "]";
	}


	public LocalDate getLFechaCon() {
		return fechaCon;
	}


	public void setFechaCon(LocalDate fechaCon) {
		this.fechaCon = fechaCon;
	}


	public boolean isEmpleado() {
		return empleado;
	}


	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}
