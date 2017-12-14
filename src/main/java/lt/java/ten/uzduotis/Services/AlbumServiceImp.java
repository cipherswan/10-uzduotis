package lt.java.ten.uzduotis.Services;

import lt.java.ten.uzduotis.Entities.Album;
import lt.java.ten.uzduotis.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImp implements AlbumService {

    private AlbumRepository albumRepository;

    @Autowired
    public void setAlbumRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Iterable<Album> showAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album albumById(Integer id) {
        return albumRepository.findAllById(id);
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Integer id) {
        albumRepository.delete(id);
    }
}
