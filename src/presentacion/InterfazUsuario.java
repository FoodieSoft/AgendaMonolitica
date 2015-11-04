package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InterfazUsuario extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazUsuario frame = new InterfazUsuario();
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
	 */
	public InterfazUsuario() {
		addWindowListener(new ThisWindowListener());
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfazUsuario.class
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
			panel.setBounds(12, 29, 705, 458);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				panelDatos = new JPanel();
				panelDatos.setBounds(400, 24, 275, 355);
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
					tftNombre.setBounds(78, 13, 185, 22);
					panelDatos.add(tftNombre);
					tftNombre.setColumns(10);
				}
				{
					tftApellidos = new JTextField();
					tftApellidos.addFocusListener(new TftApellidosFocusListener());
					tftApellidos.setToolTipText("Apellidos del contacto");
					tftApellidos.setBounds(78, 91, 185, 22);
					panelDatos.add(tftApellidos);
					tftApellidos.setColumns(10);
				}
				{
					tftDireccion = new JTextField();
					tftDireccion.addFocusListener(new TftDireccionFocusListener());
					tftDireccion.setToolTipText("Direccion del contacto");
					tftDireccion.setBounds(78, 171, 185, 22);
					panelDatos.add(tftDireccion);
					tftDireccion.setColumns(10);
				}
				{
					tftCorreo = new JTextField();
					tftCorreo.addFocusListener(new TftCorreoFocusListener());
					tftCorreo.setToolTipText("Correo electronico del contacto");
					tftCorreo.setBounds(78, 250, 185, 22);
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
				panelBotones = new JPanel();
				panelBotones.setBounds(26, 392, 649, 35);
				panel.add(panelBotones);
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
			}
			{
				panelTabla = new JPanel();
				panelTabla.setBounds(27, 24, 361, 355);
				panel.add(panelTabla);
				panelTabla.setLayout(new BorderLayout(0, 0));
				{
					String[] nombreColumnas = { "Nombre", "Apellidos", "Direccion", "Correo", "Telefono" };
					Object[][] data = {
							{ "Cristian", "Trapero Mora", "Miguelturra", "critramo@gmail.com", "645123638" },

					};

					DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0);
					tablaContactos = new JTable(modeloTabla);
					tablaContactos.setMinimumSize(new Dimension(200, 0));
					tablaContactos.setAlignmentY(Component.TOP_ALIGNMENT);
					tablaContactos.setAlignmentX(Component.LEFT_ALIGNMENT);
					tablaContactos.addMouseListener(new TablaContactosMouseListener());
					tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tablaContactos.setFillsViewportHeight(true);

					// int[] anchos = {40, 200, 50,100,20};
					// for(int i = 0; i < tablaContactos.getColumnCount(); i++)
					// {
					//
					// tablaContactos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					//
					// }

					JScrollPane scrollPanel = new JScrollPane(tablaContactos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					panelTabla.add(scrollPanel, BorderLayout.CENTER);

				}
			}
			{
				lblAvisos = new JLabel("");
				lblAvisos.setBackground(SystemColor.menu);
				lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblAvisos.setOpaque(true);
				lblAvisos.setHorizontalAlignment(SwingConstants.CENTER);
				lblAvisos.setBounds(25, 432, 650, 26);
				panel.add(lblAvisos);
			}
		}
	}

	private class TablaContactosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
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
				lblAvisos.setText("Contacto añadido");
				lblAvisos.setBackground(Color.GREEN);
			}
		}
	}

	private class BtnModificarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				lblAvisos.setText("Contacto modificado");
				lblAvisos.setBackground(Color.GREEN);
			}

		}
	}

	private class BtnEliminarContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (tftNombre.getText().isEmpty() || tftApellidos.getText().isEmpty()) {
				lblAvisos.setText("Debe de introducir un nombre y un apellido para el contacto");
				lblAvisos.setBackground(Color.RED);

			} else {
				lblAvisos.setText("Contacto eliminado");
				lblAvisos.setBackground(Color.GREEN);
			}

		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			Login frame = new Login();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
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
}
