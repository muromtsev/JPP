package jm.task.core.jdbc;



import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(User.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            User user = session.get(User.class, (long) 1);

            System.out.println(user.getName());
            System.out.println(user.getLastName());
            System.out.println(user.getAge());

            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }

    }

}
