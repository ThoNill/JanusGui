package org.janus.gui.page;

import org.janus.actions.Action;
import org.janus.data.DataContext;
import org.janus.data.DataDescription;
import org.janus.gui.actions.ElementConfigurable;
import org.janus.gui.basis.JanusPage;
import org.janus.gui.basis.JanusSession;
import org.janus.gui.basis.PageContext;
import org.jdom2.Element;

public class ChangePageAction implements Action, ElementConfigurable {
    String pageName;
    BetweenPageTransferSet transfer;

    public ChangePageAction() {
        transfer = new BetweenPageTransferSet();
    }

    @Override
    public void configure(DataDescription description) {

    }

    @Override
    public void perform(DataContext context) {
        if (context instanceof PageContext) {
            String toPageName = getPageName();
            JanusSession session = transferValues((PageContext) context,
                    toPageName);
            session.gotoPage(toPageName);
        }
    }

    protected JanusSession transferValues(PageContext fromContext,
            String toPageName) {
        JanusSession session = fromContext.getSession();
        JanusPage toPage = session.searchPage(toPageName);
        PageContext toContext = session.getPageContext(toPage);
        transfer.transfer(toContext, fromContext);
        return session;
    }

    protected String getPageName() {
        return pageName;
    }

    protected void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public void configure(Element elem) {
        setPageName(elem.getAttributeValue("pagename"));
    }

}
