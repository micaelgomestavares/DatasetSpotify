package src.me.micael.entities;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;

public class MusicLinkedList implements MusicCollection {

    private Node initialNode;
    private Node lastNode;
    private int totalNumberOfMusics;

    public MusicLinkedList() {
        this.initialNode = null;
        this.lastNode = null;
        this.totalNumberOfMusics = 0;
    }

    @Override
    public boolean addMusic(Music music) {
        Node newNode = new Node(music);

        if (this.initialNode == null) {
            // Se a lista estiver vazia, o novo nó será o primeiro e o último
            this.initialNode = newNode;
            this.lastNode = newNode;
        } else {
            // Caso contrário, adiciona o novo nó após o último nó e atualiza o último nó
            // com o nó criado
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }

        this.totalNumberOfMusics++;

        return true;
    }

    public boolean deleteMusic(String musicName) {
        if (this.initialNode != null) {
            if (this.initialNode.getMusic().getTrack().equalsIgnoreCase(musicName)) {
                this.initialNode = this.initialNode.getNext();
                if (this.initialNode == null) {
                    this.lastNode = null;
                }
                this.totalNumberOfMusics--;
                return true;
            } else {
                Node auxNode = null;
                Node actualNode = this.initialNode;

                while (actualNode != null && !actualNode.getMusic().getTrack().equalsIgnoreCase(musicName)) {
                    auxNode = actualNode;
                    actualNode = actualNode.getNext();
                }

                if (actualNode != null && auxNode != null) {
                    auxNode.setNext(actualNode.getNext());
                    if (actualNode == this.lastNode) {
                        this.lastNode = auxNode;
                    }
                    this.totalNumberOfMusics--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Music getMusic(Integer musicPosition) {
        if (musicPosition < this.totalNumberOfMusics) {

            Node actualNode = this.initialNode;

            for (int i = 0; i < musicPosition; i++) {
                actualNode = actualNode.getNext();
            }

            return actualNode.getMusic();

        }
        return null;
    }

    @Override
    public boolean changeMusicPositions(Integer pos1, Integer pos2) {
        if (pos1 != pos2 && pos1 < this.totalNumberOfMusics
                && pos2 < this.totalNumberOfMusics) {

            Node auxNode = null;
            Node actualNode = this.initialNode;

            Node auxNode2 = null;
            Node actualNode2 = this.initialNode;

            for (int i = 0; i < pos1; i++) {
                auxNode = actualNode;
                actualNode = actualNode.getNext();
            }

            for (int i = 0; i < pos2; i++) {
                auxNode2 = actualNode2;
                actualNode2 = actualNode2.getNext();
            }

            if (auxNode == null) {
                this.initialNode = actualNode2;
            } else {
                auxNode.setNext(actualNode2);
            }

            if (auxNode2 == null) {
                this.initialNode = actualNode;
            } else {
                auxNode2.setNext(actualNode);
            }

            Node tempNo = actualNode.getNext();

            actualNode.setNext(actualNode2.getNext());
            actualNode2.setNext(tempNo);

            return true;
        }

        return false;
    }

    @Override
    public boolean changeMusic(Integer musicPosition, Music newMusic) {

        Node actualNode = this.initialNode;

        if (musicPosition < this.totalNumberOfMusics) {

            for (int i = 0; i < musicPosition; i++) {
                actualNode = actualNode.getNext();
            }
            actualNode.setMusic(newMusic);
            return true;

        }
        return false;
    }

    @Override
    public Integer getTotalNumberOfMusics() {
        return this.totalNumberOfMusics;
    }

    @Override
    public void sortColection(Sorter sorter) {
        sorter.sort(this);
    }

}
