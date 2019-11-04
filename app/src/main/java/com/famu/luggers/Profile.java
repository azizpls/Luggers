package com.famu.luggers;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")


public class Profile extends ParseObject {

    // creating keys for different desired parse attributes
    public static final String FIRST_NAME = "firstName";
    public static final String KEY_USER ="user";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";


    ParseUser currentUser = ParseUser.getCurrentUser();

    // set and get methods for desired attribute


    // Associate each item with a user
    public void setOwner(ParseUser user) {
        put(KEY_USER, user);
    }

    public String getFirstName() {
        return getString(FIRST_NAME);
    }

    public String getLastName() {
        return getString(LAST_NAME);
    }

    public String getEmail() {
        return getString(EMAIL);
    }

    public void setFirstName(ParseUser parseUser) {
        put(FIRST_NAME, parseUser);
    }

    public void setLastName(ParseUser parseUser) {
        put(LAST_NAME, parseUser);
    }

    public void setEmail(ParseUser parseUser) {
        put(EMAIL, parseUser);
    }
}
