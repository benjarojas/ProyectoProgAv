package GestionTurnos;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class VentanaMenu extends JFrame {

	public JPanel contentPane;
	public JTextField txtTest;
	public Semana semana;
	private JTabbedPane tabbedPane;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable tableResults;
	private JTextField txtTrabajadorAdd;
	private JTextField txtDiaTurnoAdd;
	private JTextField txtHoraInicioAdd;
	private JTextField txtHoraFinAdd;
	private JLabel lblNewLabel_1_1_4;
	private JTextField txtEspecialidadAdd;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField txtTrabajadorDelete;
	private JLabel lblNewLabel_1_1_5;
	private JTextField txtDiaTurnoDelete;
	private JButton btnEliminarTurno;
	private JPanel panel_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_1_1_6;
	private JLabel lblNewLabel_1_1_7;
	private JLabel lblNewLabel_1_1_8;
	private JTextField txtTrabRep;
	private JTextField txtFileTrabRep;
	private JLabel lblNewLabel_1_1_9;
	private JLabel lblNewLabel_1_1_10;
	private JLabel lblNewLabel_1_1_11;
	private JTextField txtEspRep;
	private JTextField txtFileEspRep;
	private JButton btnGenEspRep;
	private JScrollPane scrollPane_1;
	private JTable tableFilter;
	private JLabel lblTrmino;
	private JTextField txtTerminoFiltro;
	private JButton btnFiltroEsp;
	private JButton btnFiltroTrab;
	private JLabel lblNewLabel_1_1_12;
	private JButton btnCambTrab;
	private JLabel lblNewLabel_1_2;
	private JTextField trabModTrab;
	private JLabel lblNewLabel_1_1_16;
	private JTextField diaModTrab;
	private JLabel lblNewLabel_1_1_17;
	private JTextField nuevoTrabModTrab;
	private JLabel lblNewLabel_1_1_13;
	private JButton btnCambHrInicio;
	private JLabel lblNewLabel_1_3;
	private JTextField trabajadorHrInicio;
	private JLabel lblNewLabel_1_1_14;
	private JTextField diaTurnoHrInicio;
	private JLabel lblNewLabel_1_1_15;
	private JTextField nuevaHrInicio;
	private JLabel lblNewLabel_1_1_18;
	private JButton cambiarHrFin;
	private JLabel lblNewLabel_1_4;
	private JTextField trabHrFin;
	private JLabel lblNewLabel_1_1_19;
	private JTextField diaHrFin;
	private JLabel lblNewLabel_1_1_20;
	private JTextField nuevaHrFin;
	private JLabel lblNewLabel_1_1_21;
	private JButton modEsp;
	private JLabel lblNewLabel_1_5;
	private JTextField trabEsp;
	private JLabel lblNewLabel_1_1_22;
	private JTextField diaEsp;
	private JLabel lblNewLabel_1_1_23;
	private JTextField nuevaEsp;
	private JPanel panel_6;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public VentanaMenu(Semana semana) {
		setTitle("Sistema de Gestión de Turnos");
		
		this.semana = semana;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		String[] columnasListarDia = {"Trabajador","Especialidad","Hora Inicio", "Hora Fin"};
		DefaultTableModel dtm2 = new DefaultTableModel(0, 0);
		String[] columnasFiltroTrab = {"Dia","Especialidad","Hora Inicio", "Hora Fin"};
		String[] columnasFiltroEsp = {"Dia","Trabajador","Hora Inicio", "Hora Fin"};
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(new Dimension(100, 100));
		contentPane.add(tabbedPane);
						
						panel_2 = new JPanel();
						tabbedPane.addTab("Listar Turnos", null, panel_2, null);
						panel_2.setLayout(null);
						
						lblNewLabel = new JLabel("Día a consultar:");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel.setBounds(35, 14, 129, 17);
						panel_2.add(lblNewLabel);
						
						txtTest = new JTextField();
						txtTest.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtTest.setBounds(156, 13, 111, 19);
						panel_2.add(txtTest);
						txtTest.setColumns(10);
						
						JButton btnListarDia = new JButton("Consultar");
						btnListarDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnListarDia.setBounds(35, 41, 232, 21);
						panel_2.add(btnListarDia);
						btnListarDia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									dtm.setRowCount(0);
									dtm.setColumnIdentifiers(columnasListarDia);
									tableResults.setModel(dtm);
									Turno[] turnosDia = semana.getTurnosDia(txtTest.getText());
									for(int row = 0; row < turnosDia.length; row++) {
										 dtm.addRow(new Object[] {turnosDia[row].getTrabajador(),
												 turnosDia[row].getEspecialidad(),
												 turnosDia[row].getHoraInicio(),
												 turnosDia[row].getHoraFin() });
									}
									tableResults.repaint();
								} catch (DiaInvalidoException ex) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								}
							}
						});
						
						separator = new JSeparator();
						separator.setBounds(330, 14, 0, 2);
						panel_2.add(separator);
						
						scrollPane = new JScrollPane();
						scrollPane.setBounds(35, 73, 704, 218);
						panel_2.add(scrollPane);
						
						tableResults = new JTable();
						scrollPane.setViewportView(tableResults);
						
						panel_3 = new JPanel();
						tabbedPane.addTab("Agregar Turno", null, panel_3, null);
						panel_3.setLayout(null);
						
						JLabel lblNewLabel_1_1 = new JLabel("Trabajador:");
						lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1.setBounds(168, 93, 93, 19);
						panel_3.add(lblNewLabel_1_1);
						
						txtTrabajadorAdd = new JTextField();
						txtTrabajadorAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtTrabajadorAdd.setBounds(271, 93, 153, 19);
						panel_3.add(txtTrabajadorAdd);
						txtTrabajadorAdd.setColumns(10);
						
						JLabel lblNewLabel_1_1_1 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_1.setBounds(168, 64, 93, 19);
						panel_3.add(lblNewLabel_1_1_1);
						
						txtDiaTurnoAdd = new JTextField();
						txtDiaTurnoAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtDiaTurnoAdd.setColumns(10);
						txtDiaTurnoAdd.setBounds(271, 64, 153, 19);
						panel_3.add(txtDiaTurnoAdd);
						
						JLabel lblNewLabel_1_1_2 = new JLabel("Hora Inicio:");
						lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_2.setBounds(168, 122, 93, 19);
						panel_3.add(lblNewLabel_1_1_2);
						
						txtHoraInicioAdd = new JTextField();
						txtHoraInicioAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtHoraInicioAdd.setColumns(10);
						txtHoraInicioAdd.setBounds(271, 122, 153, 19);
						panel_3.add(txtHoraInicioAdd);
						
						JLabel lblNewLabel_1_1_3 = new JLabel("Hora Fin:");
						lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_3.setBounds(168, 151, 93, 19);
						panel_3.add(lblNewLabel_1_1_3);
						
						txtHoraFinAdd = new JTextField();
						txtHoraFinAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtHoraFinAdd.setColumns(10);
						txtHoraFinAdd.setBounds(271, 151, 153, 19);
						panel_3.add(txtHoraFinAdd);
						
						JButton btnNewButton = new JButton("Agregar Turno");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Turno nuevoTurno = new Turno(txtDiaTurnoAdd.getText(),
															 txtHoraInicioAdd.getText(),
															 txtHoraFinAdd.getText(),
															 txtTrabajadorAdd.getText(),
															 txtEspecialidadAdd.getText());
								try {
									semana.agregarTurno(txtDiaTurnoAdd.getText(), nuevoTurno);
									showMessageDialog(null, "Turno ingresado correctamente!");
									txtDiaTurnoAdd.setText("");
									 txtHoraInicioAdd.setText("");
									 txtHoraFinAdd.setText("");
									 txtTrabajadorAdd.setText("");
									 txtEspecialidadAdd.setText("");
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								}
							}
						});
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnNewButton.setBounds(168, 209, 256, 33);
						panel_3.add(btnNewButton);
						
						lblNewLabel_1_1_4 = new JLabel("Especialidad:");
						lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_4.setBounds(168, 180, 93, 19);
						panel_3.add(lblNewLabel_1_1_4);
						
						txtEspecialidadAdd = new JTextField();
						txtEspecialidadAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtEspecialidadAdd.setColumns(10);
						txtEspecialidadAdd.setBounds(271, 180, 153, 19);
						panel_3.add(txtEspecialidadAdd);
						
						panel = new JPanel();
						tabbedPane.addTab("Eliminar Turno", null, panel, null);
						panel.setLayout(null);
						
						lblNewLabel_1 = new JLabel("Trabajador:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1.setBounds(141, 105, 93, 19);
						panel.add(lblNewLabel_1);
						
						txtTrabajadorDelete = new JTextField();
						txtTrabajadorDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtTrabajadorDelete.setColumns(10);
						txtTrabajadorDelete.setBounds(244, 105, 153, 19);
						panel.add(txtTrabajadorDelete);
						
						lblNewLabel_1_1_5 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_5.setBounds(141, 76, 93, 19);
						panel.add(lblNewLabel_1_1_5);
						
						txtDiaTurnoDelete = new JTextField();
						txtDiaTurnoDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtDiaTurnoDelete.setColumns(10);
						txtDiaTurnoDelete.setBounds(244, 76, 153, 19);
						panel.add(txtDiaTurnoDelete);
						
						btnEliminarTurno = new JButton("Eliminar Turno");
						btnEliminarTurno.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.eliminarTurnoDia(txtDiaTurnoDelete.getText(), txtTrabajadorDelete.getText());
									showMessageDialog(null, "Turno eliminado correctamente!");
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								} catch (NoEncontradoException e1) {
									showMessageDialog(null, "NoEncontradoException: El trabajador ingresado no existe!");
								} 
							}
						});
						btnEliminarTurno.setActionCommand("");
						btnEliminarTurno.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnEliminarTurno.setBounds(141, 134, 256, 33);
						panel.add(btnEliminarTurno);
						
						panel_1 = new JPanel();
						tabbedPane.addTab("Modificar Turno", null, panel_1, null);
						panel_1.setLayout(null);
						
						lblNewLabel_1_1_12 = new JLabel("Modificar Trabajador");
						lblNewLabel_1_1_12.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_12.setBounds(10, 10, 255, 48);
						panel_1.add(lblNewLabel_1_1_12);
						
						btnCambTrab = new JButton("Cambiar");
						btnCambTrab.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.modificarTrabajador(diaModTrab.getText(), trabModTrab.getText(), nuevoTrabModTrab.getText());

									showMessageDialog(null, "Turno modificado correctamente");
									
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								} catch (NoEncontradoException e1) {
									showMessageDialog(null, "NoEncontradoException: El trabajador ingresado no existe!");
								}
							}
						});
						btnCambTrab.setOpaque(false);
						btnCambTrab.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnCambTrab.setBounds(247, 68, 106, 77);
						panel_1.add(btnCambTrab);
						
						lblNewLabel_1_2 = new JLabel("Trabajador:");
						lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_2.setBounds(20, 90, 93, 19);
						panel_1.add(lblNewLabel_1_2);
						
						trabModTrab = new JTextField();
						trabModTrab.setFont(new Font("Tahoma", Font.PLAIN, 15));
						trabModTrab.setColumns(10);
						trabModTrab.setBounds(123, 90, 114, 19);
						panel_1.add(trabModTrab);
						
						lblNewLabel_1_1_16 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_16.setBounds(20, 61, 93, 19);
						panel_1.add(lblNewLabel_1_1_16);
						
						diaModTrab = new JTextField();
						diaModTrab.setFont(new Font("Tahoma", Font.PLAIN, 15));
						diaModTrab.setColumns(10);
						diaModTrab.setBounds(123, 61, 114, 19);
						panel_1.add(diaModTrab);
						
						lblNewLabel_1_1_17 = new JLabel("Nuevo Trabajador:");
						lblNewLabel_1_1_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_17.setBounds(20, 119, 93, 19);
						panel_1.add(lblNewLabel_1_1_17);
						
						nuevoTrabModTrab = new JTextField();
						nuevoTrabModTrab.setFont(new Font("Tahoma", Font.PLAIN, 15));
						nuevoTrabModTrab.setColumns(10);
						nuevoTrabModTrab.setBounds(123, 119, 114, 19);
						panel_1.add(nuevoTrabModTrab);
						
						lblNewLabel_1_1_13 = new JLabel("Modificar Hora Inicio");
						lblNewLabel_1_1_13.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_13.setBounds(10, 160, 255, 48);
						panel_1.add(lblNewLabel_1_1_13);
						
						btnCambHrInicio = new JButton("Cambiar");
						btnCambHrInicio.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.modificarHoraInicio(diaTurnoHrInicio.getText(), trabajadorHrInicio.getText(), nuevaHrInicio.getText());
									showMessageDialog(null, "Turno modificado correctamente");
									
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								} catch (NoEncontradoException e1) {
									showMessageDialog(null, "NoEncontradoException: El trabajador ingresado no existe!");
								}
							}
						});
						btnCambHrInicio.setOpaque(false);
						btnCambHrInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnCambHrInicio.setBounds(247, 211, 106, 77);
						panel_1.add(btnCambHrInicio);
						
						lblNewLabel_1_3 = new JLabel("Trabajador:");
						lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_3.setBounds(20, 240, 93, 19);
						panel_1.add(lblNewLabel_1_3);
						
						trabajadorHrInicio = new JTextField();
						trabajadorHrInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
						trabajadorHrInicio.setColumns(10);
						trabajadorHrInicio.setBounds(123, 240, 114, 19);
						panel_1.add(trabajadorHrInicio);
						
						lblNewLabel_1_1_14 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_14.setBounds(20, 211, 93, 19);
						panel_1.add(lblNewLabel_1_1_14);
						
						diaTurnoHrInicio = new JTextField();
						diaTurnoHrInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
						diaTurnoHrInicio.setColumns(10);
						diaTurnoHrInicio.setBounds(123, 211, 114, 19);
						panel_1.add(diaTurnoHrInicio);
						
						lblNewLabel_1_1_15 = new JLabel("Nueva Hora:");
						lblNewLabel_1_1_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_15.setBounds(20, 269, 93, 19);
						panel_1.add(lblNewLabel_1_1_15);
						
						nuevaHrInicio = new JTextField();
						nuevaHrInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
						nuevaHrInicio.setColumns(10);
						nuevaHrInicio.setBounds(123, 269, 114, 19);
						panel_1.add(nuevaHrInicio);
						
						lblNewLabel_1_1_18 = new JLabel("Modificar Hora Fin");
						lblNewLabel_1_1_18.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_18.setBounds(363, 10, 255, 48);
						panel_1.add(lblNewLabel_1_1_18);
						
						cambiarHrFin = new JButton("Cambiar");
						cambiarHrFin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.modificarHoraFin(diaHrFin.getText(), trabHrFin.getText(), nuevaHrFin.getText());
									showMessageDialog(null, "Turno modificado correctamente");
									
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								} catch (NoEncontradoException e1) {
									showMessageDialog(null, "NoEncontradoException: El trabajador ingresado no existe!");
								}
							}
						});
						cambiarHrFin.setOpaque(false);
						cambiarHrFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
						cambiarHrFin.setBounds(600, 68, 106, 77);
						panel_1.add(cambiarHrFin);
						
						lblNewLabel_1_4 = new JLabel("Trabajador:");
						lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_4.setBounds(373, 90, 93, 19);
						panel_1.add(lblNewLabel_1_4);
						
						trabHrFin = new JTextField();
						trabHrFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
						trabHrFin.setColumns(10);
						trabHrFin.setBounds(476, 90, 114, 19);
						panel_1.add(trabHrFin);
						
						lblNewLabel_1_1_19 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_19.setBounds(373, 61, 93, 19);
						panel_1.add(lblNewLabel_1_1_19);
						
						diaHrFin = new JTextField();
						diaHrFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
						diaHrFin.setColumns(10);
						diaHrFin.setBounds(476, 61, 114, 19);
						panel_1.add(diaHrFin);
						
						lblNewLabel_1_1_20 = new JLabel("Nueva Hora:");
						lblNewLabel_1_1_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_20.setBounds(373, 119, 93, 19);
						panel_1.add(lblNewLabel_1_1_20);
						
						nuevaHrFin = new JTextField();
						nuevaHrFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
						nuevaHrFin.setColumns(10);
						nuevaHrFin.setBounds(476, 119, 114, 19);
						panel_1.add(nuevaHrFin);
						
						lblNewLabel_1_1_21 = new JLabel("Modificar Especialidad");
						lblNewLabel_1_1_21.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_21.setBounds(363, 153, 255, 48);
						panel_1.add(lblNewLabel_1_1_21);
						
						modEsp = new JButton("Cambiar");
						modEsp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.modificarEspecialidad(diaEsp.getText(), trabEsp.getText(), nuevaEsp.getText());
									showMessageDialog(null, "Turno modificado correctamente");
									
								} catch (DiaInvalidoException e1) {
									showMessageDialog(null, "Error! Día invalido. Recuerde seguir el formato (Ej: Lunes)");
								} catch (NoEncontradoException e1) {
									showMessageDialog(null, "NoEncontradoException: El trabajador ingresado no existe!");
								}
							}
						});
						modEsp.setOpaque(false);
						modEsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
						modEsp.setBounds(600, 211, 106, 77);
						panel_1.add(modEsp);
						
						lblNewLabel_1_5 = new JLabel("Trabajador:");
						lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_5.setBounds(373, 233, 93, 19);
						panel_1.add(lblNewLabel_1_5);
						
						trabEsp = new JTextField();
						trabEsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
						trabEsp.setColumns(10);
						trabEsp.setBounds(476, 233, 114, 19);
						panel_1.add(trabEsp);
						
						lblNewLabel_1_1_22 = new JLabel("Dia del turno:");
						lblNewLabel_1_1_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_22.setBounds(373, 204, 93, 19);
						panel_1.add(lblNewLabel_1_1_22);
						
						diaEsp = new JTextField();
						diaEsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
						diaEsp.setColumns(10);
						diaEsp.setBounds(476, 204, 114, 19);
						panel_1.add(diaEsp);
						
						lblNewLabel_1_1_23 = new JLabel("Nueva Especialidad:");
						lblNewLabel_1_1_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_23.setBounds(373, 262, 93, 19);
						panel_1.add(lblNewLabel_1_1_23);
						
						nuevaEsp = new JTextField();
						nuevaEsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
						nuevaEsp.setColumns(10);
						nuevaEsp.setBounds(476, 262, 114, 19);
						panel_1.add(nuevaEsp);
						
						panel_4 = new JPanel();
						tabbedPane.addTab("Filtrar Turnos", null, panel_4, null);
						panel_4.setLayout(null);
						
						scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(22, 79, 622, 218);
						panel_4.add(scrollPane_1);
						
						tableFilter = new JTable(dtm2);
						scrollPane_1.setViewportView(tableFilter);
						
						lblTrmino = new JLabel("Término:");
						lblTrmino.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblTrmino.setBounds(22, 38, 129, 17);
						panel_4.add(lblTrmino);
						
						txtTerminoFiltro = new JTextField();
						txtTerminoFiltro.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtTerminoFiltro.setColumns(10);
						txtTerminoFiltro.setBounds(89, 37, 165, 19);
						panel_4.add(txtTerminoFiltro);
						
						btnFiltroEsp = new JButton("Filtrar por especialidad");
						btnFiltroEsp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dtm2.setRowCount(0);
								dtm2.setColumnIdentifiers(columnasFiltroEsp);
								tableResults.setModel(dtm);
								Turno[] turnosTrab;
								turnosTrab = semana.filtrarTurnosEspecialidad(txtTerminoFiltro.getText());
								for(int row = 0; row < turnosTrab.length; row++) {
									 dtm2.addRow(new Object[] {turnosTrab[row].getDiaTurno(),
											 turnosTrab[row].getTrabajador(),
											 turnosTrab[row].getHoraInicio(),
											 turnosTrab[row].getHoraFin() });
								}
								tableResults.repaint();
							}
						});
						btnFiltroEsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnFiltroEsp.setBounds(459, 21, 185, 50);
						panel_4.add(btnFiltroEsp);
						
						
						btnFiltroTrab = new JButton("Filtrar por trabajador");
						btnFiltroTrab.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dtm2.setRowCount(0);
								dtm2.setColumnIdentifiers(columnasFiltroTrab);
								tableResults.setModel(dtm);
								Turno[] turnosTrab;
								turnosTrab = semana.filtrarTurnosTrabajador(txtTerminoFiltro.getText());
								for(int row = 0; row < turnosTrab.length; row++) {
									 dtm2.addRow(new Object[] {turnosTrab[row].getDiaTurno(),
											 turnosTrab[row].getEspecialidad(),
											 turnosTrab[row].getHoraInicio(),
											 turnosTrab[row].getHoraFin() });
								}
								tableResults.repaint();
							}
						});
						btnFiltroTrab.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnFiltroTrab.setBounds(264, 21, 186, 50);
						panel_4.add(btnFiltroTrab);
						
						panel_5 = new JPanel();
						tabbedPane.addTab("Generar Reportes", null, panel_5, null);
						panel_5.setLayout(null);
						
						lblNewLabel_1_1_6 = new JLabel("Turnos de un trabajador");
						lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_6.setBounds(33, 40, 255, 48);
						panel_5.add(lblNewLabel_1_1_6);
						
						lblNewLabel_1_1_7 = new JLabel("Trabajador:");
						lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_7.setBounds(43, 90, 93, 19);
						panel_5.add(lblNewLabel_1_1_7);
						
						lblNewLabel_1_1_8 = new JLabel("Nombre Archivo:");
						lblNewLabel_1_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_8.setBounds(43, 122, 122, 19);
						panel_5.add(lblNewLabel_1_1_8);
						
						txtTrabRep = new JTextField();
						txtTrabRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtTrabRep.setBounds(128, 90, 181, 19);
						panel_5.add(txtTrabRep);
						txtTrabRep.setColumns(10);
						
						txtFileTrabRep = new JTextField();
						txtFileTrabRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtFileTrabRep.setColumns(10);
						txtFileTrabRep.setBounds(159, 122, 150, 19);
						panel_5.add(txtFileTrabRep);
						
						JButton btnGenTrabRep = new JButton("Generar");
						btnGenTrabRep.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.reporteTurnosTrabajador(txtTrabRep.getText(), txtFileTrabRep.getText());
									showMessageDialog(null, "Archivo generado correctamente");
								} catch (IOException e1) {
									showMessageDialog(null, "IOException: Error al abrir el archivo");
								}
							}
						});
						btnGenTrabRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnGenTrabRep.setBounds(319, 91, 106, 50);
						panel_5.add(btnGenTrabRep);
						
						lblNewLabel_1_1_9 = new JLabel("Turnos asignados a especialidad");
						lblNewLabel_1_1_9.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_1_1_9.setBounds(33, 170, 337, 48);
						panel_5.add(lblNewLabel_1_1_9);
						
						lblNewLabel_1_1_10 = new JLabel("Especialidad:");
						lblNewLabel_1_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_10.setBounds(43, 220, 93, 19);
						panel_5.add(lblNewLabel_1_1_10);
						
						lblNewLabel_1_1_11 = new JLabel("Nombre Archivo:");
						lblNewLabel_1_1_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_11.setBounds(43, 252, 122, 19);
						panel_5.add(lblNewLabel_1_1_11);
						
						txtEspRep = new JTextField();
						txtEspRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtEspRep.setColumns(10);
						txtEspRep.setBounds(137, 220, 172, 19);
						panel_5.add(txtEspRep);
						
						txtFileEspRep = new JTextField();
						txtFileEspRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						txtFileEspRep.setColumns(10);
						txtFileEspRep.setBounds(159, 252, 150, 19);
						panel_5.add(txtFileEspRep);
						
						btnGenEspRep = new JButton("Generar");
						btnGenEspRep.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.reporteTurnosEspecialidad(txtEspRep.getText(), txtFileEspRep.getText());
									showMessageDialog(null, "Archivo generado correctamente");
								} catch (IOException e1) {
									showMessageDialog(null, "IOException: Error al abrir el archivo");
								}
							}
						});
						btnGenEspRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnGenEspRep.setBounds(319, 221, 106, 50);
						panel_5.add(btnGenEspRep);
						
						panel_6 = new JPanel();
						tabbedPane.addTab("Salir y guardar", null, panel_6, null);
						panel_6.setLayout(null);
						
						btnNewButton_1 = new JButton("Salir y guardar");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									semana.guardarCambios();
									System.exit(0);
								} catch (IOException e1) {
									showMessageDialog(null, "Error al abrir el archivo 'turnosEnfermeras.txt'");
								}
							}
						});
						btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
						btnNewButton_1.setBounds(244, 100, 199, 83);
						panel_6.add(btnNewButton_1);
	}
}
