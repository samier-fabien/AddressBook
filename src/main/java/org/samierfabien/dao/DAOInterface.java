package org.samierfabien.dao;

import org.samierfabien.model.Entity;

import java.util.List;

/**
 * Toutes les classes représentant les tables doivent étendre la classe Entity.
 * Tous les DAO doivent implémenter l'interface DAOInterface.
 */
public interface DAOInterface {
/*
    EXEMPLES DE REQUETES :


    ContactDAO contactDAO = new ContactDAO();   //initialisation du DAO

    //CREATE
        Entity contact1 = new Contact("nom", "prenom", "statut", "tel", "mail");
        contactDAO.insert(contact1);

    //READ
        Contact contact2 = (Contact) contactDAO.find(2);
        System.out.println(contact2.getCon_nom());

    //READALL
        contactDAO.findAll();

    //UPDATE
        Entity contact3 = new Contact(11,"un autre nom", "prenom", "statut", "tel", "mail");
        contactDAO.update(contact3);

    //DELETE
        Entity contact4 = new Contact(11,"un autre nom", "prenom", "statut", "tel", "mail");
        contactDAO.delete(contact4);
    */

    public Entity find(int id);

    public List<Entity> findAll();

    public void insert(Entity entity);

    public void update(Entity entity);

    public void delete(int id);
}
