package jbr.springmvc.dao;

import jbr.springmvc.model.Contact;

import java.util.List;

public interface UserDao {

    public void save(Contact contact);

    public List<Contact> list();
}
