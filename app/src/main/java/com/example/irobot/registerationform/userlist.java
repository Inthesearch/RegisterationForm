package com.example.irobot.registerationform;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class userlist extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Arrayadapter ar;
    ArrayList<UserDetails> list;
    ContentResolver resolver;
    ListView listView;
    UserDetails user;
    int position;
    EditText searchtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        resolver = getContentResolver();
        listView = (ListView) findViewById(R.id.listview);
        retrieveData();
        searchtxt = (EditText)findViewById(R.id.searchtxt);
        searchtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String str = s.toString();
                if(ar!=null){
                    ar.filter(str);



                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    public void retrieveData() {

        list = new ArrayList<>();

        String[] projection = {Util.COL_ID, Util.COL_Email, Util.COL_fname, Util.COL_lname, Util.COL_Username, Util.COL_password, Util.COL_gender};

        Log.i("Test", "Success");
        Cursor cursor = resolver.query(Util.URI, projection, null, null, null);

        if (cursor != null) {
            int i = 0;
            String e = "", fname = "", lname = "", username = "", password = "", gender = "";

            while (cursor.moveToNext()) {
                i = cursor.getInt(cursor.getColumnIndex(Util.COL_ID));
                e = cursor.getString(cursor.getColumnIndex(Util.COL_Email));
                fname = cursor.getString(cursor.getColumnIndex(Util.COL_fname));
                lname = cursor.getString(cursor.getColumnIndex(Util.COL_lname));
                username = cursor.getString(cursor.getColumnIndex(Util.COL_Username));
                password = cursor.getString(cursor.getColumnIndex(Util.COL_password));
                gender = cursor.getString(cursor.getColumnIndex(Util.COL_gender));

                list.add(new UserDetails(i,username, password, e, fname, lname, gender));
            }

            ar = new Arrayadapter(this, R.layout.listitem, list);
            listView.setAdapter(ar);
            listView.setOnItemClickListener(this);


        }


    }


    public void showOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"View", "Delete", "Update"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        showUser();
                        break;
                    case 1:
                        deleteUser();
                        break;
                    case 2 :
                        updateUser();

                }
            }
        });

        builder.create().show();
    }

    public void showUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Details:");
        builder.setMessage(user.toString());
        builder.setPositiveButton("Done", null);
        builder.create().show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
        user = list.get(position);
        showOptions();
    }

    public void deleteUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete "+user.getUsername());
        builder.setMessage("Are you sure want to delete?");
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String where = Util.COL_ID+"="+user.getId();
                int j = resolver.delete(Util.URI,where,null);
                if(j>0){
                    list.remove(position);
                    ar.notifyDataSetChanged();
                    Toast.makeText(userlist.this,user.getUsername()+"deleted..",Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton("cancel",null);
        builder.create().show();


    }


    public void updateUser(){

        Intent intent = new Intent(userlist.this,MainActivity.class);
        intent.putExtra("keyUser",  user);
        startActivity(intent);


    }

}
