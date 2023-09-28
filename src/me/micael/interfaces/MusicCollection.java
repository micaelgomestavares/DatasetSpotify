package src.me.micael.interfaces;

import src.me.micael.model.Music;

public interface MusicCollection {

    public Music getMusic(Integer musicPosition);

    public boolean addMusic(Music music);

    public boolean deleteMusic(String musicName);

    public boolean changeMusicPositions(Integer pos1, Integer pos2);

    public boolean changeMusic(Integer musicPosition, Music newMusic);

    public Integer getTotalNumberOfMusics();

    public void sortColection(Sorter sorter);

}