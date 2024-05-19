package co.com.url_shortener.usecase.url_shortener;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.url_shortener.UrlShortener;
import co.com.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import co.com.url_shortener.usecase.url_shortener.UrlShortenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UrlShortenerUseCaseTest {

    @InjectMocks
    private UrlShortenerUseCase urlShortenerUseCase;

    @Mock
    private  UrlShortenerRepository urlShortenerRepository;


    private final String LARGE_URL = "https://www.youtube.com/watch?v=z7L4FH7jvIc";
    @Test
    void getUniqueIdTest() throws ServiceException {
        final String UNIQUE_ID = "22a04c";
        Mockito.when(urlShortenerRepository.save(any()))
                .thenReturn(UNIQUE_ID);
        String uniqueIdResponse = urlShortenerUseCase.handle(LARGE_URL);
        Assertions.assertEquals(uniqueIdResponse,UNIQUE_ID);
    }

    @Test
    void getUniqueIdTestError(){
        final String ERROR = "Error";
        Mockito.when(urlShortenerRepository.save(any())).thenThrow(new RuntimeException(ERROR));
        try {
            urlShortenerUseCase.handle(LARGE_URL);
        } catch (ServiceException e) {
            Assertions.assertTrue(e.getMessage().contains(ERROR));
        }
    }

}
