package co.com.url_shortener.jpa;

import co.com.url_shortener.jpa.model.UrlShortenerEntity;
import co.com.url_shortener.jpa.repositories.UrlShortenerJpaRepository;
import co.com.url_shortener.model.url_shortener.UrlShortener;
import co.com.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UrlShortenerJpaAdapter implements UrlShortenerRepository {

   private final UrlShortenerJpaRepository urlShortenerJpaRepository;
    @Override
    public String save(UrlShortener urlShortener) {
        try{
            return  urlShortenerJpaRepository.save(buildUrlShortenerEntity(urlShortener)).getUniqueId();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String originalUrl(String uniqueId) {
        try {
            return urlShortenerJpaRepository.findByUniqueId(uniqueId).getOriginalUrl();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    private UrlShortenerEntity buildUrlShortenerEntity(UrlShortener urlShortener){
        return UrlShortenerEntity.builder()
                .originalUrl(urlShortener.getOriginalUrl())
                .uniqueId(urlShortener.getUniqueId())
                .build();
    }

}
