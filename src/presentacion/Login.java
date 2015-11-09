package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import dominio.Usuario;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

	private static Login frame = new Login();
	private JPanel contentPane;
	private JTextField tftUsuario;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JPasswordField tftContrasena;
	private JLabel lblInfo;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		setTitle("Agenda - Login");
		setResizable(false);
		setBounds(100, 100, 472, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			tftUsuario = new JTextField();
			tftUsuario.addFocusListener(new TftUsuarioFocusListener());
			tftUsuario.addActionListener(new TftUsuarioActionListener());
			tftUsuario.setToolTipText("Introducir el usuario para acceder a la agenda");
			tftUsuario.setBounds(259, 48, 164, 22);
			contentPane.add(tftUsuario);
			tftUsuario.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setToolTipText("Acceder a la agenda");
			btnAceptar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					// Comprobamos que los campos id y contraseña no esten
					// vacios
					if (String.valueOf(tftContrasena.getPassword()).isEmpty() || tftUsuario.getText().isEmpty()) {
						lblInfo.setText("Introduzca su usuario y contraseña");
						lblInfo.setBackground(Color.RED);

					} else {

						// Creamos un usuario con un nombre y una contraseña
						Usuario usuario = new Usuario(tftUsuario.getText(), tftContrasena.getText());

						try {

							// Buscamos ese usuario en la base de datos
							if (usuario.autenticar() == true) {

								// Creamos otra ventana con el gestor de
								// contactos
								InterfazGestor gestor = new InterfazGestor();
								gestor.setVisible(true);
								gestor.setLocationRelativeTo(null);
								gestor.usuario = usuario;

								// Cerramos el login
								frame.dispose();

							} else {

								lblInfo.setText("Usuario o contraseña incorrecta");
								lblInfo.setBackground(Color.RED);

							}

						} catch (Exception e) {
							lblInfo.setText("Usuario o contraseña incorrecta");
							lblInfo.setBackground(Color.RED);
							System.out.println(e.getMessage());
						}

					}
				}
			});
			btnAceptar.setBounds(165, 192, 120, 40);
			contentPane.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setToolTipText("Salir del login");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(303, 192, 120, 40);
			contentPane.add(btnCancelar);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUsuario.setBounds(191, 50, 56, 16);
			contentPane.add(lblUsuario);
		}
		{
			lblContrasena = new JLabel("Contrase\u00F1a");
			lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblContrasena.setBounds(165, 103, 82, 16);
			contentPane.add(lblContrasena);
		}
		{
			tftContrasena = new JPasswordField();
			tftContrasena.addFocusListener(new TftContrasenaFocusListener());
			tftContrasena.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			tftContrasena.setBounds(259, 101, 164, 22);
			contentPane.add(tftContrasena);
		}
		{
			lblInfo = new JLabel("");
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblInfo.setOpaque(true);
			lblInfo.setBounds(165, 139, 258, 40);
			contentPane.add(lblInfo);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("Aplicacion creada por FoodieSoft");
			lblLogo.setIcon(new ImageIcon(Login.class.getResource("/presentacion/logo.png")));
			lblLogo.setBounds(12, 13, 158, 182);
			contentPane.add(lblLogo);
		}
	}

	private class TftUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			tftContrasena.requestFocus();
		}
	}

	private class TftUsuarioFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftUsuario.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftUsuario.setBackground(new Color(250, 250, 250));
		}
	}

	private class TftContrasenaFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			tftContrasena.setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			tftContrasena.setBackground(new Color(250, 250, 250));
		}
	}
}
