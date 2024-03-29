package hibernate.H;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "CRUD Operations using Annotations!" );

        Employee employee = new Employee();
        employee.setEmpName("Ravi Bhushan Prasad");
        employee.setEmpEmail("ravi07@accolite.com");
        
        Employee employee1 = new Employee();
        employee1.setEmpName("Cristiano Ronaldo");
        employee1.setEmpEmail("cr7@portugal.com");

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        //beginning transaction
        session.beginTransaction();
        //persist or creating the entries
        session.persist(employee);
        session.persist(employee1);
        
        //listing all the values
        System.out.println("\nListing all values\n");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        
        //changing the values using merge
        session.merge(employee1).setEmpName("Ronaldo");
        
        System.out.println("\nChanged value of employee1");
        Employee savedEmployee = session.get(Employee.class, 2);
        System.out.println(savedEmployee);
        
        //removing the employee1 object
        session.remove(employee1);
        System.out.println("\nEmployee1 removed");
        Employee savedEmployee1 = session.get(Employee.class, 2);
        System.out.println(savedEmployee1);

        //saving the entries
        session.getTransaction().commit();
        //Listing all values again
        System.out.println("\nListing all values again\n");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        session.close();
    }
}