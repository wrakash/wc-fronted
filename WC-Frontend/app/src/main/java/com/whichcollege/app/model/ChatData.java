package com.whichcollege.app.model;

import android.widget.ImageView;
import android.widget.TextView;

public class ChatData {

   private String groupChat;
   private String lastMessage;
   private String unreadMessageCount;
   private String timeStatus;
  // private ImageView profileImage;
   //private ImageView onlineStatus;


    public ChatData(String groupChat, String lastMessage, String unreadMessageCount, String timeStatus) {
        this.groupChat = groupChat;
        this.lastMessage = lastMessage;
        this.unreadMessageCount = unreadMessageCount;
        this.timeStatus = timeStatus;
    }

    public String getGroupChat() {
        return groupChat;
    }

    public void setGroupChat(String groupChat) {
        this.groupChat = groupChat;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(String unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }

    public String getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        this.timeStatus = timeStatus;
    }

}
