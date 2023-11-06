package poo;

import java.sql.SQLException;

public class PaisVisita {
	private int cpo;
	private String pais;
	private int tiempoDias;
	private String estadoMigratorioString;
	public PaisVisita(int cpo, String pais, int tiempoDias, String estadoMigratorioString) {
		this.cpo = cpo;
		this.pais = pais;
		this.tiempoDias = tiempoDias;
		this.estadoMigratorioString = estadoMigratorioString;
	}
	public PaisVisita( String pais, int tiempoDias, String estadoMigratorioString) {
		try {
			this.cpo = Conexion.ultimoPaisVisita();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pais = pais;
		this.tiempoDias = tiempoDias;
		this.estadoMigratorioString = estadoMigratorioString;
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
