package lt.java.ten.uzduotis.Entities;

import javax.persistence.*;

@Entity
public class Album {
    private Integer id;
    private String albumName;
    private Artist artist;

    public Album(){}

    public Album(String albumName) {
        this.albumName = albumName;
    }
    public Album(String albumName, Artist artist) {
        this.albumName = albumName;
        this.artist = artist;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist(){
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
