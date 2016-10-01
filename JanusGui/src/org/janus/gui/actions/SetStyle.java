package org.janus.gui.actions;

import org.janus.gui.basis.GuiComponent;

public class SetStyle implements GuiAction {
    String parameter;

    @Override
    public void perform(GuiComponent comp) {
        comp.setStyle(parameter);
    }

    public void setParameter(String name, String value) {
        parameter = value;
    }

}
