package com.whichcollege.app.chats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.whichcollege.app.R;
import com.whichcollege.app.activities.PlusActivity;
import com.whichcollege.app.adapter.AllUserViewAdapter;
import com.whichcollege.app.model.ChatData;

import java.util.ArrayList;
//import com.whichcollege.app.adapter.RecyclerViewAdapter;


public class AllChatsUser extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_chat_user);

        final EditText searchChat = (EditText)findViewById(R.id.search_chat);
        searchChat.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(AllChatsUser.this, "chat is searching...", Toast.LENGTH_SHORT).show();
                searchChat.setText(null);
                return false;
            }
        });



        ArrayList<ChatData> myAllUsers =new ArrayList<ChatData>();
        myAllUsers.add(new ChatData("Priyank Piyush","Navtesh: Where do I fill my i20 apply...","16","4:00 PM"));
        for(int i = 0 ; i < 25; i++){
            myAllUsers.add(new ChatData("Akash Kumar","Rohit: Where do I fill my i20 apply...","13","4:30 PM"));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        AllUserViewAdapter myAdapter = new AllUserViewAdapter(getApplication(),myAllUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);



        View plus = (View)findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent plusLoginIntent = new Intent(AllChatsUser.this, PlusActivity.class);
                startActivity(plusLoginIntent);
                finish();
            }
        });
    }



    public void hideKeyboard (View view){

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);

    }
}
