package com.nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nikhil.model.Employee;
import com.nikhil.util.HibernateUtil;

public class TestConnectApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Employee employee = null;
		int id = 18;

		try {
			if (session != null)
				employee = session.load(Employee.class, id);

			System.out.println(session.load(Employee.class, employee.getEmpId()));
			
		} catch (HibernateException e) {
			System.out.println(employee);
			System.out.println("Employee record not found for the given id :: " + id);
		}

	}
}