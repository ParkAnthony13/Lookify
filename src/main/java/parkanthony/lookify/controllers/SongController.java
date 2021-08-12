package parkanthony.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import parkanthony.lookify.models.SongModel;
import parkanthony.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	// landing page welcome
	@RequestMapping("/")
	public String landing() {
		return "/songs/index.jsp";
	}
	// show all songs page
	@RequestMapping("/dashboard")
	public String songList(Model model) {
		List<SongModel> songs = songService.allItems();
		model.addAttribute("songs",songs);
		return "/songs/dashboard.jsp";
	}
	// show all songs by artist
	@RequestMapping("/search/{artist}")
	public String artistList(Model model,@PathVariable("artist") String art) {
		List<SongModel> songs = songService.allItemsByCategory(art);
		model.addAttribute("songs",songs);
		model.addAttribute("art", art);
		return "/songs/songSearch.jsp";
	}
	// show top 10 by rating descending
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<SongModel> songs = songService.topTenByCategory();
		model.addAttribute("songs", songs);
		return "/songs/topTen.jsp";
	}
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("writer") String writer) {
		if(writer.equals("")) {
			return "redirect:/dashboard";
		} else {
			return "redirect:/search/"+writer;
		}
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") SongModel song) {
		return "/songs/new.jsp";
	}
	@RequestMapping(value="/songs/new",method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") SongModel song, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/songs/new.jsp";
    	} else {
    		songService.createItem(song);
    		return "redirect:/dashboard";
    	}
    }
	@RequestMapping("/songs/{id}")
    public String show(Model model,@PathVariable("id") Long id) {
    	System.out.println("showing???");
    	SongModel song = songService.findItem(id);
    	model.addAttribute("song", song);
    	return "/songs/show.jsp";
    }
    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	SongModel song = songService.findItem(id);
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") SongModel song, BindingResult result) {
        System.out.println("updating why");
    	if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
        	songService.updateItem(song);
            return "redirect:/dashboard";
        }
    }
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	System.out.println("WTFFFFFFFF");
    	songService.deleteItem(id);
        return "redirect:/dashboard";
    }
	
	//search by artist name
	
}
