package org.samierfabien.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.samierfabien.dao.ContactDAO;
import org.samierfabien.model.Contact;
import org.samierfabien.model.Entity;

import javax.swing.text.TabableView;

public class MainController {
    private ObservableList<Contact> liste = FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Contact, String> prenomColumn;
    @FXML
    private TableColumn<Contact, String> nomColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label statutLabel;
    @FXML
    private Label telLabel;
    @FXML
    private Label courrielLabel;
    @FXML
    private Label nomValeur;
    @FXML
    private Label prenomValeur;
    @FXML
    private Label statutValeur;
    @FXML
    private Label telValeur;
    @FXML
    private Label courrielValeur;


    public MainController() {
        ContactDAO contactDAO = new ContactDAO();
        Entity contact = new Contact(11,"un autre nom", "prenom", "statut", "tel", "mail");
        contactDAO.delete(contact);
    }

    public void highlight() {

    }
}
