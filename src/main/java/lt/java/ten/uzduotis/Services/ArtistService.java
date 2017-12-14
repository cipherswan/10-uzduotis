package lt.java.ten.uzduotis.Services;

import lt.java.ten.uzduotis.Entities.Artist;

public interface ArtistService {

    Iterable<Artist> showArtists();
    Artist artistById(Integer id);
    Artist saveArtist(Artist artist);

    void deleteArtist(Integer id);
}
