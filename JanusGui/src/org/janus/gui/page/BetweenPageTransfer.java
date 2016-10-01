package org.janus.gui.page;

import java.io.Serializable;

import org.janus.dict.actions.NamedActionReference;
import org.janus.gui.basis.PageContext;

public class BetweenPageTransfer {
    private NamedActionReference fromValue;
    private NamedActionReference toValue;

    public BetweenPageTransfer(String fromName, String toName) {
        super();
        this.fromValue = new NamedActionReference(fromName);
        this.toValue = new NamedActionReference(toName);
    }

    public void transfer(PageContext to, PageContext from) {
        Serializable value = fromValue.getObject(from);
        toValue.setObject(to, value);
    }

}
