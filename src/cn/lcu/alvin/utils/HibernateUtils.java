package cn.lcu.alvin.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

  static SessionFactory sessionFactory = null;
  static Configuration cfg = null;

  static {

    cfg = new Configuration().configure();
    sessionFactory = cfg.buildSessionFactory();
  }
  
  //返回与本地线程绑定的session方法
  
  public static Session getSessionObject() {
      
      return sessionFactory.getCurrentSession();
    
}

   public static SessionFactory getSessionFactory() {

    return sessionFactory;

  }

}
