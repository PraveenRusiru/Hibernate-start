package config;


import entity.Customer;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
        public FactoryConfiguration() {
            Configuration cfg = new Configuration().configure();
            cfg.addAnnotatedClass(Customer.class);
            cfg.buildSessionFactory();
        }
}
