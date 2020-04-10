package com.whichcollege.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whichcollege.app.R;
import com.whichcollege.app.activities.GroupDetails;
import com.whichcollege.app.chats.GroupChatFragment;
import com.whichcollege.app.model.ChatData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by AKASH on 1/04/2020.
 */

public class AllUserViewAdapter extends RecyclerView.Adapter<AllUserViewAdapter.MyHolder> {

    private ArrayList<ChatData> mDataList;
    private Context context;

    public AllUserViewAdapter(Context allChatsUser, ArrayList<ChatData> mDataList) {
        this.context = allChatsUser;
        this.mDataList = mDataList;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_row, parent,false);
        MyHolder myUsersHolder = new MyHolder(view);
        return myUsersHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        ChatData myUsers = mDataList.get(position);
        holder.groupChat.setText(myUsers.getGroupChat());
        holder.lastMessage.setText(myUsers.getLastMessage());
        holder.unreadMessageCount.setText(myUsers.getUnreadMessageCount());
        holder.timeStatus.setText(myUsers.getTimeStatus());

        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GroupDetails.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("GroupName", holder.groupChat.getText().toString());
                context.startActivity(intent);
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, GroupChatFragment.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("GroupName", holder.groupChat.getText().toString());
                context.startActivity(intent);
            }
        });



    }

    public class MyHolder extends RecyclerView.ViewHolder{

        public TextView groupChat;
        public TextView lastMessage;
        public TextView unreadMessageCount;
        public TextView timeStatus;
        public ImageView onlineStatus;
        public LinearLayout layout;
        public CircleImageView profileImage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            groupChat =(TextView) itemView.findViewById(R.id.groupChat);
            lastMessage =(TextView) itemView.findViewById(R.id.lastMessage);
            unreadMessageCount =(TextView) itemView.findViewById(R.id.unreadMessageCount);
            timeStatus =(TextView) itemView.findViewById(R.id.timeStatus);
            layout =(LinearLayout)itemView.findViewById(R.id.messageLayout);
            profileImage=(CircleImageView) itemView.findViewById(R.id.profileImage);

            // profileIImage=(ImageView) itemView.findViewById(R.id.profileImage);
             //onlineStatus=(ImageView) itemView.findViewById(R.id.);

        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
