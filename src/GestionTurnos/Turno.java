package GestionTurnos;

public class Turno {

	private String horaInicio;
	private String diaTurno;
	private String horaFin;
	private String trabajador;
	private String especialidad;
	
	public Turno()
	{}
	
	// Constructor Turno con parámetros
	public Turno(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.trabajador = trabajador;
		this.especialidad = especialidad;
	}
	
	// Constructor Turno con parámetros
	public Turno(String diaTurno, String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		this.diaTurno = diaTurno;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.trabajador = trabajador;
		this.especialidad = especialidad;
	}
	
	// Setter con sobrecarga horaInicio
	// Permite ingresar horas de tipo String ("08:00")
	public void setHoraInicio(String hora)
	{
		horaInicio = hora;
	}
	
	// Setter con sobrecarga horaInicio
	// Permite ingresar horas de forma entera 0800 o 1900
	public void setHoraInicio(int hora)
	{
		horaInicio = hora+"";
		String horas = horaInicio.substring(0, (horaInicio.length()/2));
		String min = horaInicio.substring((horaInicio.length()/2));
		horaInicio = horas + ":" + min;
	}
	
	// Getter horaInicio
	public String getHoraInicio()
	{
		return horaInicio;
	}
	
	// Setter con sobrecarga horaFin
	// Permite ingresar horas de tipo String ("08:00")
	public void setHoraFin(String hora)
	{
		horaFin = hora;
	}
	
	// Setter con sobrecarga horaFin
	// Permite ingresar horas de forma entera 0800 o 1900
	public void setHoraFin(int hora)
	{
		horaFin = hora+"";
		String horas = horaFin.substring(0, (horaFin.length()/2));
		String min = horaFin.substring((horaFin.length()/2));
		horaFin = horas + ":" + min;
	}
	
	// Getter horaFin
	public String getHoraFin()
	{
		return horaFin;
	}
	
	// Setter trabajador
	public void setTrabajador(String nombre)
	{
		trabajador = nombre;
	}
	
	// Getter trabajador
	public String getTrabajador()
	{
		return trabajador;
	}
	
	// Setter especialidad
	public void setEspecialidad(String esp)
	{
		especialidad = esp;
	}
	
	// Getter especialidad
	public String getEspecialidad()
	{
		return especialidad;
	}
	
	// Setter diaTurno
	public void setDiaTurno(String diaTurno)
	{
		this.diaTurno = diaTurno;
	}
	
	// Getter diaTurno
	public String getDiaTurno()
	{
		return this.diaTurno;
	}	
	
}
