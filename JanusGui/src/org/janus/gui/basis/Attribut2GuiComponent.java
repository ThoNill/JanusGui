package org.janus.gui.basis;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JComponent;

import org.janus.gui.enums.GuiField;
import org.janus.gui.enums.GuiType;

public class Attribut2GuiComponent {

    public Attribut2GuiComponent() {
        // TODO Auto-generated constructor stub
    }

    public static void setField(GuiComponent component, GuiField field,
            Serializable value) {
        switch (field) {
        case TEXT:
            component.setLabel((String) value);
            break;
        case LABEL:
            setComponentLabel(component, (String) value);
            break;
        case BACKGROUND:
            component.setBackground((Color) value);
            break;
        case FOREGROUND:
            component.setForeground((Color) value);
            break;
        case FONT:
            component.setFont((Font) value);
            break;
        case ENABLED:
            component.setEnabled(((Boolean) value).booleanValue());
            break;
        case VISIBLE:
            component.setVisible(((Boolean) value).booleanValue());
            break;
        case FOCUS:
            component.setFocus(value.equals(Boolean.TRUE));
            break;
        case STYLE:
            component.setStyle((String) value);
            break;
        case TOOLTIP:
            if (component instanceof JComponent) {
                ((JComponent) component).setToolTipText((String) value);
            }
            break;
        case WIDTH:
            component.setWidth((float) value);
            break;
        case HEIGHT:
            component.setHeight((float) value);
            break;
        case X:
            component.setX((float) value);
            break;
        case Y:
            component.setY((float) value);
            break;
        case VALUE:
            break;
        default:
            break;
        }
    }

    private static void setComponentLabel(GuiComponent component, String value) {
        GuiType type = component.getGuiType();
        if (value != null && !(type == GuiType.MENUITEM)
                && !(type == GuiType.MENU) && !(type == GuiType.BUTTON)
                && !(type == GuiType.LABEL)) {
            component.setLabel(value);
        }
    }

}
