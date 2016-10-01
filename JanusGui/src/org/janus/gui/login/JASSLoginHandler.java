package org.janus.gui.login;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

public class JASSLoginHandler extends LoginHandler implements CallbackHandler {
    public static final Logger LOG = Logger.getLogger(JASSLoginHandler.class);
    transient LoginContext loginContext;

    public JASSLoginHandler() throws LoginException {
    }

    private LoginContext getContext() {
        if (loginContext == null) {
            try {
                loginContext = new LoginContext(name, this);
            } catch (LoginException e) {
                // TODO Auto-generated catch block
                LOG.error("Fehler", e);
                ;
            }
        }
        return loginContext;
    }

    @Override
    public void login() throws LoginException {
        getContext().login();
    }

    @Override
    public void logout() throws LoginException {
        getContext().logout();
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof TextOutputCallback) {

                // display the message according to the specified type
                TextOutputCallback toc = (TextOutputCallback) callbacks[i];
                switch (toc.getMessageType()) {
                case TextOutputCallback.INFORMATION:
                    System.out.println(toc.getMessage());
                    break;
                case TextOutputCallback.ERROR:
                    System.out.println("ERROR: " + toc.getMessage());
                    break;
                case TextOutputCallback.WARNING:
                    System.out.println("WARNING: " + toc.getMessage());
                    break;
                default:
                    throw new IOException("Unsupported message type: "
                            + toc.getMessageType());
                }

            } else if (callbacks[i] instanceof NameCallback) {

                // prompt the user for a username
                NameCallback nc = (NameCallback) callbacks[i];

                // ignore the provided defaultName
                System.err.print(nc.getPrompt());
                nc.setName(name);

            } else if (callbacks[i] instanceof PasswordCallback) {

                // prompt the user for sensitive information
                PasswordCallback pc = (PasswordCallback) callbacks[i];
                System.err.print(pc.getPrompt());
                System.err.flush();
                pc.setPassword(password);

            } else {
                throw new UnsupportedCallbackException(callbacks[i],
                        "Unrecognized Callback");
            }
        }
    }

    public Subject getSubject() {
        return getContext().getSubject();
    }

}
