package cn.lcu.alvin.hibernatetest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import cn.lcu.alvin.entity.User;
import cn.lcu.alvin.utils.HibernateUtils;

public class HibernateQueryData {

    @Test
    public void testQuery() {

        
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();

            tx = session.beginTransaction();

            Query query = session.createQuery("from User");
            List<User> list = query.list();
            for (User user : list) {
                System.out.println(user);
            }

            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }

        
    }
    

    @Test
    public void criteriaTest() {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();

            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            List<User> list = criteria.list();
            for (User user : list) {
                System.out.println(user);
            }
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
    
    @Test
    public void sqlQueryTest() {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();

            tx = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
            sqlQuery.addEntity(User.class);
            List<User> ls = sqlQuery.list();
            
            for (User user : ls) {
                System.out.println(user);
            }
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
