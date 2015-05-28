package org.janus.gui.basis;

import java.io.Serializable;

import org.janus.dict.actions.ActionDictionaryContext;


public class PageContext extends ActionDictionaryContext implements Serializable{
	private JanusSession session;
	
	public PageContext(JanusPage dict) {
		super(dict);
	}

	public JanusPage getPage() {
		return (JanusPage)getDataDescription();
	}
	
	public JanusSession getSession() {
		return session;
	}

	protected void setSession(JanusSession session) {
		this.session = session;
	}



}
