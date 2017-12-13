package lt.java.ten.uzduotis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path= "/demo")
public class MainController {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping(path = "/addartist")
    public @ResponseBody String addNewArtist (@RequestParam String name) {

        Artist artist = new Artist();
        artist.setArtistName(name);
        artistRepository.save(artist);

        return "record saved";
    }

    @GetMapping(path = "/addalbum")
    public @ResponseBody String addNewAlbum (@RequestParam String name) {

        Album album = new Album();
        album.setAlbumName(name);
        albumRepository.save(album);

        return "record saved";
    }

    @GetMapping(path = "/allartists")
    public @ResponseBody Iterable<Artist> getAllArtists() {
        //returns json or xml
        return artistRepository.findAll();
    }

    @GetMapping(path = "/allalbums")
    public @ResponseBody Iterable<Album> getAllAlbums() {
        //returns json or xml
        return albumRepository.findAll();
    }




}
