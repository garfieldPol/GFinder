package Controler;

import Config.HibernateConfiguration;
import Model.Gender;
import Model.Gift;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class hibernateController {



//    public Gift get(int ageGroup) {
//        Session session = HibernateConfiguration.getSessionFactory().openSession();
//        Gift gift = (Gift) session.get(Gift.class, ageGroup );
//        session.close();
//        return gift;
//    }

    public void save(String giftName, int ageGroup, Gender gender)

    {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(new Gift(1,giftName,ageGroup, gender));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();


    }

    public List<Gift> findAllByAgeGroup(Integer ageGroup) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Gift> query = cb.createQuery(Gift.class);
        Root<Gift> gift = query.from(Gift.class);
        query.select(gift).where(cb.equal(gift.get("ageGroup"),ageGroup));
        TypedQuery<Gift> typedQuery = session.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<Gift> findAllByGender(Gender gender){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Gift> query = cb.createQuery(Gift.class);
        Root<Gift> gift = query.from(Gift.class);
        query.select(gift).where(cb.equal(gift.get("gender"),gender));
        TypedQuery<Gift> typedQuery = session.createQuery(query);
        return typedQuery.getResultList();
    }








}
