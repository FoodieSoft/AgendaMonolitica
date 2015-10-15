import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AgendaMonolitica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JLabel lblUsuario;
	private JLabel lblContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaMonolitica frame = new AgendaMonolitica();
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
	public AgendaMonolitica() {
		setTitle("Agenda Monolitica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(164, 65, 163, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(164, 110, 163, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBounds(121, 167, 97, 25);
			contentPane.add(btnNewButton);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(230, 167, 97, 25);
			contentPane.add(btnCancelar);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(106, 68, 56, 16);
			contentPane.add(lblUsuario);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setBounds(80, 113, 72, 16);
			contentPane.add(lblContrasea);
		}
	}
}
