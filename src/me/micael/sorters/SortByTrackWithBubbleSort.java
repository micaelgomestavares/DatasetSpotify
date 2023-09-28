package src.me.micael.sorters;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;

public class SortByTrackWithBubbleSort implements Sorter {

    @Override
    public void sort(MusicCollection musicColection) {
        this.sortByNameWithBubbleSort(musicColection);
    }

    public void sortByNameWithBubbleSort(MusicCollection musicCollection) {
        int collectionLength = musicCollection.getTotalNumberOfMusics();

        for (int i = 1; i < collectionLength - 1; i++) {
            for (int j = 0; j < (collectionLength - 1) - i; j++) {
                if (musicCollection.getMusic(j).getTrack()
                        .compareToIgnoreCase(musicCollection.getMusic(j + 1).getTrack()) > 0) {
                    musicCollection.changeMusicPositions(j, j + 1);
                }
            }
        }
    }

}
