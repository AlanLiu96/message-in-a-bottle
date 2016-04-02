package com.bottle.alan.messageinabottle;

import java.util.*;
/**
 * Created by Patrick on 4/2/2016.
 */
public class Request {
    private Location location; //location of sender
    private Person sender; //sender of request (Person)
    private LinkedList<Boolean> msgsRecievedList; //list of which messages have been recieved by the sender

    public Request(Location l, Person s, LinkedList<Boolean> mr ){
        location = l;
        sender = s;
        msgsRecievedList = mr;
    }

    public Location getLocation(){
        return location;
    }

    public Person getSender(){
        return sender;
    }

    public LinkedList<Boolean> getMsgsRecievedList(){
        return msgsRecievedList;
    }

    public void setLocation(Location l){
        location = l;
    }

    public void setSender(Person p){
        sender = p;
    }

    public void setMsgsRecievedList(LinkedList<Boolean> mr){
        msgsRecievedList = mr;
    }



}
