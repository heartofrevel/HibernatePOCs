package POC;

import entities.Student;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class CRUD {

    public static void main(String[] args) {
        Student studObj = new Student("Kanha", "Gupta", "anshul.edu@live.com");
        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(studObj);
            session.getTransaction().commit();
            System.out.println(studObj.getId());//Printing Auto Generated ID

            //Getting new session as we have committed previous session and cannot reuse it
            session = hiberUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Student readStud = session.get(Student.class, studObj.getId());
            System.out.println(readStud);
            session.getTransaction().commit();

            //Updating
            session = hiberUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            readStud.setFirstName("Naomi");
            session.update(readStud);
            session.getTransaction().commit();

            //Deleting
            session = hiberUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(readStud);
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
