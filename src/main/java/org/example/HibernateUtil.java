package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.model.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Bread.class)
                .addAnnotatedClass(Chocolate.class)
                .addAnnotatedClass(Milk.class)
                .addAnnotatedClass(Fruit.class)
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Card7.class)
                .addAnnotatedClass(VipCard.class)
                .addAnnotatedClass(Chips.class)
                .buildSessionFactory();
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
