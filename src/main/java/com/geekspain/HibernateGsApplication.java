package com.geekspain;



import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geekspain.dao.EmpleadoDAO;
import com.geekspain.entities.Empleado;

@SpringBootApplication
public class HibernateGsApplication implements CommandLineRunner {

	@Autowired
	private EmpleadoDAO empleadoDao;
	static String respuesta=null;
	static int id;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateGsApplication.class, args);


	}
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Empleado empleado= getEmpleado();
		empleadoDao.crearEmpleado(empleado);
		System.setProperty("java.awt.headless", "false");

		JFrame venta= new JFrame("ventana");
		venta.setBounds(50, 50, 500, 500);
		venta.setVisible(true);
		venta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		respuesta=JOptionPane.showInputDialog(venta,"especifique id busqueda:",JOptionPane.QUESTION_MESSAGE);
		
		 id= Integer.parseInt(respuesta);

		//llamo al método DAO que lista empleados
		ArrayList<Empleado> empleados = (ArrayList<Empleado>) empleadoDao.listarEmpleados();
		
		
		
		imprimirEmpleados(empleados);
		
				
		Empleado e = empleadoDao.buscarEmpleado(id);
		
				System.out.println("el id: "+id+" corresponde a:"+e.toString());
		
	}
	
	
	
	private void imprimirEmpleados(ArrayList<Empleado> empleados) {
		for(Empleado e: empleados) {
			System.out.println(e.toString());
		}
	}
	private Empleado getEmpleado() {
		Empleado e= new Empleado();
		e.setNombre("Belarmino");
		e.setSalario(3400.00);
		e.setFdi(new Date());
		return e;
	}

}
