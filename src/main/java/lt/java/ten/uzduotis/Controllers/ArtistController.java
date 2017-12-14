package lt.java.ten.uzduotis.Controllers;

import lt.java.ten.uzduotis.Entities.Artist;
import lt.java.ten.uzduotis.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }


    @RequestMapping("artist/new")
    public String newArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "artistform";
    }


    @RequestMapping(value = "artist", method = RequestMethod.POST)
    public String saveArtist(Artist artist){
        artistService.saveArtist(artist);
        return "redirect:/artist/" + artist.getId();
    }

    @RequestMapping("artist/{id}")
    public String showArtist(@PathVariable Integer id, Model model){
        model.addAttribute("artist", artistService.artistById(id));
        return "artistshow";
    }

    @RequestMapping("artist/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("artist", artistService.artistById(id));
        return "artistform";
    }

    @RequestMapping("artist/delete/{id}")
    public String delete(@PathVariable Integer id){
        artistService.deleteArtist(id);
        return "redirect:/artists";
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("artists", artistService.showArtists());
        return "artists";
    }
}

