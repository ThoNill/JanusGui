package org.janus.gui.builder;

import org.janus.actions.Action;
import org.janus.dict.actions.ActionDictionary;
import org.janus.gui.basis.GuiComponent;
import org.jdom2.Element;

public interface GuiElementBuilder {
	GuiComponent createGuiElement(Element elem,Action a,ActionDictionary dict);
}