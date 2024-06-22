package com.example.demo;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien telusko = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        telusko = (Alien) session.get(Alien.class, 102);
        
        tx.commit();
        
        System.out.println(telusko);
    }
}