package hibernate.Mapping;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.Entity.*;

public class App_one_to_many {
	public static void main(String[] args) {
		System.out.println( "Mapping one to many and many to one!");
		System.out.println( "One department could have multiple employees!");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Department d1= new Department(101, "IT");
        Department d2= new Department(102, "HR");
        
        Employee emp1= new Employee(1, "Ravi",d1);
        Employee emp2= new Employee(2, "Dushyant",d1);
        
        Employee emp3= new Employee(3, "Rupa",d2);
        List<Employee> l1=new ArrayList<>();
        List<Employee> l2=new ArrayList<>();
        l1.add(emp1);
        l1.add(emp2);

        l2.add(emp3);
        
        d1.setEmployees(l1);
        d2.setEmployees(l2);
        
        session.beginTransaction();
        session.persist(d1);
        session.persist(d2);
        
        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);
        
        session.getTransaction().commit();
        
        session.createQuery("from Department",Department.class).list().forEach(System.out::println);
        session.createQuery("from Employee",Employee.class).list().forEach(System.out::println);
        
        System.out.println("List above");
        
        session.close();
		
	}	
}
