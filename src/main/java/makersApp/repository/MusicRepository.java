package makersApp.repository;

import makersApp.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
    Optional<Music> findByName(String musicName);

    List<Music> findByAuthor(String author);

    List<Music> findByGenre(String genre);
}