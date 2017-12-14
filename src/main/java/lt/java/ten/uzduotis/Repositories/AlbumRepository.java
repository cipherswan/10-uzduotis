package lt.java.ten.uzduotis.Repositories;

import lt.java.ten.uzduotis.Entities.Album;
import lt.java.ten.uzduotis.Entities.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    @Override
    void delete(Album deleted);

    List<Album> findAll();

    Album findAllById(Integer id);

    Album save(Album persisted);

}
