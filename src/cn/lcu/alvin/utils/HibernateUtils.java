package cn.lcu.alvin.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

  static SessionFactory sessionFactory = null;
  static Configuration cfg = null;

  static {

    cfg = new Configuration().configure();
    sessionFactory = cfg.buildSessionFactory();
  }

   public static SessionFactory getSessionFactory() {

    return sessionFactory;

  }

}
