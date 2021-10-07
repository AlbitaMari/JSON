package T1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class T1 {

		public static void main(String[] args) throws IOException {
			
			Scanner sc = new Scanner(System.in);
			//Gson gson = new Gson();/
			ArrayList<Alumno> listaAlumnos = new ArrayList<>();
			ArrayList<String> listaCiclo = new ArrayList<>();
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<Alumno>>() {}.getType();
			
			String fichero = "";
			 
			try (BufferedReader br = new BufferedReader(new FileReader("Alumno.json"))) {
			    String linea;
			    while ((linea = br.readLine()) != null) {
			        fichero += linea;
			        listaAlumnos = gson.fromJson(fichero, listType);
			    }
			 
			} catch (FileNotFoundException ex) {
			    System.out.println(ex.getMessage());
			} catch (IOException ex) {
			    System.out.println(ex.getMessage());
			}
			//Comprobamos si el fichero existe,y si no existe lo creamos.
			File f = new File("./src/Alumnos.json");
		       if (f.createNewFile()) {
		           System.out.println("File created");		           
		       }else {
		          System.out.println("File already exists");
		       }
			System.out.println("Aplicación realizada por Alba Salomón Sáenz\n");
			int num = 0;
			do {
				System.out.println("********* M E N Ú *********");
				System.out.println("1. Insertar alumno. ");
				System.out.println("2. Borrar alumno  ");
				System.out.println("3. Modificar alumno ");
				System.out.println("4. Mostrar alumnos ");
				System.out.println("5. Salir ");
				num = sc.nextInt();
				switch(num) {
					case 1:
							System.out.println("Introduzca el nombre del alumno: ");
							String nombre= sc.next();
							System.out.println("Introduce el DNI del alumno: ");
							String dni = sc.next();
							String ciclos = "";
							do {
								System.out.println("Ciclo cursado (N para salir): ");
								ciclos = sc.next();
								for(int i = 0; i < listaAlumnos.size();i++) {
								if(!ciclos.toUpperCase().equals("N")) {
										listaCiclo.add(ciclos);

								}else 
									break;
								}
							}while(!ciclos.toUpperCase().equals("N"));
							System.out.println("Nota media: ");
							int media = sc.nextInt();
							Alumno alumno = new Alumno(nombre,dni,media,listaCiclo);
							listaAlumnos.add(alumno);
						break;
					case 2:
						System.out.println("Introduce DNI de la persona que quieras eliminar: ");
						String delete = sc.next();
						String id = "";
						for(int i = 0; i < listaAlumnos.size() ;i++) {
							id = listaAlumnos.get(i).getDni();
							if(id.equals(delete)) {
								listaAlumnos.remove(i);
							}
						}
						System.out.println("*** Array Resultante ***");
						System.out.println(listaAlumnos+"\n");
						break;
					case 3:
						System.out.println("Introduce DNI del alumno que quieras modificar: ");
						String modif = sc.next();
						String id2 = "";
						for(int i = 0; i < listaAlumnos.size() ;i++) {
							id2 = listaAlumnos.get(i).getDni();
							if(id2.equals(modif)) {
								System.out.println("Nombre: ");
								String nom = sc.next();
								listaAlumnos.get(i).setNombre(nom);
								System.out.println("DNI: ");
								String dnii = sc.next();
								listaAlumnos.get(i).setDni(dnii);
								String ciclo = "";
								do {
									System.out.println("Ciclo cursado (N para salir): ");
									ciclo = sc.next();
									if(!ciclo.toUpperCase().equals("N")) {
											listaCiclo.add(ciclo);
									}else {
										break;
									}
								}while(!ciclo.toUpperCase().equals("N"));
								listaAlumnos.get(i).setListaCiclos(listaCiclo);
								System.out.println("Nota media: ");
								media = sc.nextInt();
								listaAlumnos.get(i).setNotaMedia(media);
							}
						}
						break;
					case 4:
						for(int i = 0; i < listaAlumnos.size(); i++) {
							System.out.println(gson.toJson(listaAlumnos.get(i)));
						}
						break;
				}
			}while(num==0 || num!=5);
			
			//Escribimos en el archivo 'alumno.json'
			try (Writer writer = new FileWriter("Alumno.json")) {
			    new GsonBuilder().create();
			    writer.write(gson.toJson(listaAlumnos));
			    writer.close();
				} catch(FileNotFoundException a) {
					System.out.println("Error");
				} catch(Exception e) {
					System.out.println("Error");
				}
	}
}






