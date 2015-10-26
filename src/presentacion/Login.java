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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private final String password = "iso";
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
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			tftUsuario = new JTextField();
			tftUsuario.addFocusListener(new TftUsuarioFocusListener());
			tftUsuario.addActionListener(new TftUsuarioActionListener());
			tftUsuario.setToolTipText("Introducir el usuario para acceder a la agenda");
			tftUsuario.setBounds(251, 65, 163, 22);
			contentPane.add(tftUsuario);
			tftUsuario.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setToolTipText("Acceder a la agenda");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (String.valueOf(tftContrasena.getPassword()).isEmpty() || tftUsuario.getText().isEmpty()) {
						lblInfo.setText("Introduccir usuario y contrase�a");
						lblInfo.setBackground(Color.RED);
						
					} else {
						if (String.valueOf(tftContrasena.getPassword()).toString().equals(password)) {
							

							
							
							Usuario usuario= new Usuario(lblUsuario.getText(),lblContrasena.getText());
							
							try{
								//Miramos si podemos acceder al gestor mirando en la tabla usuarios
								
							}catch(Exception e){
								
							}
							
							lblInfo.setText("Dentro");
							lblInfo.setBackground(Color.GREEN);
							//Creamos otra ventana con el gestor
							GestorUsuario gestor = new GestorUsuario();
							gestor.setVisible(true);
							gestor.setLocationRelativeTo(null);
											
							//Cerramos el login
							frame.dispose();
																						
						
						} else {
							lblInfo.setText("Contrase�a incorrecta");
							lblInfo.setBackground(Color.RED);
						}
					}
				}
			});
			btnAceptar.setBounds(167, 195, 109, 37);
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
			btnCancelar.setBounds(305, 195, 109, 37);
			contentPane.add(btnCancelar);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(167, 68, 56, 16);
			contentPane.add(lblUsuario);
		}
		{
			lblContrasena = new JLabel("Contrase\u00F1a");
			lblContrasena.setBounds(167, 113, 72, 16);
			contentPane.add(lblContrasena);
		}
		{
			tftContrasena = new JPasswordField();
			tftContrasena.addFocusListener(new TftContrasenaFocusListener());
			tftContrasena.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			tftContrasena.setBounds(251, 110, 163, 22);
			contentPane.add(tftContrasena);
		}
		{
			lblInfo = new JLabel("");
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblInfo.setOpaque(true);
			lblInfo.setBounds(167, 142, 247, 40);
			contentPane.add(lblInfo);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("Aplicacion creada por FoodieSoft");
			lblLogo.setIcon(new ImageIcon(Login.class.getResource("/presentacion/logo.png")));
			lblLogo.setBounds(12, 13, 138, 182);
			contentPane.add(lblLogo);
		}
	}

	private class TftUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			tftContrasena.enable();
			tftContrasena.requestFocus();
		}
	}
	private class TftUsuarioFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
		tftUsuario.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
		tftUsuario.setBackground(new Color(250,250,250));
		}
	}
	private class TftContrasenaFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
		tftContrasena.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
		tftContrasena.setBackground(new Color(250,250,250));
		}
	}
}
