package src.me.micael.entities;

import src.me.micael.model.Node;

public class Iterator {

    Node currentNode;

    public Iterator(Node node) {
        this.currentNode = node;
    }

    public boolean hasNext() {
        if (this.currentNode.getNext() != null) {
            return true;
        }
        return false;
    }

    public void getNext() {
        this.currentNode = this.currentNode.getNext();
    }

}
