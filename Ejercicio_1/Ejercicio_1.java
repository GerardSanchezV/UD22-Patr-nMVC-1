package Controlador;

import java.awt.event.*;
import Controlador.Controlador;
import Modelo.dto.Clientedto;
import Modelo.dao.ClienteModel;
import Vista.vistaCreateCliente;
import Vista.vistaMain;
import Vista.vistaTable;
import Vista.vistaUpdateCliente;


public class Controlador implements ActionListener {

	// Instanciamos los objetos de las clases:
	// Por Conventions, las clases suelen empezar por mayúscula
	 private vistaMain vistaMain1;
	 private vistaCreateCliente vistaCreateCliente1;
	 private vistaTable vistaTable1;
	 private vistaUpdateCliente vistaUpdateCliente1;
	 
	// Instanciamos los modelos DTO y DAO
	 private ClienteModel clienteModel;
	 private Clientedto Clientedto1;

	 
	 // Constructor
	 
	public Controlador(vistaMain viewMain1, vistaCreateCliente viewCreateClient1, vistaTable vistaTable1, vistaUpdateCliente viewUpdateCliente1,
			ClienteModel clienteModel, vistaCreateCliente vistaCreateCliente1) {
		super();
		this.vistaMain1 = viewMain1;
		this.vistaTable1 = vistaTable1;
		this.vistaCreateCliente1 = vistaCreateCliente1;
		this.clienteModel = clienteModel;
	
		
		// Acceder a los botones de la Vista vistaMain
		this.vistaMain1.btnCrearCliente.addActionListener(this);
		this.vistaMain1.btnVerClientes.addActionListener(this);
		this.vistaMain1.btnEditarCliente.addActionListener(this);
		this.vistaMain1.btnBorrarClientes.addActionListener(this);
		this.vistaMain1.btnBorrarClientes.addActionListener(this);
		
		// Utilizar los botones de la vistas en actionPerformed 
		this.vistaCreateCliente1.btnEnviar.addActionListener(this);
		this.vistaTable1.btnSalir.addActionListener(this);
//		this.vistaUpdateCliente1.btnEnviar.addActionListener(this);
		this.vistaTable1.btnBuscarDNI.addActionListener(this);
		this.vistaTable1.btnBuscarID.addActionListener(this);

		
//		this.vistaUpdateCliente1.btnEditar.addActionListener(this);
//		this.vistaUpdateCliente1.buscarClienteDni.addActionListener(this);

		
		

		viewMain1.setVisible(true);
	}



	public void actionPerformed(ActionEvent evento) {
		
		//Botones de vistaMain
		if(evento.getSource()== this.vistaMain1.btnCrearCliente) {
			vistaCreateCliente1.setVisible(true);
			vistaMain1.setVisible(false);
		}
		
		if(evento.getSource()== this.vistaMain1.btnVerClientes) {
			vistaTable1.setVisible(true);
			vistaMain1.setVisible(false);
		}
		
		
		if(evento.getSource()== this.vistaMain1.btnEditarCliente) {
			vistaUpdateCliente1.setVisible(true);
			vistaMain1.setVisible(false);
			
		}
		
		//borrar clientes
		if(evento.getSource()== this.vistaMain1.btnBorrarClientes) {
			clienteModel.deleteOne(vistaMain1.tfBorrarCliente.getText());
			vistaMain1.tfBorrarCliente.setText("");
		}
		
		

		// Botones de vistaTable
		if (evento.getSource() == this.vistaTable1.btnBuscarDNI) {
			vistaTable1.setVisible(true);
			vistaMain1.setVisible(false);
			Clientedto clienteDto = clienteModel.selectOne(vistaTable1.tfBuscarDNI.getText());
			String cliente = "";
			cliente += clienteDto.getNombre();
			cliente += clienteDto.getApellido();
			cliente += clienteDto.getDireccion();
			cliente += clienteDto.getDni();
			vistaTable1.table.setText(cliente);
		}
		
		//crear cliente
		if(evento.getSource()== this.vistaCreateCliente1.btnEnviar) {
			System.out.println("Intentando crear Cliente");
			Clientedto1 = new Clientedto(vistaCreateCliente1.tfNombre.getText(), vistaCreateCliente1.tfApellido.getText(), vistaCreateCliente1.tfDireccion.getText(), vistaCreateCliente1.tfDni.getText(), Integer.parseInt(vistaCreateCliente1.tfFecha.getText()));
			clienteModel.createInsert(Clientedto1);
		}

		//Editar Cliente
		if(evento.getSource()== this.vistaUpdateCliente1.btnEditar) {
			
			System.out.println("Dentro de editar");


			Clientedto cliente =  clienteModel.selectOne(vistaUpdateCliente1.buscarClienteDni.getText());
			
			

			vistaUpdateCliente1.tfNombre.setText(cliente.getNombre());
			vistaUpdateCliente1.tfApellido.setText(cliente.getApellido());
			vistaUpdateCliente1.tfDireccion.setText(cliente.getDireccion());
			vistaUpdateCliente1.tfDni.setText(cliente.getDni());


			
		}
		
		
		//Guardar el objeto editado
		
		if(evento.getSource()== this.vistaUpdateCliente1.btnEnviar) {
			
			Clientedto cliente = new Clientedto(vistaUpdateCliente1.tfNombre.getText(),vistaUpdateCliente1.tfApellido.getText(),vistaUpdateCliente1.tfDireccion.getText(),vistaUpdateCliente1.tfDni.getText(),23);

			clienteModel.createUpdate(cliente);
			
		}
		
		

		
		
	}

}