package proyecto;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Hashtable<String, Dia> semana = new Hashtable<>();
		semana.put("Lunes", new Dia("Lunes"));
		semana.put("Martes", new Dia("Martes"));
		semana.put("Miercoles", new Dia("Miercoles"));
		semana.put("Jueves", new Dia("Jueves"));
		semana.put("Viernes", new Dia("Viernes"));
		semana.put("Sabado", new Dia("Sabado"));
		semana.put("Domingo", new Dia("Domingo"));
		
		
		
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		
		int opcion = 0;
		String input;
		
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
				System.out.println("Ingrese el dia del turno: ");
				
				input = lector.readLine();
				
				Turno nuevoTurno = new Turno();
				
				System.out.println("Ingrese la hora de inicio: ");
				nuevoTurno.setHoraInicio(lector.readLine());
				
				System.out.println("Ingrese la hora de fin: ");
				nuevoTurno.setHoraFin(lector.readLine());
				
				System.out.println("Ingrese el nombre del trabajador: ");
				nuevoTurno.setTrabajador(lector.readLine());
				
				System.out.println("Ingrese la especialidad: ");
				nuevoTurno.setEspecialidad(lector.readLine());
				
				semana.get(input).addTurno(nuevoTurno);
				break;
			case 2:
				System.out.println("Ingrese el dia del turno: ");
				input = lector.readLine();
				semana.get(input).listarTurnos();
				break;
			case 3:
				break;
			}
			if(opcion == 3) break;
		}

		
	}

}
