package com.springmvc.dao;

import com.springmvc.model.UserForValidWithAnnotation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("UserTestDaoForAnnotation")
public class UserTestDaoForAnnotationImpl extends AbstractDao <Integer, UserForValidWithAnnotation> implements UserTestDaoForAnnotation{

    public UserForValidWithAnnotation findByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        UserForValidWithAnnotation user = (UserForValidWithAnnotation)criteria.uniqueResult();
        return user;
    }
}
