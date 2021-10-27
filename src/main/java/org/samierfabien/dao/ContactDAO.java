package org.samierfabien.dao;

import org.samierfabien.model.Entity;
import org.samierfabien.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO implements DAOInterface{
    @Override
    public Entity find(int id) {
        List list = new ArrayList<Contact>();
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT id, con_nom, con_prenom, con_statut, con_tel, con_mail  FROM contact WHERE id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Contact(resultSet.getInt("id"), resultSet.getString("con_nom"), resultSet.getString("con_prenom"), resultSet.getString("con_statut"), resultSet.getString("con_tel"), resultSet.getString("con_mail")));
                //System.out.println("id : " + resultSet.getInt("id") + " | con_nom : " + resultSet.getString("con_nom") + " | con_prenom : " + resultSet.getString("con_prenom") + " | con_statut : " + resultSet.getString("con_statut") + " | con_tel : " + resultSet.getString("con_tel") + " | con_mail : " + resultSet.getString("con_mail"));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {}
        }

        return (Entity)list.get(0);
    }

    @Override
    public List<Entity> findAll() {
        List list = new ArrayList<Contact>();
        Connection connection = ConnectionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM contact");
            while (resultSet.next()) {
                list.add(new Contact(resultSet.getInt("id"), resultSet.getString("con_nom"), resultSet.getString("con_prenom"), resultSet.getString("con_statut"), resultSet.getString("con_tel"), resultSet.getString("con_mail")));
                //System.out.println("id : " + resultSet.getInt("id") + " | con_nom : " + resultSet.getString("con_nom") + " | con_prenom : " + resultSet.getString("con_prenom") + " | con_statut : " + resultSet.getString("con_statut") + " | con_tel : " + resultSet.getString("con_tel") + " | con_mail : " + resultSet.getString("con_mail"));
            }
            resultSet.close();
            System.out.println("ResultSet close");
            statement.close();
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {}
        }

        return list;
    }

    @Override
    public void insert(Entity entity) {
        Contact Contact = (Contact)entity;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO contact (con_nom, con_prenom, con_statut, con_tel, con_mail) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, Contact.getCon_nom());
            statement.setString(2, Contact.getCon_prenom());
            statement.setString(3, Contact.getCon_statut());
            statement.setString(4, Contact.getCon_tel());
            statement.setString(5, Contact.getCon_mail());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void update(Entity entity) {
        Contact Contact = (Contact)entity;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE contact SET con_nom = ?, con_prenom = ?, con_statut = ?, con_tel = ?, con_mail = ? WHERE id=?");
            statement.setString(1, Contact.getCon_nom());
            statement.setString(2, Contact.getCon_prenom());
            statement.setString(3, Contact.getCon_statut());
            statement.setString(4, Contact.getCon_tel());
            statement.setString(5, Contact.getCon_mail());
            statement.setInt(6, Contact.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM contact WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {}
        }
    }
}
