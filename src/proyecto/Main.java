package proyecto;
import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Turno prueba = new Turno();
		prueba.setTrabajador("aaaa");
		prueba.setEspecialidad("kdsajds");
		prueba.setHoraInicio("11:00");
		prueba.setHoraFin("69:69");
		
		Turno prueba2 = new Turno();
		prueba2.setTrabajador("bbbb");
		prueba2.setEspecialidad("kkkkk");
		prueba2.setHoraInicio("04:20");
		prueba2.setHoraFin("69:69");
		
		
		Dia test = new Dia();
		test.setNombreDia("Lunes");
		
		test.addTurno(prueba);
		test.addTurno(prueba2);
		
		ArrayList<Turno> turnosTest = test.getTurnos();
		
		for (int i = 0; i < turnosTest.size(); i++) {
		      System.out.println("Nombre: "+ turnosTest.get(i).getTrabajador());
		      System.out.println("Especialidad: "+ turnosTest.get(i).getEspecialidad());
		      System.out.println("Hora Inicio: " + turnosTest.get(i).getHoraInicio());
		      System.out.println("Hora Fin: "+ turnosTest.get(i).getHoraFin());
		 }
		
	}

}
