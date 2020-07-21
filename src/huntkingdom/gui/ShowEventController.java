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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private TableView<Event> tableview;
    @FXML
    private TableColumn<Event, String> idColumn;
    @FXML
    private TableColumn<Event, String> nomColumn;

    ServiceEvent es = new ServiceEvent();
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private TableColumn<?, ?> datestartColumn;
    @FXML
    private TableColumn<?, ?> datefinColumn;
    @FXML
    private TableColumn<?, ?> event_meeting_placeColumn;
    @FXML
    private TableColumn<?, ?> event_destinationColumn;
    @FXML
    private TableColumn<?, ?> event_max_numberColumn;
    @FXML
    private Button btndel;
    @FXML
    private Button btnmap;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("event_title"));
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("event_description"));
            datestartColumn.setCellValueFactory(new PropertyValueFactory<>("event_start_date"));
            datefinColumn.setCellValueFactory(new PropertyValueFactory<>("event_end_date"));
            event_meeting_placeColumn.setCellValueFactory(new PropertyValueFactory<>("event_destination"));
            event_destinationColumn.setCellValueFactory(new PropertyValueFactory<>("event_destination"));
            event_max_numberColumn.setCellValueFactory(new PropertyValueFactory<>("event_max_number"));
        try {
            ArrayList<Event> eventlist = es.GetEvents();
            ObservableList<Event> L = FXCollections.observableArrayList();
            eventlist.forEach((e)-> L.add(e));
            tableview.setItems(L);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        btndel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        deleteevent();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });
        btnmap.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("MAP.fxml"));        
                }
            });
    }

public void deleteevent() throws SQLException{
    Event v = tableview.getSelectionModel().getSelectedItem();
    es.deleteEvents(v);
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EventHome.fxml"));
}    
    
}
