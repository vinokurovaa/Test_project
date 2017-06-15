package com.springmvc.dao;

import com.springmvc.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Asus on 15.06.2017.
 */
public class RoleDaoImpl extends AbstractDao<Integer,Role> implements RoleDao {
    public Role findById(int id) {
        return getByKey(id);
    }

    public Role findByRole(String role) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("role", role));
        return  (Role) criteria.uniqueResult();
    }
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("role"));
        return (List<Role>) criteria.list();
    }
}
