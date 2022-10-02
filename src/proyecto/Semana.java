package proyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Semana {
	private HashMap<String, Dia> semana = new HashMap<>();
	
	public Semana() {
		semana.put("Lunes", new Dia("Lunes")); // La clave del cada elemento es un string con su nombre y el valor es un objeto de tipo Dia
		semana.put("Martes", new Dia("Martes")); // el objeto Dia se construye con su nombre respectivo
		semana.put("Miercoles", new Dia("Miercoles"));
		semana.put("Jueves", new Dia("Jueves"));
		semana.put("Viernes", new Dia("Viernes"));
		semana.put("Sabado", new Dia("Sabado"));
		semana.put("Domingo", new Dia("Domingo"));
	}
	
	public void agregarTurno(String clave,Turno cc)
	{
	   semana.get(clave).addTurno(cc);
	}
	public boolean verificar(String clave)
	{
		for (String i : semana.keySet())
		{
			if(clave.equals(i)) {
				return true;
			}
		}
		return false;
	}
	public void listarTurnosDia(String clave)
	{
		semana.get(clave).listarTurnos();
	}
	public void eliminarTurnoDia(String clave,String nombreTrabajador)
	{
		semana.get(clave).eliminarTurno(nombreTrabajador);
	}
	public void modificarTurnoDia(String clave,String nombreTrabajador)throws IOException 
	{
		
		semana.get(clave).modificarTurno(nombreTrabajador);
		
	}
	
	public void getTurno2()throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("turnosEnfermeras.txt"));
		for (String i : semana.keySet())
		{
			ArrayList<Turno> aux = new ArrayList<Turno>();
			aux=semana.get(i).getTurnos();
			for(int k = 0;k<aux.size();k++)
			{
				bw.write(i);
				bw.write(",");
				bw.write(aux.get(k).getHoraInicio());
				bw.write(",");
				bw.write(aux.get(k).getHoraFin());
				bw.write(",");
				bw.write(aux.get(k).getTrabajador());
				bw.write(",");
				bw.write(aux.get(k).getEspecialidad());
				bw.write("\n");
			}
		}
		bw.close();
		
	}
}
