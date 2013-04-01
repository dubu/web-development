package com.dubu.model;

/**
 * User: Administrator
 * Date: 13. 3. 28
 * Time: 오전 5:18
 */
public class MessageStore {

    private String message;

    public MessageStore() {

        setMessage("Hello Servlet User");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
