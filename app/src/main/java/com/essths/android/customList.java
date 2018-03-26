package com.essths.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.essths.android.model.ticket;

import java.util.List;

/**
 * Created by asus on 11/03/2018.
 */

public class customList extends ArrayAdapter<ticket> {
    Context mCtx ;
    int resource ;
    List<ticket> ticketList ;
    public customList(Context mCtx , int resource , List<ticket> ticketList){
        super(mCtx,resource,ticketList);
        this.mCtx=mCtx ;
        this.resource=resource;
        this.ticketList=ticketList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view

        TextView textViewName = view.findViewById(R.id.textView);
        TextView textViewTeam = view.findViewById(R.id.textView2);
        TextView textViewTdes= view.findViewById(R.id.textView3);
        ImageButton buttonDelete = view.findViewById(R.id.imageButton2);

        //getting the hero of the specified position
        ticket ticket = ticketList.get(position);

        //adding values to the list item
        textViewName.setText(ticket.getSujet());
        textViewTeam.setText(ticket.getDate());
        textViewTdes.setText(ticket.getPlace());

        //adding a click listener to the button to remove item from the list
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeticket(position);

            }
        });

        //finally returning the view
        return view;
    }
    private void removeticket(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setTitle("Are you sure you want to use this Ticket ?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                ticketList.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
