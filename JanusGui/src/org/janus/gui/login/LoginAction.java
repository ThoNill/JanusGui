package org.janus.gui.login;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;
import org.janus.actions.Action;
import org.janus.actions.ReadValue;
import org.janus.data.DataContext;
import org.janus.data.DataDescription;
import org.janus.dict.actions.ActionDictionary;
import org.janus.gui.actions.ElementConfigurable;
import org.janus.gui.basis.JanusSession;
import org.janus.gui.basis.PageContext;
import org.jdom2.Element;

public abstract class LoginAction implements Action, ElementConfigurable {
    public static final Logger LOG = Logger.getLogger(LoginAction.class);
    protected String nameVar;
    protected String passwordVar;
    protected ReadValue name;
    protected ReadValue password;

    public LoginAction() {
    }

    @Override
    public void configure(Element elem) {
        nameVar = getString(elem, "nameVar", "name");
        passwordVar = getString(elem, "passwordVar", "password");
    }

    @Override
    public void configure(DataDescription description) {
        name = ((ActionDictionary) description).getAction(nameVar);
        password = ((ActionDictionary) description).getAction(passwordVar);
    }

    @Override
    public void perform(DataContext context) {
        if (context instanceof PageContext) {
            try {
                PageContext pageContext = (PageContext) context;
                JanusSession session = pageContext.getSession();
                LoginHandler handler = getHandler();
                handler.setName((String) name.getObject(context));
                handler.setPassword(password.getObject(context).toString()
                        .toCharArray());
                handler.login();
                session.setLogin(handler);
            } catch (LoginException e) {
                
                LOG.error("Fehler", e);
                ;
            }
        }

    }

    protected abstract LoginHandler getHandler();

}
