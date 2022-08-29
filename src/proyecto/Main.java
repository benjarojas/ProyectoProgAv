package proyecto;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String txtLine;
		BufferedReader txtRead = new BufferedReader(new FileReader("turnosEnfermeras.txt"));
		
		ArrayList<String> out = new ArrayList<String>();
		
		while((txtLine = txtRead.readLine()) != null)
		{
			out.add(txtLine);
		}
		
		txtRead.close();
		
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
		
		for (int i = 0; i < out.size(); i++) {
			String[] arrayTurno = out.get(i).split(",", 5);
			Turno turnoCargar = new Turno();
			turnoCargar.setHoraInicio(arrayTurno[1]);
			turnoCargar.setHoraFin(arrayTurno[2]);
			turnoCargar.setTrabajador(arrayTurno[3]);
			turnoCargar.setEspecialidad(arrayTurno[4]);
			semana.get(arrayTurno[0]).addTurno(turnoCargar);
		}
		
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
