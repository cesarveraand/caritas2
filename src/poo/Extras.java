package poo;

import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;

public class Extras {
	public static String fecha(LocalDate fec) {
		String aux=fec.toString();
		String[] auxfecha=aux.split("-");
		aux=auxfecha[2]+"/"+auxfecha[1]+"/"+auxfecha[0];
		return aux;
	}


public static LocalDate fechas(String  d) {
	String [] fecha = d.split("/");
return LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]));
}

}
