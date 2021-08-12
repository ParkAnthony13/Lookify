package parkanthony.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.lookify.models.SongModel;
import parkanthony.lookify.respositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	// returns all the songs
    public List<SongModel> allItems() {
        return songRepository.findAll();
    }
    // returns songs by artist string search
    public List<SongModel> allItemsByCategory(String search) {
    	return songRepository.findByArtistContaining(search);
    }
    // return list of top 10 songs by rating desc
    public List<SongModel> topTenByCategory() {
    	return songRepository.findTop10ByOrderByRatingDesc();
    }
    // creates a book
    public SongModel createItem(SongModel b) {
        return songRepository.save(b);
    }
    // retrieves a book
    public SongModel findItem(Long id) {
        Optional<SongModel> optionalItem = songRepository.findById(id);
        if(optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            return null;
        }
    }
    public SongModel updateItem(SongModel b) {
    	return songRepository.save(b);
    }
    public void deleteItem(Long id) {
    	Optional<SongModel> optionalItem = songRepository.findById(id);
        if(optionalItem.isPresent()) {
        	songRepository.deleteById(id);
        }
    }
}
