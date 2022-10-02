package proyecto;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// Linea del archivo y lector de archivo txt
		String txtLine;
		BufferedReader txtRead = new BufferedReader(new FileReader("turnosEnfermeras.txt"));
		
		
		Semana vari = new Semana();
		
		// Instanciamos un lector para leer opciones del menu
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		//Turno turnoCargar2 = new TurnoAm("11:00","12:00", "Javiera", "Neurologia");
		//System.out.println(turnoCargar2.getHoraInicio());
		int opcion = 0;
		String input;
		String input2;
		
		// Creamos un objeto de tipo Turno
		// Seteamos sus atributos según cada línea del archivo txt
		// Insertamos en el HashMap semana
		while((txtLine = txtRead.readLine()) != null)
		{
			// El primer String del arreglo corresponde al nombre del Día del turno
			// El resto de los Strings corresponden a los detalles (horas, nombre y especialidad)
			String[] arrayTurno = txtLine.split(",", 5);
			Turno turnoCargar = new Turno(arrayTurno[0], arrayTurno[1], arrayTurno[2], arrayTurno[3], arrayTurno[4]);
			try
			{
				vari.agregarTurno(arrayTurno[0], turnoCargar);
			} catch(DiaInvalidoException e){
				break;
			}
		}
	
		
		
		
		// Cerramos archivo txt
		txtRead.close();
			
		while(true)
		{
			System.out.println("Ingrese opcion: ");
			System.out.println("1.- Agregar turno");
			System.out.println("2.- Listar turnos por día");
			System.out.println("3.- Eliminar turno");
			System.out.println("4.- Modificar turno");
			System.out.println("5.- Filtrar turnos por criterio");
			System.out.println("6.- Generar reporte");
			System.out.println("7.- Salir");
			
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
				nuevoTurno.setDiaTurno(input); // Seteamos el dia del turno
				
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
					vari.agregarTurno(input, nuevoTurno);
				} catch(DiaInvalidoException e) {
					System.out.println("Error: no se pudo ingresar el turno. Ingrese correctamente el día.");
				}
				
				break;
				
			case 2:
				System.out.println("Ingrese el dia del turno: ");
				input = lector.readLine(); // Leemos el turno (Ej: Lunes)
				
				// Intentamos acceder al valor en el mapa, si no existe
				// usamos catch para manejar la excepcion mostrando un error
				try {
					vari.listarTurnosDia(input);
				} catch(DiaInvalidoException e) {
					System.out.println("Error: El valor ingresado no corresponde a un día válido!");
				}
				break;
				
			case 3:
				System.out.println("Ingrese dia del turno");
				input = lector.readLine(); // Leemos el turno (Ej: Lunes)
				System.out.println("Ingrese nombre del trabajador");
				input2 = lector.readLine(); 
				
				try {

					vari.eliminarTurnoDia(input, input2);
					
				} catch(DiaInvalidoException e) {
					System.out.println("Error: El valor ingresado no corresponde a un día válido!");
				} catch (NoEncontradoException a) {
					System.out.println("Error: El trabajador no fue encontrado!");
				}
				break;
			
			case 4:
				System.out.println("Ingrese dia del turno: ");
				input = lector.readLine(); // Leemos el turno (Ej: Lunes)
				System.out.println("Ingrese nombre del trabajador: ");
				input2 = lector.readLine(); 
				
				try {

					vari.modificarTurnoDia(input, input2);
					
				} catch(DiaInvalidoException e) {
					System.out.println("Error: El valor ingresado no corresponde a un día válido!");
				} catch (NoEncontradoException e) {
					System.out.println("Error: El trabajador no fue encontrado!");
				}
				break;
			
			case 5:
				System.out.println("\nFiltrar por: ");
				System.out.println("1.- Nombre trabajador");
				System.out.println("2.- Especialidad");
				System.out.println("3.- Cancelar\n");
				
				int filtro = Integer.parseInt(lector.readLine());
				
				switch(filtro)
				{
				case 1:
					System.out.println("Ingrese nombre del trabajador: ");
					input = lector.readLine(); 
					vari.filtrarTurnosTrabajador(input);
					break;
				case 2:
					System.out.println("Ingrese especialidad: ");
					input = lector.readLine(); 
					vari.filtrarTurnosEspecialidad(input);
					break;
				case 3:
					break;
				}
				
				break;
				
			case 6:
				System.out.println("\nGenerar reporte: ");
				System.out.println("1.- Todos los turnos de un trabajador");
				System.out.println("2.- Todos los turnos de una especialidad");
				System.out.println("3.- Todos los turnos de un dia");
				System.out.println("4.- Especialidades y cantidad de turnos asociados");
				System.out.println("5.- Cancelar\n");
				
				int reporte = Integer.parseInt(lector.readLine());
				
				switch(reporte)
				{
				case 1:
					System.out.println("Ingrese el nombre del trabajador: ");
					input = lector.readLine(); 
					System.out.println("Ingrese el nombre del archivo: ");
					input2 = lector.readLine();
				    vari.reporteTurnosTrabajador(input, input2);
					break;
				case 2:
					System.out.println("Ingrese la especialidad: ");
					input = lector.readLine(); 
					System.out.println("Ingrese el nombre del archivo: ");
					input2 = lector.readLine();
				    vari.reporteTurnosEspecialidad(input, input2);
					break;
				case 3:
					System.out.println("Ingrese el dia: ");
					input = lector.readLine(); 
					System.out.println("Ingrese el nombre del archivo: ");
					input2 = lector.readLine();
					try {
				    vari.reporteTurnosDia(input, input2);
					} catch(DiaInvalidoException e) {
						System.out.println("El día ingresado no existe!\n");
					}
					
				case 4:
					break;
					
				case 5:
					break;
				}
				break;
			}
			
			if(opcion == 7) {

				vari.guardarCambios();

				break;
				
				
				}
			
		}
		
		
	}

}
