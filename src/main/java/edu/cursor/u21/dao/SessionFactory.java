package edu.cursor.u21.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Created by vk on 3/11/17.
 */
public class SessionFactory {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static final Configuration configuration = new Configuration();
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
    private static org.hibernate.SessionFactory sessionFactory;

    private SessionFactory() {
    }

    public static Session currentSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null) {
            if (sessionFactory == null) {
                try {
                    configuration.configure(CONFIG_FILE_LOCATION);
                    sessionFactory = configuration.buildSessionFactory();
                } catch (Exception e) {
                    System.err.println("Error Creation SessionFactory");
                    e.printStackTrace();
                }
            }
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}