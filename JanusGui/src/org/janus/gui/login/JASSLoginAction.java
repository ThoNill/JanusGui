package org.janus.gui.login;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

public class JASSLoginAction extends LoginAction {
    public static final Logger LOG = Logger.getLogger(JASSLoginAction.class);

    public JASSLoginAction() {

    }

    @Override
    protected LoginHandler getHandler() {
        try {
            return new JASSLoginHandler();
        } catch (LoginException e) {
            LOG.error("Fehler", e);
            ;
        }
        return null;
    }

}
