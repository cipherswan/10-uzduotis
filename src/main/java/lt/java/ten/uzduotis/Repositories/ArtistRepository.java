package lt.java.ten.uzduotis.Repositories;

import lt.java.ten.uzduotis.Entities.Artist;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    @Override
    void delete(Artist deleted);

    List<Artist> findAll();

    Artist findAllById(Integer id);

    Artist save(Artist persisted);
}
