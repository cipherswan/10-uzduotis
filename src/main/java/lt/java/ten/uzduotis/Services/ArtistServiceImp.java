package lt.java.ten.uzduotis.Services;

import lt.java.ten.uzduotis.Entities.Artist;
import lt.java.ten.uzduotis.Repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImp implements ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Override
    public Iterable<Artist> showArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist artistById(Integer id) {
        return artistRepository.findAllById(id);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Integer id) {
        artistRepository.delete(id);
    }
}
