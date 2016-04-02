package com.bottle.alan.messageinabottle;

import android.content.Context;
import java.util.*;



/**
 * Created by Patrick on 4/2/2016.
 */
public class Person{
    private String name;
    private LinkedList<Message> msgList; //array of all messages this person needs to keep track of
    private LinkedList<Boolean> msgsRecievedList;
    //list indicating whether each message on server has been received


    public Person(String n){
        name = n;
        msgList = new LinkedList<Message>();
        msgsRecievedList = new LinkedList<Boolean>();

    }

    public LinkedList<Message> getMsgList(){
        return msgList;
    }

    public LinkedList<Boolean> getMsgsRecievedList(){
        return msgsRecievedList;
    }

    public void setMsgList(LinkedList<Message> m){
        msgList = m;
    }

    public void setMsgsRecievedList(LinkedList<Boolean> b){
        msgsRecievedList = b;
    }


}

