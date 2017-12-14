package lt.java.ten.uzduotis.Services;

import lt.java.ten.uzduotis.Entities.Album;

public  interface AlbumService {

    Iterable<Album> showAlbums();
    Album albumById(Integer id);
    Album saveAlbum(Album album);

    void deleteAlbum(Integer id);
}
