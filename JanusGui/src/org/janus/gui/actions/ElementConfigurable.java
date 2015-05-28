package org.janus.gui.actions;

import org.jdom2.Element;

public interface ElementConfigurable {

	void configure(Element elem);

	default String getString(Element elem, String attribut, String defValue) {
		String result = elem.getAttributeValue(attribut);
		if (result == null) {
			result = defValue;
		}
		return result;
	}

	default int getInt(Element elem, String attribut, int defValue) {
		String result = elem.getAttributeValue(attribut);
		if (result == null) {
			return defValue;
		} else {
			return Integer.parseInt(result);
		}
	}
}
