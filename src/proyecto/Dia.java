package proyecto;
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
		for (int i = 0; i < turnosDia.size(); i++) {
			System.out.println("----- Turno "+ (i+1) + " -----");
			System.out.println("Nombre: "+ turnosDia.get(i).getTrabajador());
		    System.out.println("Especialidad: "+ turnosDia.get(i).getEspecialidad());
		    System.out.println("Hora Inicio: " + turnosDia.get(i).getHoraInicio());
		    System.out.println("Hora Fin: " + turnosDia.get(i).getHoraFin());
		    System.out.println("");
		}
	}
	
}
