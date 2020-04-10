package com.whichcollege.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.whichcollege.app.R;
import com.whichcollege.app.adapter.AllUserViewAdapter;
import com.whichcollege.app.chats.AllChatsUser;
import com.whichcollege.app.model.ChatData;

import java.util.ArrayList;
import java.util.List;

public class GroupDetails extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rough);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView viewPager = (RecyclerView) findViewById(R.id.recyclerview);

        TextView groupName = (TextView)findViewById(R.id.groupName);
        Bundle bundle = getIntent().getExtras();
        String userName = bundle.getString("GroupName");
       // groupName.setText(userName);


        LinearLayout back = (LinearLayout)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupDetails.this, AllChatsUser.class);
                startActivity(intent);

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

    }


}
