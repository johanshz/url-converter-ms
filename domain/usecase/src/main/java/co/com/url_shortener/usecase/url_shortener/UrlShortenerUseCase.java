package co.com.url_shortener.usecase.url_shortener;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.url_shortener.UrlShortener;
import co.com.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import co.com.url_shortener.usecase.handlers.UrlShortenerHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;


import java.util.UUID;

@Log
@RequiredArgsConstructor
public class UrlShortenerUseCase implements UrlShortenerHandler {
    private final UrlShortenerRepository urlShortenerRepository;
    @Override
    public String handle(String originalUrl) throws ServiceException {
        log.info("Starting long url conversion: " + originalUrl);
        try{

            return urlShortenerRepository.save(buildUrlShortener(originalUrl,generateUniqueId()));
        }catch (Exception e){
            log.severe("Error: " + e.getMessage());
            throw new ServiceException(e.getMessage());
        }

    }
    private UrlShortener buildUrlShortener(String originalUrl, String uniqueId){
        return UrlShortener.builder()
                .originalUrl(originalUrl)
                .uniqueId(uniqueId)
                .build();
    }
    private  String generateUniqueId() {
        return UUID.randomUUID().toString().replace("-","").substring(0,6);
    }
}
