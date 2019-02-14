import org.hibernate.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;
//import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class RoomDAO implements DAO<Room> {

    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory() {
        //singletion patern
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public Room save(Room Room) {
        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(Room);

            //close session/tr
            session.getTransaction().commit();
            System.out.println("Save Room is done");
        } catch (HibernateException e) {
            System.err.println("Save Room is failed");
            System.out.println(e.getMessage());
            Room = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }
        return Room;
    }

    @Override
    public Room delete(Room room) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            room.setHotel(null);
            session.delete(room);

            //close session/tr
            session.getTransaction().commit();
            System.out.println("Delete Room is done");
        } catch (HibernateException e) {
            System.err.println("Delete Room is failed");
            System.out.println(e.getMessage());
            room = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }


        return room;
    }

    @Override
    public Room update(Room room) {

        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            session.update(room);
            //close session/tr
            session.getTransaction().commit();
            System.out.println("Update Room is done");
        } catch (HibernateException e) {
            System.err.println("Update Room is failed");
            System.out.println(e.getMessage());
            room = null;
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }
        return room;
    }

    @Override
    public Room findById(long id) {
        Session session = null;
        Transaction tr = null;

        Room resRoom = new Room();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            resRoom = session.get(Room.class, id);

            resRoom.toString(); //Роблю для того щоб ініціалізувати PROXY інакше видає Exception

            session.getTransaction().commit();
            System.out.println("find Room by id is done");

        } catch (HibernateException e) {
            System.err.println("find hote by id is faild");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return resRoom;
    }

    public List<Room> getAll() {
        Session session = null;
        Transaction tr = null;
        List<Room> resRooms = new ArrayList<>();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery("from Room");
            resRooms = query.list();
            resRooms.toString();
            session.getTransaction().commit();
            System.out.println("get all room done");
        } catch (HibernateException e) {
            System.out.println("get all room field");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();

        } finally {
            if (session != null)
                session.close();
        }
        return resRooms;
    }

}
