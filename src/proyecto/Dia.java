package proyecto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dia {

	private ArrayList<Turno> turnosDia = new ArrayList<Turno>();
	private String nombreDia;

	
	public Dia(String Nombre)
	{
		nombreDia = Nombre;
	}
	
	public void setNombreDia(String nombre)
	{
		nombreDia = nombre;
	}
	
	public String getNombreDia()
	{
		return nombreDia;
	}
	
	public void addTurno(Turno turno)
	{
		turnosDia.add(turno);
	}
	
	public void addTurno(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		Turno newTurno = new Turno();
		newTurno.setEspecialidad(especialidad);
		newTurno.setHoraInicio(horaFin);
		newTurno.setHoraFin(horaFin);
		newTurno.setTrabajador(trabajador);
		
		turnosDia.add(newTurno);
	}
	
	public ArrayList<Turno> getTurnos()
	{
		return turnosDia;
	}
	
	public void listarTurnos()
	{
		if(turnosDia.size()==0)
		{
			System.out.println("No hay turnos en este dia");
		}
		for (int i = 0; i < turnosDia.size(); i++) {
			System.out.println("----- Turno "+ (i+1) + " -----");
			System.out.println("Nombre: "+ turnosDia.get(i).getTrabajador());
		    System.out.println("Especialidad: "+ turnosDia.get(i).getEspecialidad());
		    System.out.println("Hora Inicio: " + turnosDia.get(i).getHoraInicio());
		    System.out.println("Hora Fin: " + turnosDia.get(i).getHoraFin());
		    System.out.println("");
		}
	}
	public void eliminarTurno(String nombre) {
		int k=0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(nombre)) {
				System.out.println("Turno eliminado con exito");
				turnosDia.remove(i);
				k++;
			}
			
		}
		if(k==0)System.out.println("Nombre no encontrado");
		
	}
	public void modificarTurno(String nombre)throws IOException {
		String input;
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		int k=0;
		int opcion=0;
		
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(nombre)) {
				k++;
				while(true)
				{
					System.out.println("Ingrese opcion: ");
					System.out.println("1.-Cambiar nombre trabajador");
					System.out.println("2.-Cambiar hora de inicio");
					System.out.println("3.-Cambiar hora de salida");
					System.out.println("4.-Cambiar especialidad");
					System.out.println("5.-Salir");
					opcion = Integer.parseInt(lector.readLine());
					switch(opcion)
					{
					case 1:
						System.out.println("Nombre de trabajador actual: "+turnosDia.get(i).getTrabajador());
						System.out.println("Ingrese nuevo nombre de trabajador");
						input=lector.readLine();
						turnosDia.get(i).setTrabajador(input);
						break;
					case 2:
						System.out.println("Hora de entrada actual: "+turnosDia.get(i).getHoraInicio());
						System.out.println("Hora de salida actual: "+turnosDia.get(i).getHoraFin());
						
						System.out.println("Ingrese nueva hora de inicio");
						input=lector.readLine();
						turnosDia.get(i).setHoraInicio(input);
						break;
					case 3:
						System.out.println("Ingrese nueva hora de salida");
						input=lector.readLine();
						turnosDia.get(i).setHoraFin(input);
						break;
					case 4:
						System.out.println("Especialidad actual: "+turnosDia.get(i).getEspecialidad());
						System.out.println("Ingrese nueva especialidad");
						input=lector.readLine();
						turnosDia.get(i).setEspecialidad(input);
						break;
						
						
					}
					if(opcion==5)break;
				}
				
				
			}
			
		}
		if(k==0)System.out.println("Nombre no encontrado");
		
	}

	
}
