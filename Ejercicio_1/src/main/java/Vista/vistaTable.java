package Vista;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class vistaTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField table = new JTextField();
	public JButton btnBuscarDNI = new JButton("Buscar DNI");
	public JTextField tfBuscarDNI = new JTextField();
	public JButton btnBuscarID = new JButton("Buscar ID");
	public JTextField tfBuscarID = new JTextField();
	public JButton btnSalir = new JButton("Salir");


	public vistaTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnSalir.setBounds(337, 305, 89, 23);
		contentPane.add(btnSalir);
		
		tfBuscarDNI = new JTextField();
		tfBuscarDNI.setBounds(105, 246, 96, 19);
		contentPane.add(tfBuscarDNI);
		tfBuscarDNI.setColumns(10);
		
		
		btnBuscarDNI.setBounds(10, 245, 85, 21);
		contentPane.add(btnBuscarDNI);
		
		
		table.setBounds(10, 10, 416, 207);
		contentPane.add(table);
		table.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 275, 191, 3);
		contentPane.add(separator);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(20, 222, 45, 20);
		contentPane.add(lblPersona);
		
	}
}