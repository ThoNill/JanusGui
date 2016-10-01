package org.janus.gui.basis;

import org.apache.log4j.Logger;
import org.janus.data.DataContext;
import org.janus.dict.actions.ActionDictionary;

public class JanusPage extends ActionDictionary {
    private int index;
    private int contextIndex;
    private JanusApplication application;
    private GuiComponent gui;

    public JanusPage(String name) {
        super(name);
    }

    public PageContext getContext(JanusSession session) {
        return session.getPageContext(this);
    }

    @Override
    public void debug(Logger log, DataContext session) {
        if (session instanceof JanusSession) {
            DataContext context = getContext((JanusSession) session);
            super.debug(log, context);
        } else {
            super.debug(log, session);
        }

    }

    public JanusApplication getApplication() {
        return application;
    }

    protected void setApplication(JanusApplication application) {
        this.application = application;
    }

    public int getIndex() {
        return index;
    }

    protected void setIndex(int index) {
        this.index = index;
    }

    public int getContextIndex() {
        return contextIndex;
    }

    protected void setContextIndex(int contextIndex) {
        this.contextIndex = contextIndex;
    }

    public GuiComponent getGui() {
        return gui;
    }

    public void setGui(GuiComponent gui) {
        this.gui = gui;
    }

}