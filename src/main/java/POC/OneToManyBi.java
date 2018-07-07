package POC;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToManyBi {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        Session session=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int theId = 1;
            Instructor instObj = session.get(Instructor.class, theId);
            Course course1 = new Course("Intro to Programming");
            Course course2 = new Course("Hibernate Advance");
            instObj.addCourse(course1);
            instObj.addCourse(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
