package com.example.irobot.registerationform;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iROBOT on 4/13/2017.
 */

public class Arrayadapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<UserDetails> list
            ;
    ArrayList<UserDetails> templist;


    public Arrayadapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<UserDetails> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        list = objects;
        templist = new ArrayList<>();
        templist.addAll(list);





    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView txtname = (TextView) convertView.findViewById(R.id.name);
        TextView txtemail = (TextView) convertView.findViewById(R.id.email);

        UserDetails ud = list.get(position);
        txtname.setText(ud.getUsername());
        txtemail.setText(ud.getEmail());

        return convertView;
    }

    public void filter(String str){

        if(str.length()>0){
            list.clear();
            for(UserDetails ud : templist){
                if(ud.getUsername().toLowerCase().contains(str.toLowerCase())){
                list.add(ud);
            }
        }}

        else{
           list.addAll(templist);
            }


    notifyDataSetChanged();
}






    }

