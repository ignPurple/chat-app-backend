package me.ignpurple.chatapp.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("messages")
public class UserMessage {
    @Id
    private String id;
    private String username;
    private String message;
    private long timestamp = System.currentTimeMillis();

    public UserMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }

    protected UserMessage() {}

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
