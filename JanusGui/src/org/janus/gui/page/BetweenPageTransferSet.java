package org.janus.gui.page;

import java.util.Vector;

import org.janus.gui.basis.JanusPage;
import org.janus.gui.basis.JanusSession;
import org.janus.gui.basis.PageContext;

public class BetweenPageTransferSet {
	private Vector<BetweenPageTransfer> transfer;

	public BetweenPageTransferSet() {
		transfer = new Vector<>();
	}

	public int size() {
		return transfer.size();
	}

	public void addElement(BetweenPageTransfer obj) {
		transfer.addElement(obj);
	}

	public boolean removeElement(Object obj) {
		return transfer.removeElement(obj);
	}

	public void transfer(PageContext to, PageContext from) {
		for (BetweenPageTransfer t : transfer) {
			t.transfer(to, from);
		}
	}

	public void transfer(String toPageName, String fromPageName,
			JanusSession session) {
		JanusPage fromPage = session.searchPage(fromPageName);
		JanusPage toPage = session.searchPage(toPageName);
		PageContext toContext = session.getPageContext(toPage);
		PageContext fromContext = session.getPageContext(fromPage);
		transfer(toContext, fromContext);
	}

}
