package hibernate.Mapping;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.Entity.*;

public class App_many_to_many {
	public static void main(String[] args) {
		System.out.println( "Mapping many to many!");
		System.out.println( "One student can have multiple courses and one course can have many students!");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Course c1= new Course(101, "Data Structures");
        Course c2= new Course(102, "DBMS");
        
        List<Course> CL=new ArrayList<>();
        CL.add(c1);
        CL.add(c2);
        
        Student s1= new Student(1, "Ravi", CL);
        Student s2= new Student(2, "Chai", CL);
        
        List<Student> SL=new ArrayList<>();
        SL.add(s1);
        SL.add(s2);
        
        
        s1.setCourses(CL);
        s2.setCourses(CL);
        c1.setStudents(SL);
        c2.setStudents(SL);
        
        
        session.beginTransaction();
        session.persist(s1);
        session.persist(s2);
        
        session.persist(c1);
        session.persist(c2);
        
        session.getTransaction().commit();
        
        session.createQuery("from Course",Course.class).list().forEach(System.out::println);
        session.createQuery("from Student",Student.class).list().forEach(System.out::println);
        
        System.out.println("List above");
        
        session.close();
		
	}	
}
