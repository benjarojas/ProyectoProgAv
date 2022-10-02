package proyecto;

public class TurnoMañanero extends Turno {
	public TurnoMañanero(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		super(horaInicio,horaFin,trabajador,especialidad);
	}
	public String getHoraInicios()
	{
		System.out.println("kekw");
		return getHoraInicio()+"am";
	}
}
 