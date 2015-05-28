package org.janus.gui.login;

public class UnsecureLoginAction extends LoginAction {

	public UnsecureLoginAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected LoginHandler getHandler() {
		return new UnsecureLoginHandler();
	}
}
