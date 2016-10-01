package org.janus.gui.page;

import java.util.ArrayList;
import java.util.List;

import org.janus.gui.basis.JanusPage;
import org.janus.gui.basis.JanusSession;
import org.janus.gui.basis.PageContext;

public class BetweenPageTransferSet {
    private List<BetweenPageTransfer> transfer;

    public BetweenPageTransferSet() {
        transfer = new ArrayList<>();
    }

    public int size() {
        return transfer.size();
    }

    public void addElement(BetweenPageTransfer obj) {
        transfer.add(obj);
    }

    public boolean removeElement(Object obj) {
        return transfer.remove(obj);
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
