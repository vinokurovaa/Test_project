package com.springmvc.dao;

import com.springmvc.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao {
    static final org.apache.log4j.Logger logger = Logger.getLogger(UserDaoImpl.class);

    public User findById(int id){
        User user = getByKey(id);
        if(user!=null){
            Hibernate.initialize(user.getUserRole());
        }
        return user;
    }

    public User findBySSO(String sso) {
        logger.info("SSO : {}" + sso);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId", sso));
        User user = (User)criteria.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserRole());
        }
        return user;
    }

    public void save(User user) {
        persist(user);

    }

    public void deleteBySSO(String sso) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId", sso));
        User user = (User)criteria.uniqueResult();
        delete(user);
    }

    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> users = (List<User>)criteria.list();
        return users;
    }

}
