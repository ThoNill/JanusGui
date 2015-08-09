package org.janus.gui.basis;

import java.util.List;

/**
 * Interface f�r GUI Objekte, imitiert JComponent von Swing
 * 
 * @author THOMAS
 * 
 */
public interface RootGuiComponent extends GuiComponent  {

	List<GuiComponent> getAllComponents();
	

	void setAllComponents(List<GuiComponent> components) ;
	

}
