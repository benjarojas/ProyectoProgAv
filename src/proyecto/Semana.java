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
	
	// Este método agrega un turno al HashMap semana
	public void agregarTurno(String clave,Turno cc) throws DiaInvalidoException
	{
	   // Verificamos que exista la clave
	   if(semana.containsKey(clave)) {
		   semana.get(clave).addTurno(cc);
	   } else {
		   // Lanzamos una excepción propia DiaInvalidoException
		   throw new DiaInvalidoException("El día "+clave+" no existe!");
	   }
	}
	
	// Este método lista todos los turnos de un cierto día
	public void listarTurnosDia(String clave) throws DiaInvalidoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).listarTurnos();
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	// Este método lista todos los turnos que tenga un trabajador
	// en toda la semana
	public void filtrarTurnosTrabajador(String trabajador)
	{
		for (String i : semana.keySet())
		{
			semana.get(i).listarTurnosTrabajador(trabajador);
		}
	}
	
	// Este método lista todos los turnos de cierta especialidad
	// en toda la semana
	public void filtrarTurnosEspecialidad(String especialidad)
	{
		for (String i : semana.keySet())
		{
			semana.get(i).listarTurnosEspecialidad(especialidad);
		}
	}
	
	// Este método elimina un Turno de un día del HashMap semana
	public void eliminarTurnoDia(String clave,String nombreTrabajador) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).eliminarTurno(nombreTrabajador);
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	// Este método modifica un Turno dentro de un día
	public void modificarTurnoDia(String clave,String nombreTrabajador) throws IOException, DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).modificarTurno(nombreTrabajador);
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	// Esta función sobreescribe el archivo txt
	// actualizando todos los cambios realizados
	public void guardarCambios() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("turnosEnfermeras.txt"));
		
		// Iteramos por cada clave del HashMap semana (día)
		for (String i : semana.keySet())
		{
			ArrayList<Turno> aux = semana.get(i).getTurnos(); // Obtenemos todos los turnos del día
			// Recorremos todo el ArrayList de Turnos
			for(int k = 0;k<aux.size();k++)
			{
				// Imprimimos cada atributo
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
	
	public void reporteTurnosTrabajador(String trabajador, String nombreArchivo) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo+".txt"));
		bw.write("Turnos asignados al trabador: "+trabajador+"\n");
		
		for (String i : semana.keySet())
		{
			ArrayList<Turno> aux = semana.get(i).getTurnos();
			
			for(int j = 0;j<aux.size();j++) {
				// Si el trabajador del turno actual es igual al buscado
				if(aux.get(j).getTrabajador().equals(trabajador)) {
					// Imprimimos cada atributo
					bw.write("\n--- Turno "+(j+1)+" ---");
					bw.write("\nDia del turno:" + aux.get(j).getDiaTurno());
					bw.write("\nEspecialidad:" + aux.get(j).getEspecialidad());
					bw.write("\nHora inicio:" + aux.get(j).getHoraInicio());
					bw.write("\nHora fin:" + aux.get(j).getHoraFin());
					bw.write("\n");
				}	
			}
		}
		bw.close();
	}
	
	public void reporteTurnosEspecialidad(String especialidad, String nombreArchivo) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo+".txt"));
		bw.write("Turnos asignados a la especialidad "+especialidad+"\n");
		
		for (String i : semana.keySet())
		{
			ArrayList<Turno> aux = semana.get(i).getTurnos();
			
			for(int j = 0;j<aux.size();j++) {
				// Si el trabajador del turno actual es igual al buscado
				if(aux.get(j).getEspecialidad().equals(especialidad)) {
					// Imprimimos cada atributo
					bw.write("\n--- Turno "+(j+1)+" ---");
					bw.write("\nTrabajador:" + aux.get(j).getTrabajador());
					bw.write("\nDia del turno:" + aux.get(j).getDiaTurno());
					bw.write("\nHora inicio:" + aux.get(j).getHoraInicio());
					bw.write("\nHora fin:" + aux.get(j).getHoraFin());
					bw.write("\n");
				}	
			}
		}
		bw.close();
	}
	
	public void reporteTurnosDia(String dia, String nombreArchivo) throws IOException, DiaInvalidoException{
		// Verificamos que exista la clave
		if(semana.containsKey(dia)) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo+".txt"));
			ArrayList<Turno> aux = semana.get(dia).getTurnos();
			bw.write("Turnos asignados al dia "+dia+"\n");
			for(int k = 0;k<aux.size();k++)
			{
				// Imprimimos cada atributo
				bw.write("\n--- Turno "+(k+1)+" ---");
				bw.write("\nTrabajador:" + aux.get(k).getTrabajador());
				bw.write("\nEspecialidad:" + aux.get(k).getEspecialidad());
				bw.write("\nHora inicio:" + aux.get(k).getHoraInicio());
				bw.write("\nHora fin:" + aux.get(k).getHoraFin());
				bw.write("\n");
			}
			bw.close();
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+dia+" no existe!");
		}
	}
	
	public void reporteEspecialidades(String nombreArchivo) throws IOException{
		
	}
}
