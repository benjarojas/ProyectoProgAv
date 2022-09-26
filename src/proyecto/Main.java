package proyecto;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO:
		//SIA2.5 Se deben incluir al menos 1 funcionalidad propia que sean de utilidad para el negocio (distintas
		//de la inserción, edición, eliminación y reportes). Específicamente: - Subconjunto filtrado por criterio: considera la selección de un subconjunto de objetos
		//basado en un criterio específico, involucrando 1 o más colecciones. Por ejemplo, selección
		//de los alumnos con nota final entre 4,0 y 7,0 de entre todos los cursos; o seleccionar a todos
		//los pasajeros que tengan asiento impar de entre todos los buses de la compañía.
		//SIA2.9 Crear 2 clases que extiendan de una Excepción y que se utilicen en el programa
		
		// Linea del archivo y lector de archivo txt
		String txtLine;
		BufferedReader txtRead = new BufferedReader(new FileReader("turnosEnfermeras.txt"));
		
		
		// Creamos HashMap que corresponde a la semana y agregamos sus objetos de tipo Dia
		HashMap<String, Dia> semana = new HashMap<>();
		semana.put("Lunes", new Dia("Lunes")); // La clave del cada elemento es un string con su nombre y el valor es un objeto de tipo Dia
		semana.put("Martes", new Dia("Martes")); // el objeto Dia se construye con su nombre respectivo
		semana.put("Miercoles", new Dia("Miercoles"));
		semana.put("Jueves", new Dia("Jueves"));
		semana.put("Viernes", new Dia("Viernes"));
		semana.put("Sabado", new Dia("Sabado"));
		semana.put("Domingo", new Dia("Domingo"));
		
		// Instanciamos un lector para leer opciones del menu
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		
		int opcion = 0;
		String input;
		
		// Creamos un objeto de tipo Turno
		// Seteamos sus atributos según cada línea del archivo txt
		// Insertamos en el HashMap semana
		while((txtLine = txtRead.readLine()) != null)
		{
			// El primer String del arreglo corresponde al nombre del Día del turno
			// El resto de los Strings corresponden a los detalles (horas, nombre y especialidad)
			String[] arrayTurno = txtLine.split(",", 5);
			Turno turnoCargar = new Turno(arrayTurno[1], arrayTurno[2], arrayTurno[3], arrayTurno[4]);
			semana.get(arrayTurno[0]).addTurno(turnoCargar);
		}
		
		// Cerramos archivo txt
		txtRead.close();
				
		while(true)
		{
			System.out.println("Ingrese opcion: ");
			System.out.println("1.- Agregar turno");
			System.out.println("2.- Listar turnos por día");
			System.out.println("3.- Salir");
			
			// Transformamos String en entero
			opcion = Integer.parseInt(lector.readLine());
			
			switch(opcion)
			{
			case 1:
				
				System.out.println("Ingrese el dia del turno (Ej. Lunes): ");
				input = lector.readLine();
				
				// Instanciamos un objeto Turno
				// No se utiliza el constructor con parámetros
				// para no crear variables extra.
				Turno nuevoTurno = new Turno();
				
				// Intentamos setear los atributos del Turno
				// Ante cualquier error, manejamos la excepción
				try {
					System.out.println("Ingrese la hora de inicio (Ej. 08:00): ");
					nuevoTurno.setHoraInicio(lector.readLine());
					
					System.out.println("Ingrese la hora de fin (Ej. 18:00): ");
					nuevoTurno.setHoraFin(lector.readLine());
					
					System.out.println("Ingrese el nombre del trabajador: ");
					nuevoTurno.setTrabajador(lector.readLine());
				
					System.out.println("Ingrese la especialidad: ");
					nuevoTurno.setEspecialidad(lector.readLine());
				} catch(Exception e) {
					System.out.println("Error: se ingresó un parámetro inválido.");
					break;
				}
				
				// Intentamos añadir el turno al mapa, si la clave no existe
				// usamos catch para manejar la excepción
				try {
					semana.get(input).addTurno(nuevoTurno);
				} catch(Exception e) {
					System.out.println("Error: no se pudo ingresar el turno. Ingrese correctamente el día.");
				}
				
				break;
				
			case 2:
				System.out.println("Ingrese el dia del turno: ");
				input = lector.readLine(); // Leemos el turno (Ej: Lunes)
				
				// Intentamos acceder al valor en el mapa, si no existe
				// usamos catch para manejar la excepcion mostrando un error
				try {
					
					// Obtenemos un ArrayList con todos los turnos del Día seleccionado
					ArrayList<Turno> listaTurnos = semana.get(input).getTurnos();
					
					if(listaTurnos.size() == 0)
					{
						System.out.println("No hay turnos agendados para el día "+input+"!");
						break;
					}
					
					for (int i = 0; i < listaTurnos.size(); i++) {
						System.out.println("----- Turno "+ (i+1) + " -----");
						System.out.println("Nombre: "+ listaTurnos.get(i).getTrabajador());
					    System.out.println("Especialidad: "+ listaTurnos.get(i).getEspecialidad());
					    System.out.println("Hora Inicio: " + listaTurnos.get(i).getHoraInicio());
					    System.out.println("Hora Fin: " + listaTurnos.get(i).getHoraFin());
					    System.out.println("");
					}
					
				} catch(Exception e) {
					System.out.println("Error: El valor ingresado no corresponde a un día válido!");
				}
				break;
				
			case 3:
				break;
			}
			
			if(opcion == 3) break;
		}

		
	}

}
