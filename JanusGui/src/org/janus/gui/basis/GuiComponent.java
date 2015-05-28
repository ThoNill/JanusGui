package org.janus.gui.basis;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.List;

import org.janus.gui.enums.GuiType;

/**
 * Interface für GUI Objekte, imitiert JComponent von Swing
 * 
 * @author THOMAS
 * 
 */
public interface GuiComponent extends Cloneable {

	 GuiType getGuiType();

	 void setForeground(Color c);

	 Color getForeground();

	 void setBackground(Color c);

	 Color getBackground();

	 void setEnabled(boolean b);

	 boolean isEnabled();

	 void setVisible(boolean b);

	 boolean isVisible();

	 void setFocus(boolean b);

	 boolean hasFocus();

	 void setStyle(String t);

	 String getStyle();

	 void setLabel(String t);

	 String getLabel();

	 void setTooltip(String t);

	 String getTooltip();

	 void setWidth(float w);

	 float getWidth();

	 void setHeight(float w);

	 float getHeight();

	 float getX();

	 void setX(float x);

	 float getY();

	 void setY(float y);

	 Font getFont();

	 void setFont(Font f);

	 void setGuiValue(Serializable v);

	 Serializable getGuiValue();

	 int getId();

	 void validate();
	 
	 void addComponent(GuiComponent comp);
	 
	 List<GuiComponent> getChildComponents();



}
