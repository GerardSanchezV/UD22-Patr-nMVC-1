package Modelo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.ConexionDB.ConexionDB;
import Modelo.dto.Clientedto;

public class ClienteModel {

	ConexionDB conexionMysql = new ConexionDB();


	public void createInsert(Clientedto cliente) {
		try {
			Connection conexion = conexionMysql.crearConexion();
			String Querydb = "USE cliente;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "INSERT INTO cliente (nombre,apellido,direccion,dni,fecha)VALUES('" + cliente.getNombre() + "','"
					+ cliente.getApellido() + "','" + cliente.getDireccion() + "'," + cliente.getDni() + ",'" + cliente.getFecha() + "')";
			Statement st = conexion.createStatement();
			System.out.println(Query);
			st.executeUpdate(Query);
			conexion.close();
			System.out.println("Inserts  creados  con exito!");
		} catch (SQLException e) {
			System.out.println("No se a podido crear los inserts en la tabla! ");
			System.out.println(e);
		}
	}

	
	
	
	public void createUpdate(Clientedto cliente) {
		try {
			Connection conexion = conexionMysql.crearConexion();
			String Querydb = "USE cliente;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "UPDATE cliente SET NOMBRE ='"+cliente.getNombre()+"',APELLIDO='"+cliente.getApellido()+"',DIRECCION='"+cliente.getDireccion()+"', DNI ="+cliente.getDni()+" , FECHA="+cliente.getFecha()+" WHERE dni="+cliente.getDni()+"";
			System.out.println(Query);

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			conexion.close();
			System.out.println("Inserts  creados  con exito!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se a podido crear los inserts en la tabla ");
			System.out.println(e);
		}
	}

	// Mostrar 1
	
		public Clientedto selectOne(String id) {
			Clientedto cliente = new Clientedto();

			try {
				Connection conexion = conexionMysql.crearConexion();
				String Querydb = "USE clientevideo;";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query = "SELECT *  FROM cliente WHERE dni ='"+id+"';";;
				System.out.println(Query);
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet  = st.executeQuery(Query);
				
				
				while (resultSet.next())
			      {
					System.out.println("ID:"+resultSet.getString("id") + " "
							+ "Nombre: " + resultSet.getString("nombre")+ " "
							+ "Apellido: " + resultSet.getString("apellido")+ " "
							+ "Direccion: " + resultSet.getString("direccion")+ " "
							+ "DNI: " + resultSet.getString("dni")+ " "
							+ "Fecha: " + resultSet.getString("fecha")+ " "
							);
				
				
					String nomSelect = resultSet.getString("nombre");
					String apellidoSelect = resultSet.getString("apellido");
					String direccionSelect = resultSet.getString("direccion");
					String dniSelect = resultSet.getString("dni");
					int fechaSelect = Integer.parseInt(resultSet.getString("fecha"));

					cliente = new Clientedto (nomSelect,apellidoSelect,direccionSelect,dniSelect,fechaSelect);
			      }
				
				
				System.out.println(cliente);
				conexion.close();
				System.out.println("Select Correcto!");
				return cliente;

			} catch (SQLException e) {
				System.out.println("Select Incorrecto!");
				System.out.println(e);
				return null;

			}
		}
	
	
	// Mostrar tabla
	
	public void selectDB() {
		try {
			Connection conexion = conexionMysql.crearConexion();
			String Querydb = "USE cliente;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT * FROM cliente";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet  = st.executeQuery(Query);
			
			
			while (resultSet.next())
		      {
				System.out.println("ID:"+resultSet.getString("id") + " "
						+ "Nombre: " + resultSet.getString("nombre")+ " "
						+ "Apellido: " + resultSet.getString("apellido")+ " "
						+ "Direccion: " + resultSet.getString("direccion")+ " "
						+ "DNI: " + resultSet.getString("dni")+ " "
						+ "Fecha: " + resultSet.getString("fecha")+ " "
						);
		      }
			
			
		
			conexion.close();
			System.out.println("Select Correcto!");
		} catch (SQLException e) {
			System.out.println("Select Incorrecto!");
			System.out.println(e);
		}
	}
	
	
	
	// Borrar  1
	
		public void deleteOne(String id) {
			try {
				Connection conexion = conexionMysql.crearConexion();
				String Querydb = "USE cliente;";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query = "DELETE FROM cliente WHERE dni ='"+id+"';";
				Statement st = conexion.createStatement();
				System.out.println(Querydb);
				st.executeUpdate(Query);

				conexion.close();
				System.out.println("Se ha borrado el registro con exito!");
			} catch (SQLException e) {
				System.out.println("No se a podido borrar el registro.");
				System.out.println(e);
			}
		}


	
	
	
	
	
	
	
}