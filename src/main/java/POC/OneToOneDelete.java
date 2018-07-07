package POC;

import entities.Instructor;
import entities.InstructorDetail;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToOneDelete {
    public static void main(String[] args) {
        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Instructor insObj = session.get(Instructor.class, 1);
            if (insObj != null) {
                session.delete(insObj);
            }
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }
}
