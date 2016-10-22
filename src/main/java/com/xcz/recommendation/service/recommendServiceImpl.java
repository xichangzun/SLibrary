package com.xcz.recommendation.service;

import com.xcz.common.BaseService;
import com.xcz.recommendation.domain.Recommendation;

/**
 * Created by root on 16-10-15.
 */
public class recommendServiceImpl  extends BaseService implements recommendService {
    public Boolean addrecommend(Recommendation a)
    {
        String sql = "INSERT INTO RECOMMENDATION (user_id, ISBN, book_name, lang, author, press,  price, amount, reason, status)" +
                "  VALUE ('"+a.getUionPK().getUser_id()+"','"+a.getUionPK().getISBN()+"','"
        +a.getBook_name()+"','"+a.getLang()+"','"+a.getAuthor()+"','"+a.getPress()+"',{6},{7},'"+a.getReason()+"',{9})";
        sql = sql.replace("{6}",a.getPrice().toString());
        sql = sql.replace(("{7}"),a.getAmount().toString());
        sql = sql.replace("{9}",a.getStatus()?(1+""):(0+""));
        System.out.println(sql);
        return this.getHibernateDAO().executeBySql(sql);

    }
}
