package org.janus.gui.login;

import javax.security.auth.login.LoginException;

public class UnsecureLoginHandler extends LoginHandler {

    public UnsecureLoginHandler() {

    }

    @Override
    public void login() throws LoginException {
        authenticated = true;
    }

}
