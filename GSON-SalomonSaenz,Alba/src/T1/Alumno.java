package T1;

import java.util.ArrayList;

public class Alumno {
	
	private String nombre, dni;
	private int notaMedia;
	private ArrayList<String> listaCiclos;
	public Alumno() {
		super();
	}
	public Alumno(String nombre, String dni, int notaMedia, ArrayList<String> listaCiclos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.notaMedia = notaMedia;
		this.listaCiclos = listaCiclos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(int notaMedia) {
		this.notaMedia = notaMedia;
	}
	public ArrayList<String> getListaCiclos() {
		return listaCiclos;
	}
	public void setListaCiclos(ArrayList<String> listaCiclos) {
		this.listaCiclos = listaCiclos;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", notaMedia=" + notaMedia + ", listaCiclo=" + listaCiclos
				+ "]";
	}
	

}
