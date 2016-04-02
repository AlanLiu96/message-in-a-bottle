package com.bottle.alan.messageinabottle;

import java.util.*;
/**
 * Created by Patrick on 4/2/2016.
 */
public class PathNode {
    private Location location; //location of person who is represented by this node
    private Person person; // person (who the message was transmitted to)
    private LinkedList<PathNode> children; //those who the message was transmitted to from this person

    public PathNode(Location l, Person p){
        location = l;
        person = p;
        children = new LinkedList<PathNode>();
    }

    public Location getLocation(){
        return location;
    }

    public Person getPerson(){
        return person;
    }

    public LinkedList<PathNode> getChildren(){
        return children;
    }

    public void setLocation(Location l) {
        location = l;
    }

    public void setPerson(Person p) {
        person = p;
    }

    public void addChild(PathNode p){
        children.add(p);
    }

}
