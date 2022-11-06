package org.itsci.ubrswimming.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl  implements UserDetailsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        Query<Login> query = session.createQuery("from Login l where l.email=:username", Login.class);
        query.setParameter("username", username);
        Login l = query.getSingleResult();
        return l;
    }
}
