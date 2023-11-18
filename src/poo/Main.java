package poo;

import java.sql.SQLException;

public class Main {
	private static Funcionario fun=null;
	private static FormlarioRegistro ultimoForm=null;
	private static Hoja_de_ruta hojar=null;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		InicioSesion inicioSecion = new InicioSesion();
		inicioSecion.setVisible(true);
	}
	public static int getCod() {
		return fun.getCod();
	}
	public static boolean isAdmin() {
		return fun.isAdmin();
	}
	public static String nombre() {
		return fun.getNombre(); 
	}
	public static FormlarioRegistro getUltimoForm() {
		return ultimoForm;
	}
	public static void setUltimoForm(FormlarioRegistro f) {
		ultimoForm=f;
	}
	public static Hoja_de_ruta getUltimaHojar() {
		return hojar;
	}
	public static void setUltimaHojar(Hoja_de_ruta f) {
		hojar=f;
	}
	public static void ingresar(String ci, String contra) {
		try {
			fun=Conexion.ingresarFun(ci,contra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}