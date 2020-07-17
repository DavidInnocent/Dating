package com.david.datingui.models;

public class TextMessages {
    String senderName,timeOfMessage,messageBody;
    int photoOfSender;

    public TextMessages(String senderName, String timeOfMessage, String messageBody, int photoOfSender) {
        this.senderName = senderName;
        this.timeOfMessage = timeOfMessage;
        this.messageBody = messageBody;
        this.photoOfSender = photoOfSender;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getTimeOfMessage() {
        return timeOfMessage;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public int getPhotoOfSender() {
        return photoOfSender;
    }
}
