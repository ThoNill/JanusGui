package org.janus.gui.basis;

import org.janus.data.DataContextImpl;
import org.janus.gui.login.LoginHandler;



public class JanusSession extends DataContextImpl {
	public static final int GLOBAL = 0;
	public static final int LOGIN = 1;

	private int currentPage;
	private boolean firstOne = true;
	private LoginHandler login = null;
	

	public JanusSession(JanusApplication model) {
		super(model);
		currentPage = LOGIN;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2774111693803641537L;

	public int getCurrentPage() {
		return (!isOpen()) ? LOGIN : currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isFirstOne() {
		return firstOne;
	}

	public void setFirstOne(boolean firstOne) {
		this.firstOne = firstOne;
	}

	public JanusApplication getApplicaton() {
		return (JanusApplication)getDataDescription();
	}

	public void perform() {
		getApplicaton().perform(this);
	}

	public boolean isOpen() {
		return (login == null) ? false : login.isAuthenticated();
	}

	public void setLogin(LoginHandler login) {
		this.login = login;
	}

	public JanusPage searchPage(String name)  {
		JanusPage page = getApplicaton().searchPage(name);
		getPageContext(page);
		return page;
	}

	public PageContext getPageContext(JanusPage page) {
		PageContext pageContext = (PageContext)getObject(page.getContextIndex());
		if (pageContext == null) {
			pageContext = createContextInSession(page);
		}
		return pageContext;
	}
	
		
	public PageContext createContextInSession(JanusPage page) {
		PageContext context = createDataContext(page);
		context.setSession(this);
		this.setObject(page.getContextIndex(), context);
		return context;
	}

	
	public PageContext createDataContext(JanusPage page) {
		return new PageContext(page);
	}

	public void gotoPage(String pageName) {
		if (isOpen()) {
			JanusPage page = searchPage(pageName);
			if (page != null) {
				currentPage = page.getIndex();
			}
		}
	}

}
