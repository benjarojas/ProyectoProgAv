package proyecto;

public class TurnoPm extends Turno {
	public TurnoPm(String horaInicio, String horaFin, String trabajador, String especialidad)
	{
		super(horaInicio,horaFin,trabajador,especialidad);
	}
	public String getHoraInicio()
	{
		return super.getHoraInicio()+"pm";
	}
}
 