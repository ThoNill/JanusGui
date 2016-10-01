package org.janus.gui.login;

import java.io.Serializable;

import javax.security.auth.login.LoginException;

public abstract class LoginHandler implements Serializable {

    protected String name;
    protected char[] password;
    protected boolean authenticated = false;

    public LoginHandler() {
        super();
    }

    public abstract void login() throws LoginException;

    public void logout() throws LoginException {
        authenticated = false;
    };

    public boolean isAuthenticated() {
        return authenticated;
    }

    public boolean hasCredential(String credential) {
        return authenticated;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setPassword(char[] password) {
        this.password = password;
    }

}