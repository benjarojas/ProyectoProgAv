package proyecto;
import java.util.ArrayList;

public class Dia {

	// ArrayList turnosDia
	// Se almacenaran todos los objetos Turno correspondientes al día
	private ArrayList<Turno> turnosDia = new ArrayList<Turno>();
	
	// Nombre día
	private String nombreDia;
	
	// Constructor con parámetro Nombre
	public Dia(String Nombre)
	{
		nombreDia = Nombre;
	}
	
	// Setter nombreDia
	public void setNombreDia(String nombre)
	{
		nombreDia = nombre;
	}
	
	// Getter nombreDia
	public String getNombreDia()
	{
		return nombreDia;
	}
	
	// Método para agregar un objeto Turno al ArrayList turnosDia
	public void addTurno(Turno turno)
	{
		turnosDia.add(turno);
	}
	
	// Método para crear un objeto Turno y agregarlo al ArrayList turnosDia
	public void addTurno(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		Turno newTurno = new Turno();
		newTurno.setEspecialidad(especialidad);
		newTurno.setHoraInicio(horaFin);
		newTurno.setHoraFin(horaFin);
		newTurno.setTrabajador(trabajador);
		
		turnosDia.add(newTurno);
	}
	
	// Retorna un ArrayList con todos los turnos agendados para ese día
	public ArrayList<Turno> getTurnos()
	{
		return turnosDia;
	}
	
}
