package hibernate.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.Entity.Passport;
import hibernate.Entity.Person;

public class App_one_to_one {
	public static void main(String[] args) {
		System.out.println( "Mapping one to one!");
		System.out.println( "Assuming one person has only one passport!");
		
		
		Passport pp1= new Passport ((long)123, "Hx0015" );
		Person p1= new Person((long)123, "Ravi", pp1);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.persist(p1);
        session.persist(pp1);
        
        session.getTransaction().commit();
        
        session.createQuery("from Person",Person.class).list().forEach(System.out::println);
        
        session.close();
		
	}	
}
