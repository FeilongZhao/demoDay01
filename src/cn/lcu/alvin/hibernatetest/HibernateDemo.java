package cn.lcu.alvin.hibernatetest;

import cn.lcu.alvin.entity.User;
import cn.lcu.alvin.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;


/*
 * crud
 */
public class HibernateDemo {

    @Test
    public void testAdd() {

        // 加载核心配置文件
        // Configuration cfg = null;
        // cfg = new Configuration().configure();

        // 创建创建表
        // SessionFactory sessionFactory = cfg.buildSessionFactory();

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 创建SessonFactory
        Session session = sessionFactory.openSession();
        // 开启事物
        final Transaction tx = session.beginTransaction();

        User user = new User();
        user.setUsername("aa");
        user.setPassword("123a");
        user.setAddress("aa");

        session.save(user);

        // 提交事物
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void getNameTest() {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, 1);
        System.out.println(user);

        tx.commit();
        session.close();

    }
    
    @Test
    public void updateTest() {
       
       SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
       Session session = sessionFactory.openSession();
       Transaction tx = session.beginTransaction();
       
       User user = session.get(User.class, 2);
       user.setUsername("cc");
       session.update(user);
       
       tx.commit();
       session.close();
    }
    
    @Test
    public void SaveOrUpdateTest() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123a");
        user.setAddress("aa");
        
        session.saveOrUpdate(user);
        
        
        tx.commit();
        session.close();
    }
    
    @Test
    public void deleteTest() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        User user = session.get(User.class, 2);
        session.delete(user);
        tx.commit();
        session.close();
        
    }
}
