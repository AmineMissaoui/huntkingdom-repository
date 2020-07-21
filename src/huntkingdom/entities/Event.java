/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Arif Sami
 */
public class Event {

    public static void setnbPlace(Integer nb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setDescription(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setTitre(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id;
    private String event_title;
    private String event_description;
    
    private int event_max_number;
    private String event_meeting_place;
    private String event_destination;
    private Date event_start_date ;
    private Date event_end_date ;
    private int createur;

    public Event() {
    }

    public Event(int id, String event_title, String event_description, int event_max_number, String event_meeting_place, String event_destination, Date event_start_date, Date event_end_date, int createur) {
        this.id = id;
        this.event_title = event_title;
        this.event_description = event_description;
        this.event_max_number = event_max_number;
        this.event_meeting_place = event_meeting_place;
        this.event_destination = event_destination;
        this.event_start_date = event_start_date;
        this.event_end_date = event_end_date;
        this.createur = createur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public int getEvent_max_number() {
        return event_max_number;
    }

    public void setEvent_max_number(int event_max_number) {
        this.event_max_number = event_max_number;
    }

    public String getEvent_meeting_place() {
        return event_meeting_place;
    }

    public void setEvent_meeting_place(String event_meeting_place) {
        this.event_meeting_place = event_meeting_place;
    }

    public String getEvent_destination() {
        return event_destination;
    }

    public void setEvent_destination(String event_destination) {
        this.event_destination = event_destination;
    }

    public Date getEvent_start_date() {
        return event_start_date;
    }

    public void setEvent_start_date(Date event_start_date) {
        this.event_start_date = event_start_date;
    }

    public Date getEvent_end_date() {
        return event_end_date;
    }

    public void setEvent_end_date(Date event_end_date) {
        this.event_end_date = event_end_date;
    }

    public int getCreateur() {
        return createur;
    }

    public void setCreateur(int createur) {
        this.createur = createur;
    }


    
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", event_title=" + event_title + ", event_destination=" + event_destination + ", event_meeting_place=" + event_meeting_place + ", event_max_number=" + event_max_number +  '}';
    }

    
   
    }
        

