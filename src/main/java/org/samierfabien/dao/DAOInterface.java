package org.samierfabien.dao;

import org.samierfabien.model.Entity;

import java.util.List;

/**
 * Toutes les classes représentant les tables doivent étendre la classe Entity.
 * Tous les DAO doivent implémenter l'interface DAOInterface.
 */
public interface DAOInterface {
    /*
    EXEMPLE DE REQUETES :

    ProviderDAO providerDAO = new ProviderDAO();

    //CREATE
        Entity provider1 = new Provider("nom", "ville", "postal", "adresse");
        providerDAO.insert(provider1);

    //READ
        Provider provider2 = (Provider)providerDAO.find(2);
        System.out.println(provider2.getPro_adresse());

    //UPDATE
        Entity provider3 = new Provider(11,"un autre nom", "ville", "postal", "adresse");
        providerDAO.update(provider3);

    //DELETE
        Entity provider4 = new Provider(11,"un autre nom", "ville", "postal", "adresse");
        providerDAO.delete(provider4);
    */

    public Entity find(int id);

    public List<Entity> findAll();

    public void insert(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);
}
