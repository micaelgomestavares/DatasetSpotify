package src.me.micael.entities;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;

public class MusicVector implements MusicCollection {

    Music[] musicVector;
    private int actualLength;
    private int vectorLength;

    public MusicVector(int maxLength) {
        this.musicVector = new Music[maxLength];
        this.vectorLength = maxLength;
        this.actualLength = 0;
    }

    @Override
    public boolean addMusic(Music music) {
        if (this.actualLength < this.vectorLength) {
            this.musicVector[this.actualLength] = music;
            this.actualLength++;
            return true;
        }
        return false;
    }

    @Override
    public boolean changeMusic(Integer musicPosition, Music newMusic) {
        if (newMusic != null && musicPosition >= 0 && musicPosition < musicVector.length) {
            this.musicVector[musicPosition] = newMusic;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeMusicPositions(Integer pos1, Integer pos2) {
        if (pos1 >= 0 && pos1 < musicVector.length && pos2 >= 0 && pos2 < musicVector.length) {

            Music auxiliarMusic = musicVector[pos1];
            musicVector[pos1] = musicVector[pos2];
            musicVector[pos2] = auxiliarMusic;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteMusic(String musicName) {
        boolean wasDeleted = false;
        int currentIndex = 0;

        for (int i = 0; i < this.actualLength; i++) {
            Music music = this.musicVector[i];

            if (music.getTrack().equalsIgnoreCase(musicName)) {
                wasDeleted = true;
            } else {
                this.musicVector[currentIndex] = music;
                currentIndex++;
            }
        }

        if (wasDeleted) {
            this.actualLength -= 1;
        }

        return wasDeleted;
    }

    @Override
    public Music getMusic(Integer musicPosition) {
        if (musicPosition >= 0 && musicPosition <= this.actualLength) {
            return this.musicVector[musicPosition];
        }
        return null;
    }

    @Override
    public Integer getTotalNumberOfMusics() {
        return this.actualLength;
    }

    @Override
    public void sortColection(Sorter sorter) {
        sorter.sort(this);
    }

}