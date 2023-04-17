package makersApp.controller;

import makersApp.model.Music;
import makersApp.model.User;
import makersApp.repository.MusicRepository;
import makersApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity homePage() {
        List<Music> musicList = musicRepository.findAll();
        return new ResponseEntity(musicList, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity addMusic(@RequestParam(name = "Название музыки") String musicName,
                                   @RequestParam(name = "Автор музыки") String authorName,
                                   @RequestParam(name = "Жанр музыки", required = false) String genre,
                                   @RequestParam(name = "Ссылка на YouTube", required = false) String link,
                                   @RequestParam(name = "Название альбома", required = false) String albumName,
                                   @RequestParam(name = "Год выпуска") int year) {
        Music music = new Music();
        music.setName(musicName);
        music.setAuthor(authorName);
        music.setGenre(genre);
        music.setLink(link);
        music.setAlbum(albumName);
        music.setYear(year);
        musicRepository.save(music);
        return new ResponseEntity(music, HttpStatus.OK);
    }

    @GetMapping("/user/search")
    public ResponseEntity searchMusic(@RequestParam(name = "Название музыки") String name) {
        Optional<Music> optionalMusic = musicRepository.findByName(name);
        if (!optionalMusic.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalMusic, HttpStatus.OK);
    }

    @GetMapping("/user/filterByAuthor")
    public ResponseEntity filterByAuthor(@RequestParam(name = "Автор музыки") String authorName) {
        List<Music> authorsMusic = musicRepository.findByAuthor(authorName);
        if (authorsMusic.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(authorsMusic, HttpStatus.OK);
    }

    @GetMapping("/user/filterByGenre")
    public ResponseEntity filterByGenre(@RequestParam(name = "Жанр музыки") String genre) {
        List<Music> genresMusic = musicRepository.findByGenre(genre);
        if (genresMusic.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(genresMusic, HttpStatus.OK);
    }

    @GetMapping("/user/filterByName")
    public ResponseEntity filterByName(@RequestParam(name = "Название музыки") String musicName) {
        Optional<Music> musicOptional = musicRepository.findByName(musicName);
        if (!musicOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(musicOptional, HttpStatus.OK);
    }

    @GetMapping("/user/addFavorite")
    public ResponseEntity favorite(User user, @RequestParam(name = "") String musicName) {
        Music music = musicRepository.findByName(musicName).get();
        user.getYourFavorite().add(music.getName());
        music.setRating(music.getRating() + 5);
        musicRepository.save(music);
        userRepository.save(user);
        return new ResponseEntity(user.getYourFavorite(), HttpStatus.OK);
    }

    @GetMapping("/user/recommendationsPopularity")
    public ResponseEntity popularityMusic() {
        if (musicRepository.findAll().size() < 10) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Music> musicList = musicRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"))
                .stream().limit(10).collect(Collectors.toList());
        return new ResponseEntity(musicList, HttpStatus.OK);
    }

    @GetMapping("/user/recommendationsNew")
    public ResponseEntity recommendationsNew() {
        if (musicRepository.findAll().size() < 5) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Music> lastMusic = new ArrayList<>();
        for (int i = musicRepository.findAll().size(); i > musicRepository.findAll().size() - 5; i--) {
            lastMusic.add(musicRepository.findById(i).get());
        }
        return new ResponseEntity(lastMusic, HttpStatus.OK);
    }

    @PostMapping("/user/addRating")
    public ResponseEntity addRating(@RequestParam(name = "Название музыки") String name) {
        Optional<Music> optionalMusic = musicRepository.findByName(name);
        if (!optionalMusic.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        optionalMusic.get().setRating(optionalMusic.get().getRating() + 5);
        musicRepository.save(optionalMusic.get());
        return new ResponseEntity(optionalMusic.get(), HttpStatus.OK);
    }

    @GetMapping("/user/recommendationsOur")
    public ResponseEntity ourRecommendations() {
        if (musicRepository.findAll().size() < 5) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Music> ourMusic = new ArrayList<>();
        for (int i = musicRepository.findAll().size(); i > 0; i--) {
            if (musicRepository.findById(i).get().getRating() > 10) {
                ourMusic.add(musicRepository.findById(i).get());
            }
            if (ourMusic.size() == 5) {
                break;
            }
        }
        return new ResponseEntity(ourMusic, HttpStatus.OK);
    }
}