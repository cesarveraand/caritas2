package poo;

import java.sql.SQLException;
import Conexion.*;
public class PaisVisita {
	private int cpo;
	private String pais;
	private int tiempoDias;
	private String estadoMigratorioString;
	private boolean estado;
	public PaisVisita(int cpo, String pais, int tiempoDias, String estadoMigratorioString,boolean estado) {
		this.cpo = cpo;
		this.pais = pais;
		this.tiempoDias = tiempoDias;
		this.estadoMigratorioString = estadoMigratorioString;
		this.estado=estado;

	}
	public PaisVisita( String pais, int tiempoDias, String estadoMigratorioString,boolean estado) {
		try {
			this.cpo = Conexion.ultimoPaisVisita();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pais = pais;
		this.tiempoDias = tiempoDias;
		this.estadoMigratorioString = estadoMigratorioString;
		this.estado=estado;

	}
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getCpo() {
		return cpo;
	}
	public void setCpo(int cpo) {
		this.cpo = cpo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getTiempoDias() {
		return tiempoDias;
	}
	public void setTiempoDias(int tiempoDias) {
		this.tiempoDias = tiempoDias;
	}
	public String getEstadoMigratorioString() {
		return estadoMigratorioString;
	}
	public void setEstadoMigratorioString(String estadoMigratorioString) {
		this.estadoMigratorioString = estadoMigratorioString;
	}
	@Override
	public String toString() {
		return "PaisVisita [cpo=" + cpo + ", pais=" + pais + ", tiempoDias=" + tiempoDias + ", estadoMigratorioString="
				+ estadoMigratorioString + "]";
	}
	
}
