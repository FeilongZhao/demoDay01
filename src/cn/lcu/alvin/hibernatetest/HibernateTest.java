package cn.lcu.alvin.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import cn.lcu.alvin.entity.User;
import cn.lcu.alvin.utils.HibernateUtils;

public class HibernateTest {
    
    @Test
    public void testTX() {
        
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            
            tx = session.beginTransaction();
            
            User user = new User();
            user.setUsername("ff");
            user.setPassword("4567");
            user.setAddress("china");
            
            session.save(user);
            
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
            tx.rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }
   
    }
    
    @Test
    public void sessionTest() {
        
        Session session = HibernateUtils.getSessionObject();
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUsername("ff");
        user.setPassword("4567");
        user.setAddress("china");
        
        session.save(user);
        tx.commit();
    }

}
