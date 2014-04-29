/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mballem.spring.ajax.dao;

import com.mballem.spring.ajax.entity.Contact;
import java.io.Serializable;
import java.util.List;

/**
 * http://www.mballem.com/
 * @author Marcio Ballem
 */
public interface IContactDao<T extends Serializable> {
    
    void save(Contact contact);
    
    List<Contact> findAll();
    
    Contact findByName(String firstName, String lastName);
    
    List<Contact> findByFirstName(String firstName);
}
