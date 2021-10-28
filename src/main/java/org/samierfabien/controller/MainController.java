package org.samierfabien.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import org.samierfabien.dao.ContactDAO;
import org.samierfabien.model.Contact;
import org.samierfabien.model.Entity;

import java.util.Collection;
import java.util.List;

public class MainController {
    private ObservableList<Contact> model = FXCollections.observableArrayList();

    @FXML
    private TableView contacts;
    @FXML
    private TableColumn<Contact, String> prenomColumn;
    @FXML
    private TableColumn<Contact, String> nomColumn;

    @FXML
    private ButtonBar mainButtonBar;
    @FXML
    private ButtonBar addButtonBar;
    @FXML
    private ButtonBar updateButtonBar;
    @FXML
    private ButtonBar deleteButtonBar;

    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button confirmAddButton;
    @FXML
    private Button cancelAddButton;
    @FXML
    private Button confirmUpdateButton;
    @FXML
    private Button cancelUpdateButton;
    @FXML
    private Button confirmDeleteButton;
    @FXML
    private Button cancelDeleteButton;

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
    private TextField nomValue;
    @FXML
    private TextField prenomValue;
    @FXML
    private TextField statutValue;
    @FXML
    private TextField telValue;
    @FXML
    private TextField courrielValue;


    public MainController() {}

    @FXML
    public void initialize() {
        fillModel();
        linkTabToModel();
        nomValeurListener();
        prenomValeurListener();
        statutValeurListener();
        telValeurListener();
        courrielValeurListener();
    }

    public void fillModel() {
        ContactDAO contactDAO = new ContactDAO();
        List liste = contactDAO.findAll();
        model.clear();
        for (int i = 0; i<liste.size(); i++) {
            model.add((Contact) liste.get(i));
            //System.out.println(((Contact) liste.get(i)).getCon_nom() + " | " + ((Contact) liste.get(i)).getCon_prenom());
        }
    }

    public void linkTabToModel() {
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("con_nom"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("con_prenom"));

        contacts.setItems(model);
    }

    public void nomValeurListener() {
        contacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Contact contact = (Contact) newValue;
                nomValue.setText(contact.getCon_nom());
            } catch (Exception e) {}
        });
    }

    public void prenomValeurListener() {
        contacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Contact contact = (Contact) newValue;
                prenomValue.setText(contact.getCon_prenom());
            } catch (Exception e) {}
        });
    }

    public void statutValeurListener() {
        contacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Contact contact = (Contact) newValue;
                statutValue.setText(contact.getCon_statut());
            } catch (Exception e) {}
        });
    }

    public void telValeurListener() {
        contacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Contact contact = (Contact) newValue;
                telValue.setText(contact.getCon_tel());
            } catch (Exception e) {}
        });
    }

    public void courrielValeurListener() {
        contacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Contact contact = (Contact) newValue;
                courrielValue.setText(contact.getCon_mail());
            } catch (Exception e) {}
        });
    }

    public void addContact() {
        mainButtonBar.setVisible(false);
        addButtonBar.setVisible(true);
        nomValue.setText("");
        prenomValue.setText("");
        statutValue.setText("");
        telValue.setText("");
        courrielValue.setText("");
        setTextFieldsEditable(true);
    }

    public void confirmAdd() {
        mainButtonBar.setVisible(true);
        addButtonBar.setVisible(false);
        setTextFieldsEditable(false);
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.insert(new Contact(nomValue.getText(), prenomValue.getText(), statutValue.getText(), telValue.getText(), courrielValue.getText()));
        fillModel();
    }

    public  void cancelAdd() {
        mainButtonBar.setVisible(true);
        addButtonBar.setVisible(false);
        setTextFieldsEditable(false);
        fillModel();
    }

    public void updateContact() {
        mainButtonBar.setVisible(false);
        updateButtonBar.setVisible(true);
        setTextFieldsEditable(true);
    }

    public void confirmUpdate() {
        mainButtonBar.setVisible(true);
        updateButtonBar.setVisible(false);
        setTextFieldsEditable(false);

        Contact contact = (Contact) contacts.getSelectionModel().getSelectedItem();
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.update(new Contact(contact.getId() ,nomValue.getText(), prenomValue.getText(), statutValue.getText(), telValue.getText(), courrielValue.getText()));
        fillModel();
    }

    public void cancelUpdate() {
        mainButtonBar.setVisible(true);
        updateButtonBar.setVisible(false);
        setTextFieldsEditable(false);
    }

    public void deleteContact() {
        mainButtonBar.setVisible(false);
        deleteButtonBar.setVisible(true);
    }

    public void confirmDelete() {
        mainButtonBar.setVisible(true);
        deleteButtonBar.setVisible(false);
        Contact contact = (Contact) contacts.getSelectionModel().getSelectedItem();
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.delete(contact.getId());
        fillModel();
    }

    public void cancelDelete() {
        mainButtonBar.setVisible(true);
        deleteButtonBar.setVisible(false);
    }

    private void setTextFieldsEditable(boolean b) {
        nomValue.setEditable(b);
        prenomValue.setEditable(b);
        statutValue.setEditable(b);
        telValue.setEditable(b);
        courrielValue.setEditable(b);
    }
}
