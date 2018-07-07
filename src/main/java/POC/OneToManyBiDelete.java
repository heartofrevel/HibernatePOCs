package POC;

import entities.Course;
import entities.Instructor;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToManyBiDelete {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        Session session=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int theId=10;
            Course courseObj = session.get(Course.class, theId);
            System.out.println(courseObj);
            session.delete(courseObj);
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
