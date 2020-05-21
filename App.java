package org.hcltech;

import org.hcltech.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        try{
            Transaction transaction =session.beginTransaction();
            Employee employee = new Employee();
            employee.setEmployeeID(51769082);
            employee.setFirstName("Ankit");
            employee.setLastName("Upadhyay");
            employee.setDesignation("Lead Engineer");
            session.save(employee);
            transaction.commit();

        }catch(HibernateException e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
    }
}
