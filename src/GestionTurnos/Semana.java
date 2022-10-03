package GestionTurnos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Semana {
	private HashMap<String, Dia> semana;
	
	public Semana() {
		semana = new HashMap<>();
		semana.put("Lunes", new Dia("Lunes")); // La clave del cada elemento es un string con su nombre y el valor es un objeto de tipo Dia
		semana.put("Martes", new Dia("Martes")); // el objeto Dia se construye con su nombre respectivo
		semana.put("Miercoles", new Dia("Miercoles"));
		semana.put("Jueves", new Dia("Jueves"));
		semana.put("Viernes", new Dia("Viernes"));
		semana.put("Sabado", new Dia("Sabado"));
		semana.put("Domingo", new Dia("Domingo"));
	}
	
	public void leerArchivoTurnos() throws IOException, DiaInvalidoException
	{
		String txtLine;
		BufferedReader txtRead = new BufferedReader(new FileReader("turnosEnfermeras.txt"));
		while((txtLine = txtRead.readLine()) != null)
		{
			// El primer String del arreglo corresponde al nombre del Día del turno
			// El resto de los Strings corresponden a los detalles (horas, nombre y especialidad)
			String[] arrayTurno = txtLine.split(",", 5);
			Turno turnoCargar = new Turno(arrayTurno[0], arrayTurno[1], arrayTurno[2], arrayTurno[3], arrayTurno[4]);
			agregarTurno(arrayTurno[0], turnoCargar);
		}
		txtRead.close();
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
	
	public Turno[] getTurnosDia(String clave) throws DiaInvalidoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			return semana.get(clave).getTurnos();
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	public Turno[] filtrarTurnosTrabajador(String trabajador)
	{
		ArrayList<Turno> turnosFiltrados = new ArrayList<Turno>();
		for (String i : semana.keySet())
		{
			Turno[] turnosDia = semana.get(i).getTurnos();
			for(int j=0;j<turnosDia.length;j++)
			{
				if(turnosDia[j].getTrabajador().equals(trabajador))
				{
					turnosFiltrados.add(turnosDia[j]);
				}
			}
		}
		Turno[] arrayTurnos = new Turno[turnosFiltrados.size()];
        arrayTurnos = turnosFiltrados.toArray(arrayTurnos);
        return arrayTurnos;
	}

	public Turno[] filtrarTurnosEspecialidad(String especialidad)
	{
		ArrayList<Turno> turnosFiltrados = new ArrayList<Turno>();
		for (String i : semana.keySet())
		{
			Turno[] turnosDia = semana.get(i).getTurnos();
			for(int j=0;j<turnosDia.length;j++)
			{
				if(turnosDia[j].getEspecialidad().equals(especialidad))
				{
					turnosFiltrados.add(turnosDia[j]);
				}
			}
		}
		Turno[] arrayTurnos = new Turno[turnosFiltrados.size()];
        arrayTurnos = turnosFiltrados.toArray(arrayTurnos);
        return arrayTurnos;
	}
	
	// Este método elimina un Turno de un día del HashMap semana
	public void eliminarTurnoDia(String clave,String nombreTrabajador) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			if(!semana.get(clave).eliminarTurno(nombreTrabajador))
			{
				throw new NoEncontradoException("El trabajador "+nombreTrabajador+" no existe!");
			}
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	
	public void modificarTrabajador(String clave,String nombreTrabajador,String nuevoTrabajador) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).modificarTrabajadorTurno(clave, nombreTrabajador, nuevoTrabajador);
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	public void modificarEspecialidad(String clave,String nombreTrabajador,String nuevaEspecialidad) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).modificarEspecialidadTurno(clave, nombreTrabajador, nuevaEspecialidad);
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}
	
	public void modificarHoraInicio(String clave,String nombreTrabajador,String nuevaHoraInicio) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).modificarHoraInicioTurno(clave, nombreTrabajador, nuevaHoraInicio);
		} else {
			// Lanzamos una excepción propia DiaInvalidoException
			throw new DiaInvalidoException("El día "+clave+" no existe!");
		}
	}

	
	public void modificarHoraFin(String clave,String nombreTrabajador,String nuevaHoraFin) throws DiaInvalidoException, NoEncontradoException
	{
		// Verificamos que exista la clave
		if(semana.containsKey(clave)) {
			semana.get(clave).modificarHoraFinTurno(clave, nombreTrabajador, nuevaHoraFin);
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
			Turno[] aux = semana.get(i).getTurnos(); // Obtenemos todos los turnos del día
			// Recorremos todo el ArrayList de Turnos
			for(int k = 0;k<aux.length;k++)
			{
				// Imprimimos cada atributo
				bw.write(i);
				bw.write(",");
				bw.write(aux[k].getHoraInicio());
				bw.write(",");
				bw.write(aux[k].getHoraFin());
				bw.write(",");
				bw.write(aux[k].getTrabajador());
				bw.write(",");
				bw.write(aux[k].getEspecialidad());
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
			Turno[] aux = semana.get(i).getTurnos();
			
			for(int j = 0;j<aux.length;j++) {
				// Si el trabajador del turno actual es igual al buscado
				if(aux[j].getTrabajador().equals(trabajador)) {
					// Imprimimos cada atributo
					bw.write("\n--- Turno "+(j+1)+" ---");
					bw.write("\nDia del turno:" + aux[j].getDiaTurno());
					bw.write("\nEspecialidad:" + aux[j].getEspecialidad());
					bw.write("\nHora inicio:" + aux[j].getHoraInicio());
					bw.write("\nHora fin:" + aux[j].getHoraFin());
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
			Turno[] aux = semana.get(i).getTurnos();
			
			for(int j = 0;j<aux.length;j++) {
				// Si el trabajador del turno actual es igual al buscado
				if(aux[j].getEspecialidad().equals(especialidad)) {
					// Imprimimos cada atributo
					bw.write("\n--- Turno "+(j+1)+" ---");
					bw.write("\nTrabajador:" + aux[j].getTrabajador());
					bw.write("\nDia del turno:" + aux[j].getDiaTurno());
					bw.write("\nHora inicio:" + aux[j].getHoraInicio());
					bw.write("\nHora fin:" + aux[j].getHoraFin());
					bw.write("\n");
				}	
			}
		}
		bw.close();
	}
	
}
