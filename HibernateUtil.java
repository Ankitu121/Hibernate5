package org.hcltech;

import org.hcltech.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;

public class HibernateUtil {
  private static SessionFactory sessionFactory;
  private static StandardServiceRegistry standardServiceRegistry;

  public static SessionFactory getSessionFactory() {
    try {
      StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
      HashMap<String , String> hashMap= new HashMap<>();
      hashMap.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
      hashMap.put("hibernate.connection.url","jdbc:mysql://localhost:3306/employeesDB");
      hashMap.put("hibernate.connection.username","root");
      hashMap.put("hibernate.hbm2ddl.auto","create");
      hashMap.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
      standardServiceRegistryBuilder.applySettings(hashMap);
      standardServiceRegistry=standardServiceRegistryBuilder.build();
      MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
           metadataSources.addAnnotatedClass(Employee.class);
      Metadata metadata=metadataSources.getMetadataBuilder().build();
       sessionFactory=metadata.getSessionFactoryBuilder().build();
       System.out.println("Connection is Establiahed !");
    } catch (Throwable e) {
      System.out.println("Session Factory Creation Failed !");
      if(standardServiceRegistry !=null)
        StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
    }

    return sessionFactory;
  }
}