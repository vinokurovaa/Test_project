package com.springmvc.dao;



import com.springmvc.model.TestUser;
import com.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("testUserDao")
public class TestUserDaoImpl  extends AbstractDao<Integer,User> implements TestUserDao {
    public boolean findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        TestUser user = (TestUser)criteria.uniqueResult();
        if(user!=null){
            return true;
        }else {
            return false;
        }
    }
}
