package com.xcz.common;

/**
 * Created by root on 16-10-6.
 */
public class BaseService {
    private HibernateDAO hibernateDAO;

    public HibernateDAO getHibernateDAO() {
        return hibernateDAO;
    }

    public void setHibernateDAO(HibernateDAO hibernateDAO) {
        this.hibernateDAO = hibernateDAO;
    }
}
