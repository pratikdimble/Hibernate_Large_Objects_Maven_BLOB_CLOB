package com.app;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClass {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		//activate the hibernate framework
			cfg=new Configuration().configure("hibernate.cfg.xml");
			//build the session factory
			sf=cfg.buildSessionFactory();
			//open/get the session
			ses=sf.openSession();
			
			//create the model class object and set the data
			Employee e=new Employee();
			e.setId(11);
			e.setName("Pratik");
			//create the BLOB and CLOB data with objects
			
			String str="How Are You Pratik";
			File file= new File("C:/Users/preesneh/Downloads/download.jpg");
		
			
			char[] cdata=str.toCharArray();
			e.setCarr(cdata);
			byte[] bdata=new byte[(int) file.length()];
			
			
			
			try {
				FileInputStream fis=new FileInputStream(file);
				fis.read(bdata);
				e.setBarr(bdata);
				//begin the transaction
				tx=ses.beginTransaction();
				//save the data
				ses.save(e);
				tx.commit();
				System.out.println("\n\t\t***Data is Inserted***");
				
			} catch (Exception e2) {
				tx.rollback();
				e2.printStackTrace();
			}finally {
				try {
					//close the session factory and session
					ses.close();
					sf.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		
	}//main ends

}//class ends
