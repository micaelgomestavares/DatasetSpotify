package src.me.micael.tests;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;
import src.me.micael.model.Music;

public class MusicCollectionTest {

    static Music mock1 = new Music("Veigh", "Engana dizendo que ama", "0.2333", "3.002", "3.00", "50000", "200000");

    public static boolean testAddMusic(MusicCollection musicCollection) {
        return musicCollection.addMusic(mock1) ? true : false;
    }

    public static boolean testDeleteMusic(MusicCollection musicCollection) {
        return musicCollection.deleteMusic("The Scientist") ? true : false;
    }

    public static boolean testChangeMusicPositions(MusicCollection musicCollection) {
        return musicCollection.changeMusicPositions(20, 50) ? true : false;
    }

    public static boolean testChangeMusic(MusicCollection musicCollection) {
        return musicCollection.changeMusic(500, mock1) ? true : false;
    }

    public static void sort(MusicCollection musicCollection, Sorter sorter) {
        musicCollection.sortColection(sorter);
    }

}
