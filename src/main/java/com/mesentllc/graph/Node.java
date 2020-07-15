package com.mesentllc.graph;

public class Node {
    private final int node;
    private final Object object;
    private boolean checked;

    public Object getObject() {
        return object;
    }

    public boolean checked() {
        return checked;
    }

    public Node(int node, Object object) {
        this.node = node;
        this.object = object;
        checked = false;
    }

    void visit() {
        checked = true;
    }

    void reset() {
        checked = false;
    }
}
