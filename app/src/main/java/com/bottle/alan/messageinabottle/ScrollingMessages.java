package com.bottle.alan.messageinabottle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;


public class ScrollingMessages extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public final static String MESSAGE_TEXT = "com.bottle.alan.MESSAGE";

    private final static boolean DEBUG = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_messages); // REPLACE WITH ACTIVITY_MAIN


        // RANDOM TOOLBAR
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        // OK!
        // NOW I use android stuff
        // get the listview


        expListView = (ExpandableListView) findViewById(R.id.lvExp);

////         preparing list data, POPULATE OUR MESSAGES
        prepareListData();

        listAdapter = new ExpandableListAdapters(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        if (DEBUG) {
            // Listview Group click listener
            expListView.setOnGroupClickListener(new OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            // Listview Group expanded listener
            expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(groupPosition) + " Expanded",
                            Toast.LENGTH_SHORT).show();
                }
            });

            // Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(groupPosition) + " Collapsed",
                            Toast.LENGTH_SHORT).show();

                }
            });
        }
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                if (DEBUG) {
                    Toast.makeText(
                            getApplicationContext(),
                            listDataHeader.get(groupPosition)
                                    + " : "
                                    + listDataChild.get(
                                    listDataHeader.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT)
                            .show();
                }
                Intent intent = new Intent(ScrollingMessages.this, ScrollingMessageDetails.class);
                String message = listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition);
                intent.putExtra(MESSAGE_TEXT, message);
                startActivity(intent);
                return false;
            }
        });


    }

    private String m_Text = "";

    public void sendMessage(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Send A Message");

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                // RUN MESSAGE SEND POST REQUEST

                Toast.makeText(
                        getApplicationContext(), m_Text, Toast.LENGTH_SHORT)
                        .show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        // GET INFO FROM ALL THE MESSAGES
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Received Messages");
        listDataHeader.add("Sent Messages");
        listDataHeader.add("Archived Messages");

        // Adding child data
        List<String> received = new ArrayList<String>();
        received.add("HackPton is the best!!!");
        received.add("I have two midterms on Monday T.T");
        received.add("Wow the applications are endless");
        received.add("Where are the bathrooms around here???");
//        received.add("filler");
//        received.add("The Dark Knight");
//        received.add("12 Angry Men");

        List<String> sent = new ArrayList<String>();
        sent.add("Blah blah blah");
        sent.add("blah blah");
        sent.add("blah");
//        sent.add("Grown Ups 2");
//        sent.add("Red 2");
//        sent.add("The Wolverine");

        List<String> archived = new ArrayList<String>();
        archived.add("deleted 1");
        archived.add("deleted 2");
        archived.add("deleted 3");
//        archived.add("The Canyons");
//        archived.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), received); // Header, Child data
        listDataChild.put(listDataHeader.get(1), sent);
        listDataChild.put(listDataHeader.get(2), archived);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling_messages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
