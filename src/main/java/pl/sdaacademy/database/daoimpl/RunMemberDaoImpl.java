package pl.sdaacademy.database.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdaacademy.database.dao.RunMemberDao;
import pl.sdaacademy.database.entity.Run;
import pl.sdaacademy.database.entity.RunMember;
import pl.sdaacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunMemberDaoImpl implements RunMemberDao {
    public void save(RunMember runMember) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(runMember);

        session.getTransaction().commit();
        session.close();
    }

    public RunMember findById(Integer id) {
        try {
            SessionFactory factory = HibernateUtils.instance().getSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            RunMember runMember = (RunMember) session.createQuery("from RunMember where id=:id")
                    .setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            session.close();

            return runMember;
        } catch (NoResultException ex) {
            // tu nic nie ma ale sie na razie nie przejmujemy
        }
        return null;
    }

    public List<RunMember> findAll() {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<RunMember> list = session.createQuery("from RunMember").list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    public void update(RunMember run) {

    }

    public void delete(Integer id) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete RunMember where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
