/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.gui;

import huntkingdom.entities.Event;
import huntkingdom.services.ServiceEvent;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SARRA
 */
public class ShowEventController implements Initializable {

    @FXML
    private Button btnadd;
    @FXML
    private TableView<Event> tableview;
    @FXML
    private TableColumn<Event, String> idColumn;
    @FXML
    private TableColumn<Event, String> nomColumn;
    @FXML
    private TableColumn<Event, String> adresseColumn;
    @FXML
    private TableColumn<Event, Date> dateColumn;
    @FXML
    private TableColumn<Event, Date> heurerendezvousColumn;
    @FXML
    private TableColumn<Event, String> adresserendezvousColumn;
    @FXML
    private TableColumn<Event, Date> jourdedepartColumn;
    @FXML
    private TableColumn<Event, Date> jourderetourColumn;

    ServiceEvent es = new ServiceEvent();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            heurerendezvousColumn.setCellValueFactory(new PropertyValueFactory<>("heurerendezvous"));
            adresserendezvousColumn.setCellValueFactory(new PropertyValueFactory<>("adresserendezvous"));
            jourdedepartColumn.setCellValueFactory(new PropertyValueFactory<>("cjourdedepart"));
            jourderetourColumn.setCellValueFactory(new PropertyValueFactory<>("jourderetour"));

        try {
            ArrayList<Event> eventlist = es.GetEvents();
            ObservableList<Event> L = FXCollections.observableArrayList();
            eventlist.forEach((e)-> L.add(e));
            tableview.setItems(L);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
}
