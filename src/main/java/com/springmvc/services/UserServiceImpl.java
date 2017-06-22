package com.springmvc.services;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findBySSO(String sso) {
        return dao.findBySSO(sso);
    }
    public User findUserByEmail(String email){
        return  dao.findUserByEmail(email);
    }

    public void saveUser(User user) {
        dao.save(user);
    }

    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setLogin(user.getLogin());
            entity.setUserRole(user.getUserRole());
        }
    }

    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        User entity = dao.findBySSO(sso);
        return (entity == null || ((id!=null) && (entity.getId()==id)));
    }
    public boolean isUserEmailUnique(String email){
        User user = dao.findUserByEmail(email);
        if(user==null){
            return true;
        }
        return false;
    }
}
