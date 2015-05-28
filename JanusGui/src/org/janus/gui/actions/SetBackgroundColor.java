package org.janus.gui.actions;

import java.awt.Color;

import org.janus.gui.basis.GuiComponent;

public class SetBackgroundColor implements GuiAction {
	String parameter;
	
	@Override
	public void perform(GuiComponent comp)  {
			comp.setBackground(Color.decode(parameter));
	}


	public void setParameter(String name, String value) {
		parameter = value;
	}

}

