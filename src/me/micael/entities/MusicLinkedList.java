package src.me.micael.entities;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;
import src.me.micael.model.Music;
import src.me.micael.model.Node;

public class MusicLinkedList implements MusicCollection {

    private Node initialNode;
    private Node lastNode;
    private int totalNumberOfMusics;

    Iterator getMusicIterator;
    private int getMusicIteratorPosition;

    Iterator changeMusicIterator;
    private int changeMusicIteratorPosition;

    public MusicLinkedList() {
        this.initialNode = null;
        this.lastNode = null;

        this.totalNumberOfMusics = 0;
        this.changeMusicIteratorPosition = 0;
        this.getMusicIteratorPosition = 0;

        this.changeMusicIterator = null;
        this.getMusicIterator = null;
    }

    @Override
    public boolean addMusic(Music music) {
        Node newNode = new Node(music);

        if (this.initialNode == null) {
            // Se a lista estiver vazia, o novo nó será o primeiro e o último
            this.initialNode = newNode;
            this.lastNode = newNode;
        } else {
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
            this.changeMusicIterator = new Iterator(this.initialNode);
            this.getMusicIterator = new Iterator(this.initialNode);
        }

        this.totalNumberOfMusics++;

        return true;
    }

    @Override
    public boolean deleteMusic(String musicName) {
        Node currentMusic = this.initialNode;
        Node previousMusic = null;

        if (this.initialNode != null) {
            while ((currentMusic.getNext() != null) && (!musicName.equals(currentMusic.getMusic().getTrack()))) {
                previousMusic = currentMusic;
                currentMusic = currentMusic.getNext();
            }
            if (musicName.equals(currentMusic.getMusic().getTrack())) {
                if (previousMusic == null) {
                    this.initialNode = initialNode.getNext();

                } else {
                    previousMusic.setNext(currentMusic.getNext());
                }
                this.totalNumberOfMusics--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Music getMusic(Integer musicPosition) {
        if (musicPosition > this.getMusicIteratorPosition) {
            while (this.getMusicIterator.hasNext() && musicPosition != getMusicIteratorPosition) {
                this.getMusicIterator.getNext();
                getMusicIteratorPosition++;
            }
        } else if (musicPosition < getMusicIteratorPosition) {
            this.getMusicIterator.currentNode = this.initialNode;
            getMusicIteratorPosition = 0;
            while (this.getMusicIterator.hasNext() && musicPosition != getMusicIteratorPosition) {
                this.getMusicIterator.getNext();
                getMusicIteratorPosition++;
            }
        }
        return this.getMusicIterator.currentNode.getMusic();

    }

    @Override
    public boolean changeMusicPositions(Integer pos1, Integer pos2) {
        Node auxiliar = null;
        Node auxiliar2 = null;

        try {
            if (pos1 > this.changeMusicIteratorPosition) {
                while ((this.changeMusicIterator.hasNext()) && (this.changeMusicIteratorPosition != pos1)) {
                    this.changeMusicIterator.getNext();
                    this.changeMusicIteratorPosition++;
                    auxiliar = this.changeMusicIterator.currentNode;
                }
            }

            else if ((pos1 < this.changeMusicIteratorPosition)) {
                this.changeMusicIterator.currentNode = this.initialNode;
                this.changeMusicIteratorPosition = 0;
                while ((this.changeMusicIterator.hasNext()) && (this.changeMusicIteratorPosition != pos1)) {
                    this.changeMusicIterator.getNext();
                    this.changeMusicIteratorPosition++;
                    auxiliar = this.changeMusicIterator.currentNode;
                }
            } else {
                auxiliar = this.changeMusicIterator.currentNode;
            }

            if ((auxiliar != null) && (pos2 > pos1)) {
                while ((this.changeMusicIterator.hasNext()) && (this.changeMusicIteratorPosition != pos2)) {
                    this.changeMusicIterator.getNext();
                    this.changeMusicIteratorPosition++;
                    auxiliar2 = this.changeMusicIterator.currentNode;
                }
            } else if ((auxiliar != null) && (pos2 < pos1)) {
                this.changeMusicIterator.currentNode = this.initialNode;
                this.changeMusicIteratorPosition = 0;
                while (this.changeMusicIteratorPosition != pos2) {
                    this.changeMusicIterator.getNext();
                    this.changeMusicIteratorPosition++;
                    auxiliar2 = this.changeMusicIterator.currentNode;
                }
            }

            else {
                auxiliar2 = this.changeMusicIterator.currentNode;
            }

            if (this.changeMusicIteratorPosition == pos2) {
                Music aux = auxiliar.getMusic();
                auxiliar.setMusic(auxiliar2.getMusic());
                auxiliar2.setMusic(aux);
                return true;
            }

        } catch (NullPointerException e) {
            System.out.println("Erro! Apontando pra null!");
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
