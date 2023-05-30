package com.nikhil.main;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nikhil.model.Employee;
import com.nikhil.util.HibernateUtil;


public class TestInsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(18);
				employee.setEmpName("kohli");
				employee.setEmpSal(99890.44);

				Serializable saveId = session.save(employee);
				
				employee = session.load(Employee.class, saveId);
				System.out.println(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(flag == true)
				transaction.commit();
			else
				transaction.rollback();
			
			HibernateUtil.closeSession(session);
		}

	}
}
