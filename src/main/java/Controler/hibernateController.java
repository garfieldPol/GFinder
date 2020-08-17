package Controler;

import Config.HibernateConfiguration;
import Model.Gift;
import org.hibernate.Session;

public class hibernateController {

public Gift get(int id) {
    Session session = HibernateConfiguration.getSessionFactory().openSession();
    Gift gift = (Gift) session.get(Gift.class, id);
    session.close();
    return gift;
}







}
