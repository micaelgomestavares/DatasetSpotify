package src.me.micael.sorters;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;
import src.me.micael.model.Music;

public class SortByArtistWithSelectionSort implements Sorter {

    @Override
    public void sort(MusicCollection musicColection) {
        this.sortByArtistWithSelectionSort(musicColection);
    }

    public void sortByArtistWithSelectionSort(MusicCollection musicColection) {
        int musicCollectionSize = musicColection.getTotalNumberOfMusics();
        int aux = 0;

        for (int i = 1; i < musicCollectionSize; i++) {
            Music smallest = musicColection.getMusic(i);

            for (int j = i + 1; j < musicCollectionSize; j++) {
                if ((musicColection.getMusic(j).getArtist().compareToIgnoreCase(smallest.getArtist())) < 0) {
                    smallest = musicColection.getMusic(j);
                    aux = j;
                }
            }

            if (aux != 0) {
                musicColection.changeMusicPositions(i, aux);
            }
        }
    }

}
