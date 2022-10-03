package GestionTurnos;

import java.util.ArrayList;

public class Dia {

	private ArrayList<Turno> turnosDia;
	private String nombreDia;

	
	public Dia(String Nombre)
	{
		turnosDia = new ArrayList<Turno>();
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
	
	// Obtenemos todos los turnos del dia
	public Turno[] getTurnos()
	{
		Turno[] arrayTurnos = new Turno[turnosDia.size()];
        arrayTurnos = turnosDia.toArray(arrayTurnos);
        return arrayTurnos;
	}

	// Este método retorna un arreglo de Turnos que coincidan con el nombre buscado
	public Turno[] getTurnosTrabajador(String trabajador)
	{
		ArrayList<Turno> turnosCoinciden = new ArrayList<Turno>();
		// Iteramos por todo el arraylist de turnos
		for(int i = 0;i<turnosDia.size();i++) {
			// Si la especialidad del turno actual es igual a la buscada
			if(turnosDia.get(i).getTrabajador().equals(trabajador)) {
				turnosCoinciden.add(turnosDia.get(i));
			}
		}
		Turno[] arrayTurnos = new Turno[turnosCoinciden.size()];
        arrayTurnos = turnosCoinciden.toArray(arrayTurnos);
        return arrayTurnos;
	}
	
	// Este método retorna un arreglo de Turnos que coincidan con la especialidad buscada
	public Turno[] getTurnosEspecialidad(String especialidad)
	{
		ArrayList<Turno> turnosCoinciden = new ArrayList<Turno>();
		// Iteramos por todo el arraylist de turnos
		for(int i = 0;i<turnosDia.size();i++) {
			// Si la especialidad del turno actual es igual a la buscada
			if(turnosDia.get(i).getEspecialidad().equals(especialidad)) {
				turnosCoinciden.add(turnosDia.get(i));
			}
		}
		Turno[] arrayTurnos = new Turno[turnosCoinciden.size()];
        arrayTurnos = turnosCoinciden.toArray(arrayTurnos);
        return arrayTurnos;
	}
	
	public boolean eliminarTurno(String nombre) {
		int k = 0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(nombre)) {
				turnosDia.remove(i);
				k++;
			}
		}
		if(k == 0)
		{
			return false;
		} else {
			return true;
		}
	}
	
	public boolean modificarTrabajadorTurno(String dia, String trabajador, String nuevoTrabajador)
	{
		int k=0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(trabajador)) {
				turnosDia.get(i).setTrabajador(nuevoTrabajador);
				k++;
			}
		}
		if(k == 0)
		{
			return false;
		} else {
			return true;
		}
	}
	
	public boolean modificarHoraInicioTurno(String dia, String trabajador, String nuevaHoraInicio)
	{
		int k=0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(trabajador)) {
				turnosDia.get(i).setHoraInicio(nuevaHoraInicio);
				k++;
			}
		}
		if(k == 0)
		{
			return false;
		} else {
			return true;
		}
	}
	
	public boolean modificarHoraFinTurno(String dia, String trabajador, String nuevaHoraFin)
	{
		int k=0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(trabajador)) {
				turnosDia.get(i).setHoraFin(nuevaHoraFin);
				k++;
			}
		}
		if(k == 0)
		{
			return false;
		} else {
			return true;
		}
	}
	
	public boolean modificarEspecialidadTurno(String dia, String trabajador, String nuevaEspecialidad)
	{
		int k=0;
		for(int i = 0;i<turnosDia.size();i++) {
			if(turnosDia.get(i).getTrabajador().equals(trabajador)) {
				turnosDia.get(i).setEspecialidad(nuevaEspecialidad);
				k++;
			}
		}
		if(k == 0)
		{
			return false;
		} else {
			return true;
		}
	}
	
}
