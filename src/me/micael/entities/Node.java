package src.me.micael.entities;

public class Node {

    private Music music;
    private Node next;

    public Node(Music music) {
        this.music = music;
        this.next = null;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music newMusic) {
        this.music = newMusic;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
