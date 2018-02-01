package com.geekspain.dao;

import static org.mockito.Matchers.anyList;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geekspain.entities.Empleado;


@Repository
public class EmpleadoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void crearEmpleado(Empleado empleado) {
		
		Session session= null;
		try {
			session=sessionFactory.openSession();
			session.beginTransaction();
			
			Integer id= (Integer) session.save(empleado);
			System.out.println("se crea empleado con Id: "+id);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		List<Empleado> lista = null;
		Session session= null;
		try {
			session=sessionFactory.openSession();
			session.beginTransaction();
			
			 lista = session.createQuery("from "+Empleado.class.getName()).list();
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lista;
	}


	public Empleado buscarEmpleado(int id) {
		// TODO Auto-generated method stub
		Empleado empleado = null;
		Session session= null;
		try {
			session=sessionFactory.openSession();
			session.beginTransaction();
			
			 empleado = session.get(Empleado.class, id);
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return empleado;
	}
}