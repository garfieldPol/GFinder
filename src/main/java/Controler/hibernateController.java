package Controler;

import Config.HibernateConfiguration;
import Model.Gift;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class hibernateController {

    public Gift get(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Gift gift = (Gift) session.get(Gift.class, id);
        session.close();
        return gift;
    }

    public void save(String giftName, int ageGroup)

    {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(new Gift(1,giftName,ageGroup));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();


    }


}
