package org.janus.gui.basis;

import java.util.List;

import org.janus.actions.DataValue;



public interface TableGuiComponent extends GuiComponent {

	DataValue getCurrentRowValue();

	void setCurrentRow(int i);

	int getCurrentRow();
	
	List<TableColumnDescription> getDescriptions();
	
}
