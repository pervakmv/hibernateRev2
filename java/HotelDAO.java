import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements DAO<Hotel> {
    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory() {
        //singletion patern
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public Hotel save(Hotel hotel) {
        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(hotel);

            //close session/tr
            session.getTransaction().commit();
            System.out.println("Save hotel is done");
        } catch (HibernateException e) {
            System.err.println("Save hotel is failed");
            System.out.println(e.getMessage());
            hotel = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }
        return hotel;
    }

    @Override
    public Hotel delete(Hotel hotel) {

        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.delete(hotel);

            //close session/tr
            session.getTransaction().commit();
            System.out.println("Delete hotel is done");
        } catch (HibernateException e) {
            System.err.println("Delete hotel is failed");
            System.out.println(e.getMessage());
            hotel = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }


        return hotel;
    }

    @Override
    public Hotel update(Hotel hotel) {

        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(hotel);

            //close session/tr
            session.getTransaction().commit();
            System.out.println("Update hotel is done");
        } catch (HibernateException e) {
            System.err.println("Update hotel is failed");
            System.out.println(e.getMessage());
            hotel = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }
        return hotel;
    }

    @Override
    public Hotel findById(long id) {
        Session session = null;
        Transaction tr = null;
        List<Hotel> resHotels = new ArrayList<>();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery("from Hotel where id=: id");
            query.setParameter("id", id);
            resHotels = query.list();

            session.getTransaction().commit();
            System.out.println("find hotel by id is done");

        } catch (HibernateException e) {
            System.err.println("find hote by id is faild");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resHotels.isEmpty()?null:resHotels.get(0);
    }
}
