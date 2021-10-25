package org.samierfabien.controller;

import org.samierfabien.dao.ConnectionManager;
import org.samierfabien.dao.ProviderDAO;
import org.samierfabien.model.Provider;

import java.sql.Connection;

public class MainController {

    public MainController() {
        ProviderDAO providerDAO = new ProviderDAO();
        Provider provider = (Provider) providerDAO.find(2);
        System.out.println(provider.getPro_adresse());
    }
}
