package com.bottle.alan.messageinabottle;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;



/**
 * Created by Patrick on 4/2/2016.
 */
public class Person{
    public ArrayList<Message> msgList; //array of all messages this person needs to keep track of
    private LinkedList<Boolean> msgsRecievedList;
    private Integer id;
    private LinkedList<Integer> messageIds = new LinkedList<Integer>();
    private LinkedList<Integer> messagesLiked = new LinkedList<Integer>();
    //list indicating whether each message on server has been received


    public Person(){
        msgList = new ArrayList<Message>();
        msgsRecievedList = new LinkedList<Boolean>();

    }

    public ArrayList<Message> getMsgList(){
        return msgList;
    }

    public LinkedList<Boolean> getMsgsRecievedList(){
        return msgsRecievedList;
    }

    public Integer getId(){
        return id;
    }

    public void setMsgList(ArrayList<Message> m){
        msgList = m;
    }

    public void setMsgsRecievedList(LinkedList<Boolean> b){
        msgsRecievedList = b;
    }

    public void sendRequest() throws IOException {

        RequestServer t = (RequestServer) new  RequestServer().execute("hi");
        while ((t.personid) == null){
        }
        Message m = new Message(t.personid);
        if (!msgList.contains(m)){
            msgList.add(m);
        }
       // Log.d("tried to send resuest:", "true");
    }

    public void sendInitialIdRequest() throws IOException {
        String[] s = {"new"};
        Test t = (Test) new Test().execute(s);
        while ((t.getPersonId()) == null){
        }
        id = t.getPersonId();
        Log.d("Id:", id.toString());
    }

    public void writeMessage(String s) throws IOException {
        SendText t = (SendText) new SendText().execute(s);
    }
}

