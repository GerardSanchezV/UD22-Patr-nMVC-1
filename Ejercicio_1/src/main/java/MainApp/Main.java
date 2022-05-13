package MainApp;

import Controlador.Controlador;
import Modelo.dao.ClienteModel;
import Vista.vistaCreateCliente;
import Vista.vistaMain;
import Vista.vistaTable;
import Vista.vistaUpdateCliente;


public class Main {
	public static void main(String[] args) {
		vistaMain vistaMain1 = new vistaMain();
		vistaCreateCliente vistaCreateCliente1 = new vistaCreateCliente();
		vistaTable vistaTable1 = new vistaTable();
		vistaUpdateCliente vistaUpdateCliente1 = new vistaUpdateCliente();;
		ClienteModel clienteModel = new ClienteModel();
		new Controlador(vistaMain1, vistaCreateCliente1, vistaTable1, vistaUpdateCliente1, clienteModel, vistaCreateCliente1);
	}
}