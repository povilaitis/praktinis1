package lt.viko.eif.vpovilaitis.gym.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.vpovilaitis.gym.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {


        Trainer trainer1 = new Trainer("rob", "robinson");
        Equipment equipment1 = new Equipment("machine", "legs");
        Plan plan1 = new Plan("squat", "12", "3", equipment1);
        Membership membership1 = new Membership(plan1);
        User user1 = new User("john", "johnson", membership1, trainer1);

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("from User", User.class).list();
            users.forEach(user -> System.out.println(user));

            System.out.println("________________________");
            users.forEach(user -> JaxbUtil.convertToXML(user));

            System.in.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

        }
    }
}
