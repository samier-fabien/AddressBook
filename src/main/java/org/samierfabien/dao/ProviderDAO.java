package org.samierfabien.dao;

import org.samierfabien.model.Entity;
import org.samierfabien.model.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderDAO implements DAOInterface{
    @Override
    public Entity find(int id) {
        List list = new ArrayList<Provider>();
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT id, pro_nom, pro_ville, pro_postal, pro_adresse FROM provider WHERE id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Provider(resultSet.getInt("id"), resultSet.getString("pro_nom"), resultSet.getString("pro_ville"), resultSet.getString("pro_postal"), resultSet.getString("pro_adresse")));
                System.out.println("id : " + resultSet.getInt("id") + " | pro_nom : " + resultSet.getString("pro_nom") + " | pro_ville : " + resultSet.getString("pro_ville") + " | pro_postal : " + resultSet.getString("pro_postal") + " | pro_adresse : " + resultSet.getString("pro_adresse"));
            }
            statement.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return (Entity)list.get(0);
    }

    @Override
    public List<Entity> findAll() {
        List list = new ArrayList<Provider>();

        Connection connection = ConnectionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM provider");
            while (resultSet.next()) {
                list.add(new Provider(resultSet.getInt("id"), resultSet.getString("pro_nom"), resultSet.getString("pro_ville"), resultSet.getString("pro_postal"), resultSet.getString("pro_adresse")));
                System.out.println("id : " + resultSet.getInt("id") + " | pro_nom : " + resultSet.getString("pro_nom") + " | pro_ville : " + resultSet.getString("pro_ville") + " | pro_postal : " + resultSet.getString("pro_postal") + " | pro_adresse : " + resultSet.getString("pro_adresse"));
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void insert(Entity entity) {
        Provider provider = (Provider)entity;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO provider (pro_nom, pro_ville, pro_postal, pro_adresse) VALUES (?, ?, ?, ?)");
            statement.setString(1, provider.getPro_nom());
            statement.setString(2, provider.getPro_ville());
            statement.setString(3, provider.getPro_postal());
            statement.setString(4, provider.getPro_adresse());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Entity entity) {
        Provider provider = (Provider)entity;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE provider SET pro_nom = ?, pro_ville = ?, pro_postal = ?, pro_adresse = ? WHERE id=?");
            statement.setString(1, provider.getPro_nom());
            statement.setString(2, provider.getPro_ville());
            statement.setString(3, provider.getPro_postal());
            statement.setString(4, provider.getPro_adresse());
            statement.setInt(5, provider.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void delete(Entity entity) {
        Provider provider = (Provider)entity;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM provider WHERE id=?");
            statement.setInt(1, provider.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
