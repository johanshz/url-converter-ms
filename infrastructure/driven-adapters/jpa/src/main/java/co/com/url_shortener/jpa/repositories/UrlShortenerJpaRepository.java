package co.com.url_shortener.jpa.repositories;

import co.com.url_shortener.jpa.model.UrlShortenerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerJpaRepository extends CrudRepository<UrlShortenerEntity,Integer> {
    UrlShortenerEntity findByUniqueId(String uniqueId);

    Optional<UrlShortenerEntity> findByOriginalUrl(String url);

}
