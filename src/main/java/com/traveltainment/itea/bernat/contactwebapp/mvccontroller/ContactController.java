/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traveltainment.itea.bernat.contactwebapp.mvccontroller;

import com.traveltainment.itea.bernat.contactwebapp.mvcmodel.Contact;
import com.traveltainment.itea.bernat.contactwebapp.mvcmodel.jpa.ContactRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bernat
 */
@Controller
@RequestMapping("/")
public class ContactController {
    private final ContactRepository contactRepo;
    
    @Autowired
    public ContactController(final ContactRepository contactRepo)
    {
        this.contactRepo = contactRepo;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(final Map<String, Object> model){
        List<Contact> contacts = contactRepo.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submit(final Contact contact){
        contactRepo.save(contact);
        return "redirect:/";
    }
    
    
    
}
