package org.janus.gui.basis;

public class TableColumnDescription {
    private String className;
    private String header;
    private String name;

    public TableColumnDescription(String className, String header, String name) {
        super();
        this.className = className;
        this.header = header;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getHeader() {
        return header;
    }

}
