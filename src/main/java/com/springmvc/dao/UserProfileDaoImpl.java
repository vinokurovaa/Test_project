package com.springmvc.dao;

import com.springmvc.model.UserProfile;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer,UserProfile> implements UserProfileDao {
    static final Logger logger = Logger.getLogger(UserProfileDaoImpl.class);

    public UserProfile findById(int id) {
        return getByKey(id);
    }

    public UserProfile findByRole(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        return  (UserProfile) criteria.uniqueResult();
    }
    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("type"));
        return (List<UserProfile>) criteria.list();
    }
}
