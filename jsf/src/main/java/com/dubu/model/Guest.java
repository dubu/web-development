package com.dubu.model;

import java.io.Serializable;

/**
 * User: Administrator
 * Date: 13. 4. 4
 * Time: ?? 5:39
 */
public class Guest implements Serializable {

    String name ;
    String message ;
    String modifiedDate;


    public Guest(String name, String message, String modifiedDate) {
        this.name = name;
        this.message = message;
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    @Override
    public String toString() {
        return getName();
    }
}
