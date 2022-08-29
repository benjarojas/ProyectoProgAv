package proyecto;
public class Turno {

	private String horaInicio;
	private String horaFin;
	private String trabajador;
	private String especialidad;
	
	public Turno() {
		horaInicio = new String();
		horaFin = new String();
		trabajador = new String();
		especialidad = new String();
	}
	
	public void setHoraInicio(String hora)
	{
		horaInicio = hora;
	}
	
	public String getHoraInicio()
	{
		return horaInicio;
	}
	
	public void setHoraFin(String hora)
	{
		horaFin = hora;
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
