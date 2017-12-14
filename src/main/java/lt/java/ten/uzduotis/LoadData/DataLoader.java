package lt.java.ten.uzduotis.LoadData;

import lt.java.ten.uzduotis.Entities.Album;
import lt.java.ten.uzduotis.Entities.Artist;
import lt.java.ten.uzduotis.Repositories.AlbumRepository;
import lt.java.ten.uzduotis.Repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setAlbumRepository(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Artist pinkFloyd = new Artist("Pink Floyd");
        Artist swans = new Artist("Swans");

        artistRepository.save(pinkFloyd);
        artistRepository.save(swans);

        albumRepository.save(new Album("Dark Side of the Moon", pinkFloyd));
        albumRepository.save(new Album("Wish You Were Here", pinkFloyd));
        albumRepository.save(new Album("Animals", pinkFloyd));
        albumRepository.save(new Album("The Seer", swans));
        albumRepository.save(new Album("To Be Kind", swans));
    }
}
