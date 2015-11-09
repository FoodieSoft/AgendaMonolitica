package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dominio.Contacto;
import dominio.Usuario;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class InterfazGestor extends JFrame {

	private static InterfazGestor frameGestor;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JPanel panelTabla;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JTextField tftNombre;
	private JTextField tftApellidos;
	private JTextField tftDireccion;
	private JTextField tftCorreo;
	private JTextField tftTelefono;
	private JButton btnAadirContacto;
	private JButton btnModificarContacto;
	private JButton btnEliminarContacto;
	private JTable tablaContactos;
	private JLabel lblAvisos;
	private JButton btnBuscarContacto;
	public Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameGestor = new InterfazGestor();
					frameGestor.setVisible(true);
					frameGestor.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	public InterfazGestor() throws SQLException, Exception {
		addWindowListener(new ThisWindowListener());
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfazGestor.class
				.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		setTitle("Agenda - Gestor contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setName("Contactos");
			panel.setBounds(10, 13, 684, 394);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				panelDatos = new JPanel();
				panelDatos.setBounds(409, 24, 263, 355);
				panel.add(panelDatos);
				panelDatos.setLayout(null);
				{
					lblNombre = new JLabel("Nombre");
					lblNombre.setBounds(12, 16, 56, 16);
					panelDatos.add(lblNombre);
				}
				{
					lblApellidos = new JLabel("Apellidos");
					lblApellidos.setBounds(12, 97, 56, 16);
					panelDatos.add(lblApellidos);
				}
				{
					lblDireccion = new JLabel("Direcci\u00F3n");
					lblDireccion.setBounds(12, 174, 56, 16);
					panelDatos.add(lblDireccion);
				}
				{
					lblCorreo = new JLabel("Correo");
					lblCorreo.setBounds(12, 257, 56, 16);
					panelDatos.add(lblCorreo);
				}
				{
					lblTelefono = new JLabel("Tel\u00E9fono");
					lblTelefono.setBounds(12, 326, 56, 16);
					panelDatos.add(lblTelefono);
				}
				{
					tftNombre = new JTextField();
					tftNombre.addFocusListener(new MiFocusListener());
					tftNombre.setToolTipText("Nombre del contacto");
					tftNombre.setBounds(78, 13, 172, 22);
					panelDatos.add(tftNombre);
					tftNombre.setColumns(10);
				}
				{
					tftApellidos = new JTextField();
					tftApellidos.addFocusListener(new MiFocusListener());
					tftApellidos.setToolTipText("Apellidos del contacto");
					tftApellidos.setBounds(78, 91, 172, 22);
					panelDatos.add(tftApellidos);
					tftApellidos.setColumns(10);
				}
				{
					tftDireccion = new JTextField();
					tftDireccion.addFocusListener(new MiFocusListener());
					tftDireccion.setToolTipText("Direccion del contacto");
					tftDireccion.setBounds(78, 171, 172, 22);
					panelDatos.add(tftDireccion);
					tftDireccion.setColumns(10);
				}
				{
					tftCorreo = new JTextField();
					tftCorreo.addFocusListener(new MiFocusListener());
					tftCorreo.setToolTipText("Correo electronico del contacto");
					tftCorreo.setBounds(78, 250, 172, 22);
					panelDatos.add(tftCorreo);
					tftCorreo.setColumns(10);
				}
				{
					tftTelefono = new JTextField();
					tftTelefono.addFocusListener(new MiFocusListener());
					tftTelefono.setToolTipText("Telefono del contacto");
					tftTelefono.setBounds(78, 320, 134, 22);
					panelDatos.add(tftTelefono);
					tftTelefono.setColumns(10);
				}
			}
			{
				panelTabla = new JPanel();
				panelTabla.setBounds(12, 24, 385, 355);
				panel.add(panelTabla);
				panelTabla.setLayout(new BorderLayout(0, 0));
				{
					String[] nombreColumnas = { "Nombre", "Apellidos", "Direccion", "Correo", "Telefono" };

					DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0) {
						@Override
						public boolean isCellEditable(int row, int column) {
							// celdas no editables
							return false;
						}
					};

					tablaContactos = new JTable(modeloTabla);
					tablaContactos.addKeyListener(new TablaContactosKeyListener_1());
					tablaContactos.addMouseListener(new TablaContactosMouseListener_1());
					tablaContactos.setAlignmentY(Component.TOP_ALIGNMENT);
					tablaContactos.setAlignmentX(Component.LEFT_ALIGNMENT);
					tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tablaContactos.setFillsViewportHeight(true);

					JScrollPane scrollPanel = new JScrollPane(tablaContactos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					panelTabla.add(scrollPanel, BorderLayout.CENTER);

				}
			}
		}
		{
			panelBotones = new JPanel();
			panelBotones.setBounds(34, 413, 649, 35);
			contentPane.add(panelBotones);
			panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btnAadirContacto = new JButton("A\u00D1ADIR CONTACTO");
				btnAadirContacto.setToolTipText("A\u00F1adir contacto a la agenda");
				btnAadirContacto.addActionListener(new BtnAadirContactoActionListener());
				panelBotones.add(btnAadirContacto);
			}
			{
				btnModificarContacto = new JButton("MODIFICAR CONTACTO");
				btnModificarContacto.setToolTipText("Modificar el contacto de la agenda");
				btnModificarContacto.addActionListener(new BtnModificarContactoActionListener());
				panelBotones.add(btnModificarContacto);
			}
			{
				btnEliminarContacto = new JButton("ELIMINAR CONTACTO");
				btnEliminarContacto.setToolTipText("Eliminar contacto de la agenda");
				btnEliminarContacto.addActionListener(new BtnEliminarContactoActionListener());
				panelBotones.add(btnEliminarContacto);
			}
			{
				btnBuscarContacto = new JButton("BUSCAR CONTACTO");
				btnBuscarContacto.addActionListener(new BtnBuscarContactoActionListener());
				btnBuscarContacto.setToolTipText("Buscar contacto en la agenda");
				panelBotones.add(btnBuscarContacto);
			}
		}
		{
			lblAvisos = new JLabel("");
			lblAvisos.setBounds(34, 461, 650, 26);
			contentPane.add(lblAvisos);
			lblAvisos.setBackground(SystemColor.menu);
			lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAvisos.setOpaque(true);
			lblAvisos.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowActivated(WindowEvent arg0) {
			try {
				actualizarTabla();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void windowClosing(WindowEvent e) {
			String[] valores = { "Abrir login", "Salir" };
			int eleccion = JOptionPane.showOptionDialog(frameGestor,
					"¿Desea abrir el login de nuevo o salir de la aplicacion?", "Salir de la aplicacion", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, valores, valores[1]);
			if(eleccion==0){
				Login login = new Login();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		}
	}

	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 250));
		}
	}

	private class TablaContactosMouseListener_1 extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				limpiarCampos();
				tftNombre.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0).toString());
				tftApellidos.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1).toString());
				tftDireccion.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 2).toString());
				tftCorreo.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 3).toString());
				tftTelefono.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 4).toString());
			} catch (Exception e) {

			}
		}
	}

	private class BtnAadirContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				Contacto contacto = new Contacto();
				try {

					int telefono = 0;

					if (!tftTelefono.getText().isEmpty()) {
						telefono = Integer.parseInt(tftTelefono.getText());
					}

					if (contacto.insertarContacto(tftNombre.getText(), tftApellidos.getText(), tftDireccion.getText(),
							telefono, tftCorreo.getText(), usuario) == true) {
						actualizarTabla();
						lblAvisos.setText("Contacto añadido");
						lblAvisos.setBackground(Color.GREEN);
						// limpiarCampos();
					} else {

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					lblAvisos.setText("Ya existe el contacto en la agenda");
					lblAvisos.setBackground(Color.RED);
				}

			}
		}
	}

	private class BtnModificarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				Contacto contacto = new Contacto();

				try {
					int telefono = 0;

					if (!tftTelefono.getText().isEmpty()) {
						telefono = Integer.parseInt(tftTelefono.getText());
					}

					if (contacto.modificarContacto(tftNombre.getText(), tftApellidos.getText(), tftDireccion.getText(),
							telefono, tftCorreo.getText(), usuario) == true) {
						actualizarTabla();
						lblAvisos.setText("Contacto modificado");
						lblAvisos.setBackground(Color.GREEN);
						// limpiarCampos();

					} else {

					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					lblAvisos.setText(ex.getLocalizedMessage());
					lblAvisos.setBackground(Color.RED);
				}
			}

		}
	}

	private class BtnEliminarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				Contacto contacto = new Contacto();

				try {

					int eleccion = JOptionPane.showOptionDialog(frameGestor,
							"¿Seguro que quieres eliminar el contacto?", "Eliminar contacto", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (eleccion == 0) {
						if (contacto.eliminarContacto(tftNombre.getText(), tftApellidos.getText(), usuario) == true) {
							actualizarTabla();
							lblAvisos.setText("Contacto eliminado");
							lblAvisos.setBackground(Color.GREEN);
							limpiarCampos();

						} else {
							lblAvisos.setText("Contacto no eliminado");
							lblAvisos.setBackground(Color.RED);

						}
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					lblAvisos.setText(ex.getLocalizedMessage());
					lblAvisos.setBackground(Color.RED);
				}
			}
		}
	}

	private class BtnBuscarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				Contacto contacto = new Contacto();

				try {

					Vector<Contacto> contactoBuscar = contacto.buscarContacto(tftNombre.getText(),
							tftApellidos.getText(), usuario);

					if (contactoBuscar.size() != 0) {
						actualizarTabla();
						lblAvisos.setText("Contacto encontrado");
						lblAvisos.setBackground(Color.GREEN);

						tftDireccion.setText(contactoBuscar.elementAt(0).getDireccion());
						tftTelefono.setText(Integer.toString(contactoBuscar.elementAt(0).getTelefono()));
						tftCorreo.setText(contactoBuscar.elementAt(0).getCorreoE());

					} else {
						lblAvisos.setText("Contacto no encontrado");
						lblAvisos.setBackground(Color.RED);

					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					lblAvisos.setText(ex.getLocalizedMessage());
					lblAvisos.setBackground(Color.RED);
				}
			}
		}
	}

	private class TablaContactosKeyListener_1 extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			limpiarCampos();
			tftNombre.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0).toString());
			tftApellidos.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1).toString());
			tftDireccion.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 2).toString());
			tftCorreo.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 3).toString());
			tftTelefono.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 4).toString());
		}
	}

	private void actualizarTabla() throws SQLException, Exception {

		String[] nombreColumnas = { "Nombre", "Apellidos", "Direccion", "Correo", "Telefono" };
		@SuppressWarnings("serial")
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// celdas no editables
				return false;
			}
		};

		Contacto contacto = new Contacto();
		Vector<Contacto> contactos = contacto.leerContactos(usuario);

		for (int i = 0; i < contactos.size(); i++) {

			Object[] data = { contactos.elementAt(i).getNombre(), contactos.elementAt(i).getApellidos(),
					contactos.elementAt(i).getDireccion(), contactos.elementAt(i).getCorreoE(),
					contactos.elementAt(i).getTelefono() };
			modeloTabla.addRow(data);
		}
		tablaContactos.setModel(modeloTabla);

	}

	private void limpiarCampos() {
		tftNombre.setText(null);
		tftApellidos.setText(null);
		tftDireccion.setText(null);
		tftCorreo.setText(null);
		tftTelefono.setText(null);
	}
}
