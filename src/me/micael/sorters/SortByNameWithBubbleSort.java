package src.me.micael.sorters;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;

public class SortByNameWithBubbleSort implements Sorter {

    @Override
    public void sort(MusicCollection musicColection) {
        this.sortByNameWithBubbleSort(musicColection);
    }

    public void sortByNameWithBubbleSort(MusicCollection musicCollection) {
        int collectionLength = musicCollection.getTotalNumberOfMusics();

        for (int i = 1; i < collectionLength - 1; i++) {
            for (int j = 1; j < collectionLength - i; j++) {
                String track1 = musicCollection.getMusic(j).getTrack();
                String track2 = musicCollection.getMusic(j + 1).getTrack();

                if (track1.compareToIgnoreCase(track2) > 0) {
                    musicCollection.changeMusicPositions(j, j + 1);
                }
            }
        }
    }

}
