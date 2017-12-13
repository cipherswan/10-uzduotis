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

    @GetMapping(path = "/add")
    public @ResponseBody String addNewArtist (@RequestParam String artistName) {

        Artist artist = new Artist();
        artist.setArtistName(artistName);
        artistRepository.save(artist);

        return "record saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Artist> getAllArtists() {
        //returns json or xml
        return artistRepository.findAll();
    }




}
