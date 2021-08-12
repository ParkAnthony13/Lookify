package parkanthony.lookify.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.lookify.models.SongModel;

@Repository
public interface SongRepository extends CrudRepository<SongModel, Long> {
	List<SongModel> findAll();
	List<SongModel> findByArtistContaining(String search);
	List<SongModel> findTop10ByOrderByRatingDesc();
}
