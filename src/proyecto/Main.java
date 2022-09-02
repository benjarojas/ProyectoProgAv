package proyecto;
import java.io.*;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Linea del archivo y lector de archivo txt
		String txtLine;
		BufferedReader txtRead = new BufferedReader(new FileReader("turnosEnfermeras.txt"));
		
		
		// creamos tabla hash que corresponde a la semana y sus objetos de tipo Dia
		Hashtable<String, Dia> semana = new Hashtable<>();
		semana.put("Lunes", new Dia("Lunes")); // La clave del cada elemento es un string con su nombre y el valor es un objeto de tipo Dia
		semana.put("Martes", new Dia("Martes")); // el objeto Dia se construye con su nombre respectivo
		semana.put("Miercoles", new Dia("Miercoles"));
		semana.put("Jueves", new Dia("Jueves"));
		semana.put("Viernes", new Dia("Viernes"));
		semana.put("Sabado", new Dia("Sabado"));
		semana.put("Domingo", new Dia("Domingo"));
		
		// Creamos un lector para leer opciones del menu
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		
		int opcion = 0;
		String input;
		
		// Agregamos c/linea del archivo al arraylist
		while((txtLine = txtRead.readLine()) != null)
		{
			String[] arrayTurno = txtLine.split(",", 5);
			Turno turnoCargar = new Turno();
			turnoCargar.setHoraInicio(arrayTurno[1]);
			turnoCargar.setHoraFin(arrayTurno[2]);
			turnoCargar.setTrabajador(arrayTurno[3]);
			turnoCargar.setEspecialidad(arrayTurno[4]);
			semana.get(arrayTurno[0]).addTurno(turnoCargar);
		}
		
		// cerramos archivo
		txtRead.close();
				
		while(true)
		{
			System.out.println("Ingrese opcion: ");
			System.out.println("1.- Agregar turno");
			System.out.println("2.- Listar turnos por día");
			System.out.println("3.- Salir");
			
			opcion = Integer.parseInt(lector.readLine());
			
			switch(opcion)
			{
			case 1:
				System.out.println("Ingrese el dia del turno (Ej. Lunes): ");
				
				input = lector.readLine();
				
				Turno nuevoTurno = new Turno();
				
				System.out.println("Ingrese la hora de inicio (Ej. 08:00): ");
				nuevoTurno.setHoraInicio(lector.readLine());
				//nuevoTurno.setHoraInicio(Integer.parseInt(lector.readLine()));
				
				System.out.println("Ingrese la hora de fin (Ej. 18:00): ");
				nuevoTurno.setHoraFin(lector.readLine());
				//nuevoTurno.setHoraFin(Integer.parseInt(lector.readLine()));
				
				System.out.println("Ingrese el nombre del trabajador: ");
				nuevoTurno.setTrabajador(lector.readLine());
				
				System.out.println("Ingrese la especialidad: ");
				nuevoTurno.setEspecialidad(lector.readLine());
				
				semana.get(input).addTurno(nuevoTurno);
				break;
				
			case 2:
				System.out.println("Ingrese el dia del turno: ");
				input = lector.readLine();
				if(semana.get(input).getTurnos().size() == 0)
				{
					System.out.println("No hay turnos para el día "+input+"!");
				}
				semana.get(input).listarTurnos();
				break;
				
			case 3:
				break;
			}
			
			if(opcion == 3) break;
		}

		
	}

}
