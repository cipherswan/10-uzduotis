package lt.java.ten.uzduotis.Controllers;

import lt.java.ten.uzduotis.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("artists", artistService.showArtists());
        return "artists";
    }
}

