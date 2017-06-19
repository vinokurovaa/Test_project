package com.springmvc.dao;

import com.springmvc.model.PersistenLogin;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistenLogin> implements PersistentTokenRepository {

    private  static final Logger logger = Logger.getLogger(HibernateTokenRepositoryImpl.class);

    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        PersistenLogin persistenLogin = new PersistenLogin();
        persistenLogin.setUsername(persistentRememberMeToken.getUsername());
        persistenLogin.setSeries(persistentRememberMeToken.getSeries());
        persistenLogin.setToken(persistentRememberMeToken.getTokenValue());
        persistenLogin.setLast_used(persistentRememberMeToken.getDate());
        persist(persistenLogin);
    }
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        PersistenLogin persistenLogin = getByKey(seriesId);
        persistenLogin.setToken(tokenValue);
        persistenLogin.setLast_used(lastUsed);
        update(persistenLogin);
    }
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            PersistenLogin persistentLogin = (PersistenLogin) crit.uniqueResult();

            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }
    public void removeUserTokens(String username) {
        Criteria criteria =createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        PersistenLogin persistenLogin = (PersistenLogin) criteria.uniqueResult();
        if(persistenLogin != null){
            delete(persistenLogin);
        }

    }
}
