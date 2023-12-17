package Ventanas;

public class Voluntariod {
	 private String nombre;
	    private String CI;
	    private String pais;
	    private int numeroHojaRuta;

	    public Voluntariod(String nombre, String CI, String pais, int numeroHojaRuta) {
	        this.nombre = nombre;
	        this.CI = CI;
	        this.pais = pais;
	        this.numeroHojaRuta = numeroHojaRuta;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCI() {
	        return CI;
	    }

	    public String getPais() {
	        return pais;
	    }

	    public int getNumeroHojaRuta() {
	        return numeroHojaRuta;
	    }
	}