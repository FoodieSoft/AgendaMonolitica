package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import dominio.Contacto;
import dominio.Usuario;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.AbstractListModel;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.DropMode;

public class InterfazGestor extends JFrame {

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
					InterfazGestor frame = new InterfazGestor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

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
					tftNombre.addFocusListener(new TftNombreFocusListener());
					tftNombre.setToolTipText("Nombre del contacto");
					tftNombre.setBounds(78, 13, 172, 22);
					panelDatos.add(tftNombre);
					tftNombre.setColumns(10);
				}
				{
					tftApellidos = new JTextField();
					tftApellidos.addFocusListener(new TftApellidosFocusListener());
					tftApellidos.setToolTipText("Apellidos del contacto");
					tftApellidos.setBounds(78, 91, 172, 22);
					panelDatos.add(tftApellidos);
					tftApellidos.setColumns(10);
				}
				{
					tftDireccion = new JTextField();
					tftDireccion.addFocusListener(new TftDireccionFocusListener());
					tftDireccion.setToolTipText("Direccion del contacto");
					tftDireccion.setBounds(78, 171, 172, 22);
					panelDatos.add(tftDireccion);
					tftDireccion.setColumns(10);
				}
				{
					tftCorreo = new JTextField();
					tftCorreo.addFocusListener(new TftCorreoFocusListener());
					tftCorreo.setToolTipText("Correo electronico del contacto");
					tftCorreo.setBounds(78, 250, 172, 22);
					panelDatos.add(tftCorreo);
					tftCorreo.setColumns(10);
				}
				{
					tftTelefono = new JTextField();
					tftTelefono.addFocusListener(new TftTelefonoFocusListener());
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

					DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0);

					tablaContactos = new JTable(modeloTabla);
					tablaContactos.addKeyListener(new TablaContactosKeyListener());
					tablaContactos.addMouseListener(new TablaContactosMouseListener_1());
					tablaContactos.setShowHorizontalLines(false);
					tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tablaContactos.setFocusable(false);
					tablaContactos.setFocusTraversalKeysEnabled(false);
					tablaContactos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

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

	private class TablaContactosMouseListener extends MouseAdapter {
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
				// System.out.println("nova"+e.toString());
			}
		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			// Login frame = new Login();
			// frame.setVisible(true);
			// frame.setLocationRelativeTo(null);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
			try {
				actualizarTabla();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class TftNombreFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftNombre.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftNombre.setBackground(new Color(250, 250, 250));
		}
	}

	private class TftApellidosFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftApellidos.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftApellidos.setBackground(new Color(250, 250, 250));
		}
	}

	private class TftDireccionFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftDireccion.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftDireccion.setBackground(new Color(250, 250, 250));
		}
	}

	private class TftCorreoFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftCorreo.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftCorreo.setBackground(new Color(250, 250, 250));
		}
	}

	private class TftTelefonoFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftTelefono.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftTelefono.setBackground(new Color(250, 250, 250));
		}
	}

	private class TablaContactosMouseListener_1 extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			limpiarCampos();
			tftNombre.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0).toString());
			tftApellidos.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1).toString());
			tftDireccion.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 2).toString());
			tftCorreo.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 3).toString());
			tftTelefono.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 4).toString());
		}
	}

	private class TablaContactosKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {

			limpiarCampos();
			tftNombre.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0).toString());
			tftApellidos.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1).toString());
			tftDireccion.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 2).toString());
			tftCorreo.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 3).toString());
			tftTelefono.setText(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 4).toString());
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
					
					int telefono=0;
					
					if(!tftTelefono.getText().isEmpty()){
						telefono=Integer.parseInt(tftTelefono.getText());
					}

					if (contacto.insertarContacto(tftNombre.getText(), tftApellidos.getText(), tftDireccion.getText(),
							telefono, tftCorreo.getText(), usuario) == true) {
						actualizarTabla();
						lblAvisos.setText("Contacto añadido");
						lblAvisos.setBackground(Color.GREEN);
						//limpiarCampos();
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
					int telefono=0;
					
					if(!tftTelefono.getText().isEmpty()){
						telefono=Integer.parseInt(tftTelefono.getText());
					}

					if (contacto.modificarContacto(tftNombre.getText(), tftApellidos.getText(), tftDireccion.getText(),
							telefono, tftCorreo.getText(), usuario) == true) {
						actualizarTabla();
						lblAvisos.setText("Contacto modificado");
						lblAvisos.setBackground(Color.GREEN);
						//limpiarCampos();

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

					if (contacto.eliminarContacto(tftNombre.getText(), tftApellidos.getText(), usuario) == true) {
						actualizarTabla();
						lblAvisos.setText("Contacto eliminado");
						lblAvisos.setBackground(Color.GREEN);
						limpiarCampos();

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

	private class BtnBuscarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				Contacto contacto = new Contacto();

				try {

					Vector<Contacto> contactoBuscar = contacto.buscarContacto(tftNombre.getText(), tftApellidos.getText(), usuario);

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

	private void actualizarTabla() throws SQLException, Exception {

		String[] nombreColumnas = { "Nombre", "Apellidos", "Direccion", "Correo", "Telefono" };
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0);

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
