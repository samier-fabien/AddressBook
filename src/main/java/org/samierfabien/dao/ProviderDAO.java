package org.samierfabien.dao;

import org.samierfabien.model.Entity;
import org.samierfabien.model.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

        System.out.println(list.size());
        return (Entity) list.get(0);
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

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(Entity entity) {

    }
}
