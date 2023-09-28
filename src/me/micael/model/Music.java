package src.me.micael.model;
public class Music {

    private String artist;
    private String track;
    private String danceability;
    private String energy;
    private String duration_min;
    private String likes;
    private String views;

    public Music(String artist, String track, String danceability, String energy, String duration_min, String likes,
            String views) {
        this.artist = artist;
        this.track = track;
        this.danceability = danceability;
        this.energy = energy;
        this.duration_min = duration_min;
        this.likes = likes;
        this.views = views;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getDanceability() {
        return danceability;
    }

    public void setDanceability(String danceability) {
        this.danceability = danceability;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getDuration_min() {
        return duration_min;
    }

    public void setDuration_min(String duration_min) {
        this.duration_min = duration_min;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

}
