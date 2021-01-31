package org.janus.gui.basis;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.swing.JComponent;
import org.janus.gui.enums.GuiField;
import org.janus.gui.enums.GuiType;
import org.jdom2.Attribute;
import org.jdom2.Element;

public class Attribut2GuiComponent {

    public Attribut2GuiComponent() {
        
    }
    
    public static void setElementAttributes(GuiComponent component,Element elem) {
    	for (Attribute a : elem.getAttributes()) {
    		try {
    			GuiField field = GuiField.valueOf(a.getName().toUpperCase());
    			Serializable value = string2Value(field,a.getValue());
    			setField(component,field,value);
    		} catch (IllegalArgumentException ex) {
    			// Attribute müssen nicht matchen
    		}
    	}
     }
    
    
    private static Color string2color(String name)  {
        try {
            Field field = java.awt.Color.class.getDeclaredField(name.toUpperCase());
            int modifiers = field.getModifiers();
            if (field.getType() == java.awt.Color.class && 
            		Modifier.isStatic(modifiers)
                    && Modifier.isPublic(modifiers)) {
                return (Color)field.get(null);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static Serializable string2Value(GuiField field, String value) {
        switch (field) {
        case BACKGROUND:
        case FOREGROUND:
        	 return string2color(value.toUpperCase());
        case FONT:
        	return Font.decode(value);
        case ENABLED:
        case VISIBLE:
        case FOCUS:
            return value.equals("true") || value.equals("TRUE");
        case WIDTH:
        case HEIGHT:
        case X:
        case Y:
            return Float.valueOf(value);
        default:
        	return (value==null) ? "" : value;
         }
		
	}

	public static void setField(GuiComponent component, GuiField field,
            Serializable value) {
		if (value==null) {
			return ;
		}
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
