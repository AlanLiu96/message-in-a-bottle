package com.bottle.alan.messageinabottle;

import java.util.*;
/**
 * Created by Patrick on 4/2/2016.
 */
public class Message {
    private String text; //text of the actual message
    private Date lastTransmitted; // time (and date) that this message was lat transmitted
    private LinkedList<Location> transmittingLocations;
    // the transmitting locations of the active transmitters
    private LinkedList<Person> activeTransmitters;
    //the people who are able to propagate the message
    private PathNode pathGraph;
    //tree (graph) of all transmissions

    public Message(String t, Date transmitted, Location l, Person p){
        text = t;
        lastTransmitted = transmitted;
        transmittingLocations = new LinkedList<Location>();
        activeTransmitters = new LinkedList<Person>();
        pathGraph = new PathNode(l, p);
    }

    public String getText(){
        return text;
    }

    public Date getDateTime(){
        return lastTransmitted;
    }

    public LinkedList<Location> getTransmittingLocations(){
        return transmittingLocations;
    }

    public LinkedList<Person> getActiveTransmitters(){
        return activeTransmitters;
    }

    public void setText(String s){
        text = s;
    }

    public void setDateTime(Date d){
        lastTransmitted = d;
    }

    public void setTransmittingLocations(LinkedList<Location> l){
        transmittingLocations = l;
    }

    public void setActiveTransmitters(LinkedList<Person> p){
        activeTransmitters = p;
    }
}
