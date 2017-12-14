package lt.java.ten.uzduotis.Entities;

import lt.java.ten.uzduotis.Entities.Album;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {
    private Integer id;
    private String artistName;
    private Set<Album> albums;

    public Artist(){}

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", albums=" + albums +
                '}';
    }
}
