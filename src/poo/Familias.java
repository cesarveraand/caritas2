package poo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Familias {
	private int codFamilia;
	private int cantidad;
	private Beneficiarios prin;
	private ArrayList<Beneficiarios> familia;
	public Familias(int codFamilia,int cantidad, Beneficiarios prin, ArrayList<Beneficiarios> familia) {
		this.codFamilia=codFamilia;
		this.cantidad = cantidad;
		this.prin = prin;
		this.familia = familia;
	}
	public Familias(int cantidad, Beneficiarios prin, ArrayList<Beneficiarios> familia) {
		try {
			this.codFamilia=Conexion.ultimaFamilia();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cantidad = cantidad;
		this.prin = prin;
		this.familia = familia;
	}
	public int getCodFamilia() {
		return codFamilia;
	}

	public void setCodFamilia(int codFamilia) {
		this.codFamilia = codFamilia;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Beneficiarios getPrin() {
		return prin;
	}
	public void setPrin(Beneficiarios prin) {
		this.prin = prin;
	}
	public ArrayList<Beneficiarios> getFamilia() {
		return familia;
	}
	public void setFamilia(ArrayList<Beneficiarios> familia) {
		this.familia = familia;
	}
	@Override
	public String toString() {
		return "Familias [codFamilia=" + codFamilia + ", cantidad=" + cantidad + ", prin=" + prin + ", familia="
				+ familia.toString() + "]";
	}
	
}
