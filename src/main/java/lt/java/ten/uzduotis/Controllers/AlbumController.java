package lt.java.ten.uzduotis.Controllers;

import lt.java.ten.uzduotis.Entities.Album;
import lt.java.ten.uzduotis.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlbumController {
    private AlbumService albumService;

    @Autowired
    public void setAlbumService(AlbumService albumService){
        this.albumService = albumService;
    }

    @RequestMapping("album/new")
    public String newArtist(Model model){
        model.addAttribute("album", new Album());
        return "albumform";
    }


    @RequestMapping(value = "album", method = RequestMethod.POST)
    public String saveAlbum(Album album){
        albumService.saveAlbum(album);
        return "redirect:/album/" + album.getId();
    }

    @RequestMapping("album/{id}")
    public String showAlbum(@PathVariable Integer id, Model model){
        model.addAttribute("album", albumService.albumById(id));
        return "albumshow";
    }

    @RequestMapping("album/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("artist", albumService.albumById(id));
        return "albumform";
    }

    @RequestMapping("album/delete/{id}")
    public String delete(@PathVariable Integer id){
        albumService.deleteAlbum(id);
        return "redirect:/albums";
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("albums", albumService.showAlbums());
        return "albums";
    }
}
