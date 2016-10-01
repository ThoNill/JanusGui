package org.janus.gui.actions;

import java.awt.Color;

import org.janus.gui.basis.GuiComponent;

public class SetTextColor implements GuiAction {
    private String parameter;

    @Override
    public void perform(GuiComponent comp) {
        comp.setForeground(Color.decode(parameter));
    }

    public void setParameter(String name, String value) {
        parameter = value;
    }

}
