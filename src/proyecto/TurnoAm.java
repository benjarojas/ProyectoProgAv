package proyecto;

public class TurnoAm extends Turno {
	public TurnoAm(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		super(horaInicio,horaFin,trabajador,especialidad);
	}
	public String getHoraInicio()
	{
		return super.getHoraInicio()+"am";
	}
}
 