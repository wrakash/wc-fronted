package com.whichcollege.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whichcollege.app.R;
import com.whichcollege.app.chats.GroupChatFragment;
import com.whichcollege.app.model.ChatData;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class GroupDetrailsViewAdapter extends RecyclerView.Adapter<AllUserViewAdapter.MyHolder> {

    private ArrayList<ChatData> mDataList;
    private Context context;

    public GroupDetrailsViewAdapter(Context allChatsUser, ArrayList<ChatData> mDataList) {
        this.context = allChatsUser;
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public AllUserViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.group_details_row, parent,false);
        //AllUserViewAdapter.MyHolder myUsersHolder = new AllUserViewAdapter.MyHolder(view);
       // return myUsersHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final AllUserViewAdapter.MyHolder holder, int position) {
        ChatData myUsers = mDataList.get(position);
       // holder.groupName.setText(myUsers.);
       //holder.lastMessage.setText(myUsers.getLastMessage());
        //holder.unreadMessageCount.setText(myUsers.getUnreadMessageCount());
        //holder.timeStatus.setText(myUsers.getTimeStatus());

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

        public TextView groupName;
       // public TextView lastMessage;
        public TextView Description;
       // public TextView timeStatus;
        public ImageView profileIImage;
        //public ImageView onlineStatus;
        //public LinearLayout layout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            groupName =(TextView) itemView.findViewById(R.id.groupName);
            Description =(TextView) itemView.findViewById(R.id.description);
           // unreadMessageCount =(TextView) itemView.findViewById(R.id.unreadMessageCount);
          //  timeStatus =(TextView) itemView.findViewById(R.id.timeStatus);
          //  layout =(LinearLayout)itemView.findViewById(R.id.messageLayout);
            // profileIImage=(ImageView) itemView.findViewById(R.id.profileImage);
            //onlineStatus=(ImageView) itemView.findViewById(R.id.);

        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
