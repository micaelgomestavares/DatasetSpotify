package src.me.micael.entities;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (musicPosition >= 0 && musicPosition < this.totalNumberOfMusics) {
            MusicListIterator iterator = new MusicListIterator();

            // Iterar até a posição desejada
            for (int i = 0; i < musicPosition; i++) {
                iterator.next();
            }

            // Retornar a música na posição atual do iterador
            return iterator.currentNode.getMusic();
        }
        return null;
    }

    @Override
    public boolean changeMusicPositions(Integer pos1, Integer pos2) {
        if (pos1 != pos2 && pos1 < this.totalNumberOfMusics && pos2 < this.totalNumberOfMusics) {
            MusicListIterator iterator = new MusicListIterator();
            Node node1 = null;
            Node node2 = null;
            Node prevNode1 = null;
            Node prevNode2 = null;

            // Encontra o nó na posição pos1 usando o iterador e mantém o nó anterior
            for (int i = 0; i <= pos1 && iterator.hasNext(); i++) {
                prevNode1 = node1;
                node1 = iterator.currentNode;
                iterator.next();
            }

            // Reinicia o iterador para encontrar o nó na posição pos2 e mantém o nó
            // anterior
            iterator = new MusicListIterator();
            for (int i = 0; i <= pos2 && iterator.hasNext(); i++) {
                prevNode2 = node2;
                node2 = iterator.currentNode;
                iterator.next();
            }

            // Agora, você tem os nós node1 e node2 nas posições pos1 e pos2, bem como seus
            // nós anteriores

            if (node1 != null && node2 != null) {
                if (node1 == initialNode) {
                    initialNode = node2;
                } else {
                    prevNode1.setNext(node2);
                }

                if (node2 == initialNode) {
                    initialNode = node1;
                } else {
                    prevNode2.setNext(node1);
                }

                Node tempNext1 = node1.getNext();
                node1.setNext(node2.getNext());
                node2.setNext(tempNext1);

                return true;
            }
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

    @Override
    public Iterator<Music> iterator() {
        return new MusicListIterator();
    }

    private class MusicListIterator implements Iterator<Music> {
        private Node currentNode = initialNode;
        private Node previousNode = null;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Music next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Music music = currentNode.getMusic();
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            
            return music;
        }

        @Override
        public void remove() {
            if (previousNode == null) {
                // Caso 2: Removendo o nó inicial
                initialNode = currentNode.getNext();
            } else {
                // Caso 1: Removendo o último nó
                if (currentNode.getNext() == null) {
                    previousNode.setNext(null);
                } else {
                    // Caso 3: Removendo um nó intermediário
                    previousNode.setNext(currentNode.getNext());
                }
            }

            totalNumberOfMusics--;
        }

    }

}
