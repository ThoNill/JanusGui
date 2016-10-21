package org.janus.gui.basis;

import java.util.ArrayList;
import java.util.List;

import org.janus.actions.Action;
import org.janus.data.DataContext;
import org.janus.data.DataDescription;
import org.janus.data.DataDescriptionImpl;

public class JanusApplication extends DataDescriptionImpl implements Action {
    // public static final String PAGETAGS = "janus.tech.xml.tags.";
    // public static final String PAGEDIR = "pages/";

    private String name;
    private List<JanusPage> pages = new ArrayList<>();

    public JanusApplication(String name) {
        super();
        this.name = name;
    }

    public void addPage(JanusPage m) {
        int pos = getHandle(m.getName());
        m.setContextIndex(pos);
        m.setApplication(this);
        m.setIndex(pages.size());
        pages.add(m);
    }

    public JanusPage searchPage(String name) {
        for (JanusPage page : pages) {
            if (name.equals(page.getName())) {
                return page;
            }
        }
        return null;
    }

    public JanusPage getPage(int index) {
        return pages.get(index);
    }

    @Override
    public void configure(DataDescription description) {
        

    }

    @Override
    public JanusSession newContext() {
        return new JanusSession(this);
    }

    @Override
    public void perform(DataContext context) {

        JanusSession session = (JanusSession) context;
        if (session.isFirstOne()) {
            performPage(JanusSession.GLOBAL, session);
        }
        boolean hasToDo = true;
        do {
            hasToDo = performPage(session.getCurrentPage(), session)
                    || performPage(JanusSession.GLOBAL, session);
        } while (hasToDo);
    }

    private boolean performPage(int index, JanusSession session) {
        JanusPage page = getPage(index);
        PageContext context = session.getPageContext(page);
        page.perform(context);
        return !context.isTheActionEmpty();
    }

    public String getName() {
        return name;
    }

}
