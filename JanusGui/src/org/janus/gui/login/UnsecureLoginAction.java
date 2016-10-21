package org.janus.gui.login;

public class UnsecureLoginAction extends LoginAction {

    public UnsecureLoginAction() {
        
    }

    @Override
    protected LoginHandler getHandler() {
        return new UnsecureLoginHandler();
    }
}
