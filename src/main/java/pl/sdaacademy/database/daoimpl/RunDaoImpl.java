package pl.sdaacademy.database.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdaacademy.database.dao.RunDao;
import pl.sdaacademy.database.entity.Run;
import pl.sdaacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunDaoImpl implements RunDao {
    public void save(Run run) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(run);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer id) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete Run where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    public Run findById(Integer id) {

        try {
            SessionFactory factory = HibernateUtils.instance().getSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Run run = (Run) session.createQuery("from Run where id=:id").setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            session.close();

            return run;
        } catch (NoResultException ex) {
            // tu nic nie ma ale sie na razie nie przejmujemy
        }
        return null;
    }

    public List<Run> findAll() {

        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Run> list = session.createQuery("from Run").list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    public void dropTable() {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Run> list = session.createQuery("from Run").list();

        for (Run r : list
        ) {
            session.createQuery("delete Run where id=:id")
                    .setParameter("id", r.getId())
                    .executeUpdate();
        }

        session.getTransaction().commit();
        session.close();
    }

    public void dropTableIds() {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("from hibernate_sequence where next_val=:next_val").getSingleResult();

        session.getTransaction().commit();
        session.close();
    }

}
