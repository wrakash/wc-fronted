package com.whichcollege.app.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.whichcollege.app.R;

public class GroupChatFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_chat_freagment);

        final EditText messageSend = (EditText)findViewById(R.id.messageSend);
        messageSend.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(GroupChatFragment.this, "Message Send", Toast.LENGTH_SHORT).show();
                messageSend.setText(null);
                return false;
            }
        });

        TextView groupName = (TextView)findViewById(R.id.groupName);
        Bundle bundle = getIntent().getExtras();
        String userName = bundle.getString("GroupName");
        groupName.setText(userName);

        View back = (View)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plusLoginIntent = new Intent(GroupChatFragment.this, AllChatsUser.class);
                startActivity(plusLoginIntent);
            }
        });
    }

    public void hideKeyboard (View view){

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);

    }



}
