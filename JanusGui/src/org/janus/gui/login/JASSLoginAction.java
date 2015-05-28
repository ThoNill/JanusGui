package org.janus.gui.login;

import javax.security.auth.login.LoginException;

public class JASSLoginAction extends LoginAction{

	public JASSLoginAction() {
		
	}

	@Override
	protected LoginHandler getHandler() {
		try {
			return new JASSLoginHandler();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		return null;
	}

}
