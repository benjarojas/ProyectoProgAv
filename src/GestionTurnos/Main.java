package GestionTurnos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.WindowConstants;

// Guardamos la información al salir de la aplicación
class WindowEventHandler extends WindowAdapter {
	private Semana semana;
	public WindowEventHandler(Semana semana)
	{
		this.semana = semana;
	}
	
	public void windowClosing(WindowEvent evt) {
		try {
			semana.guardarCambios();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class Main {

	public static void main(String[] args)
	{
		Semana semana = new Semana();
		try {
			semana.leerArchivoTurnos();
		} catch (IOException | DiaInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VentanaMenu ventanaPrincipal = new VentanaMenu(semana);
		
		ventanaPrincipal.addWindowListener(new WindowEventHandler(semana));
	    ventanaPrincipal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		ventanaPrincipal.setVisible(true);
	}
	
}
