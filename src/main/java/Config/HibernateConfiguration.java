package Config;

import Model.Gift;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Gift.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                         .applySettings(configuration.getProperties())
                         .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
