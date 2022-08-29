package proyecto;
import java.util.ArrayList;

public class Dia {

	public ArrayList<Turno> turnosDia = new ArrayList<Turno>();
	private String nombreDia;
	
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
	
	public ArrayList<Turno> getTurnos()
	{
		return turnosDia;
	}
	
}
