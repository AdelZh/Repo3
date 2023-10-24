package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();

        User user = new User(name, lastName, age);
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS \"User\"").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void removeUserById(long id) {

        Session session = Util.getSession().openSession();
        session.beginTransaction();

        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }

        session.getTransaction().commit();
        session.close();
    }


    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();

        String hql = "FROM User";
        List<User> users = session.createQuery(hql).list();

        session.getTransaction().commit();
        session.close();

        return users;

    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM \"User\"").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}



