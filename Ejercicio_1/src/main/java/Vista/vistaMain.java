package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.EventQueue;
import java.awt.BorderLayout;

public class vistaMain extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public 	JButton btnCrearCliente = new JButton("Crear Cliente");
	public JButton btnVerClientes = new JButton("Ver Clientes");
	public JButton btnEditarCliente = new JButton("Editar Cliente");
	public JButton btnBorrarClientes = new JButton("Borrar Cliente");
	
	private JPanel contentPane;
	public  JTextField tfBorrarCliente = new JTextField();
	private final JLabel lblDNI = new JLabel("DNI:");
	private final JLabel lblID = new JLabel("ID:");

	public vistaMain() {
		tfBorrarCliente.setBounds(180, 140, 100, 20);
		tfBorrarCliente.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu Principal");
		lblTitulo.setBounds(10, 10, 90, 15);
		contentPane.add(lblTitulo);
		

		btnCrearCliente.setBounds(20, 40, 110, 25);
		contentPane.add(btnCrearCliente);	
		
		btnVerClientes.setBounds(20, 70, 110, 25);
		contentPane.add(btnVerClientes);
				
		btnEditarCliente.setBounds(20, 105, 110, 25);
		contentPane.add(btnEditarCliente);
				
		btnBorrarClientes.setBounds(20, 140, 110, 25);
		contentPane.add(btnBorrarClientes);
		contentPane.add(tfBorrarCliente);
		
		contentPane.add(lblDNI);
		lblID.setBounds(150, 145, 45, 15);
		contentPane.add(lblID);
	}

}