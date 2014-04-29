/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mballem.spring.ajax.dao;

import com.mballem.spring.ajax.entity.Contact;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * http://www.mballem.com/
 * @author Marcio Ballem
 */
@Repository
@Transactional
public class ContactDao implements IContactDao<Contact> {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
    }

    @Override
    public Contact findByName(String firstName, String lastName) {
        return (Contact) sessionFactory.getCurrentSession().createCriteria(Contact.class)
                .add(Restrictions.eq("firstName", firstName).ignoreCase())
                .add(Restrictions.eq("lastName", lastName).ignoreCase())
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> findByFirstName(String firstName) {
        return sessionFactory.getCurrentSession().createCriteria(Contact.class)
                .add(Restrictions.like("firstName", firstName + "%").ignoreCase())
                .list();
    }
    
}
