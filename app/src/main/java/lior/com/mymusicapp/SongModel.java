package lior.com.mymusicapp;

public class SongModel {

    private int id;
    private String singerName;
    private String songName;
    private String songImage;

    SongModel(String singerName, String songName, String songImage) {
        this.singerName = singerName;
        this.songName = songName;
        this.songImage = songImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImage() {
        return songImage;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }

}
