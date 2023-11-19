package com.uhutown.messenger.chat;

import java.util.Date;
import java.util.Objects;

public class Message {

    private final Date date;
    private final ChatMember sender;
    private final String message;
    private final int id;

    public Message(final Date date, final ChatMember sender, final String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
        this.id = hashCode();
    }

    // TODO Write and Read Network

    public Date getDate() {
        return date;
    }

    public ChatMember getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageID() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, message, sender);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Message other = (Message) obj;
        return Objects.equals(date, other.date) && Objects.equals(message, other.message)
                && Objects.equals(sender, other.sender);
    }

    @Override
    public String toString() {
        return "Message [date=" + date + ",sender=" + sender + ",message=" + message + "]";
    }

}
