/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mballem.spring.ajax.controller;

import com.mballem.spring.ajax.dao.IContactDao;
import com.mballem.spring.ajax.entity.Contact;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage_1_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * http://www.mballem.com/
 * @author Marcio Ballem
 */
@Controller
@RequestMapping("contact")
public class ContactController {
    
    @Autowired
    private IContactDao dao;
    
    @RequestMapping("/home")
    public ModelAndView home(ModelMap model) {
        model.put("contacts", dao.findAll());
        return new ModelAndView("contact", model);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Contact saveContact(Contact contact) {
        dao.save(contact);
        
        return contact;
    }
    
    @RequestMapping(value = "/getJSON/{firstName}/{lastName}", method = RequestMethod.GET)
    @ResponseBody
    public Contact findByName(@PathVariable("firstName") String first, @PathVariable("lastName") String last) {
        Contact contact = dao.findByName(first, last);
        return contact;
    }
    
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public ModelAndView load() {
        return new ModelAndView("/table");
    }
    
    @RequestMapping(value = "/load/{firstName}", method = RequestMethod.GET)
    public ModelAndView loadByName(@PathVariable("firstName") String firstName, ModelMap model) {
        model.put("contacts", dao.findByFirstName(firstName));
        return new ModelAndView("/search", model);
    }
}
