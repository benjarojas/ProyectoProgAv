package proyecto;
public class Turno {

	private String horaInicio;
	private String horaFin;
	private String trabajador;
	private String especialidad;
	
	public void setHoraInicio(String hora)
	{
		horaInicio = hora;
	}
	
	public void setHoraInicio(int hora)
	{
		horaInicio = hora+"";
		String horas = horaInicio.substring(0, (horaInicio.length()/2));
		String min = horaInicio.substring((horaInicio.length()/2));
		horaInicio = horas + ":" + min;
	}
	
	public String getHoraInicio()
	{
		return horaInicio;
	}
	
	public void setHoraFin(String hora)
	{
		horaFin = hora;
	}
	
	public void setHoraFin(int hora)
	{
		horaFin = hora+"";
		String horas = horaFin.substring(0, (horaFin.length()/2));
		String min = horaFin.substring((horaFin.length()/2));
		horaFin = horas + ":" + min;
	}
	
	public String getHoraFin()
	{
		return horaFin;
	}
	
	public void setTrabajador(String nombre)
	{
		trabajador = nombre;
	}
	
	public String getTrabajador()
	{
		return trabajador;
	}
	
	public void setEspecialidad(String esp)
	{
		especialidad = esp;
	}
	
	public String getEspecialidad()
	{
		return especialidad;
	}
	
}
