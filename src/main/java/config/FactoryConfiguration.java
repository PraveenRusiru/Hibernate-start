package config;


import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
       private static FactoryConfiguration instance;
       private SessionFactory sessionFactory;
        private FactoryConfiguration() {
            Configuration cfg = new Configuration().configure();
            cfg.addAnnotatedClass(Customer.class);
            sessionFactory = cfg.buildSessionFactory();
        }
        public static FactoryConfiguration getInstance() {
            if (instance == null) {
                instance = new FactoryConfiguration();
            }
            return instance;
        }
        public Session getSessionFactory() {
            return sessionFactory.openSession();
        }
}
