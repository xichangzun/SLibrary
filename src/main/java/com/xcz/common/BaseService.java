package com.xcz.common;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

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

    public Double queryFineCanBePaid(String id) {
        String sql = "SELECT BORROW_HISTORY.* FROM BORROW_HISTORY,FINE WHERE BORROW_HISTORY.user_id = '" + id + "' AND BORROW_HISTORY.user_id = FINE.user_id AND BORROW_HISTORY.return_date > FINE.payday AND BORROW_HISTORY.return_date>BORROW_HISTORY.due_date";
        List x = this.getHibernateDAO().findBySql(sql);
        if (x == null || x.isEmpty()) {
            return 0.0;
        } else {
            double bill = 0.0;
            for (int i = 0; i < x.size(); i++) {
                Object[] temp = (Object[]) x.get(i);
                Timestamp t1 = (Timestamp) temp[2];
                Timestamp t2 = (Timestamp) temp[3];
                long fix = t2.getTime() - t1.getTime();
                Double dfix = fix * (1.0);
                bill += dfix / (1000 * 60 * 60 * 24 * 10);

            }
            return bill;
        }
    }

    public Double queryAllFine(String id) {
        String sql = "SELECT * FROM BORROW_HISTORY WHERE user_id = '" + id + "' AND due_date < sysdate() AND return_date is NULL";
        List x = this.getHibernateDAO().findBySql(sql);
        double bill = queryFineCanBePaid(id);
        if (x == null || x.isEmpty()) {
            return bill;
        } else {
            for (int i = 0; i < x.size(); i++) {
                Object[] temp = (Object[]) x.get(i);
                Timestamp t1 = (Timestamp) temp[2];
                long fix = Calendar.getInstance().getTimeInMillis() - t1.getTime();
                bill += fix / (1000 * 60 * 60 * 24 * 10);

            }
            return bill;
        }
    }
}
