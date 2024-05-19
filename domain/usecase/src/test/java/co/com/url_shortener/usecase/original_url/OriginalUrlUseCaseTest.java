package co.com.url_shortener.usecase.original_url;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.traceability.Traceability;
import co.com.url_shortener.model.traceability.gateway.TraceabilityRepository;
import co.com.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
 class OriginalUrlUseCaseTest {
    @InjectMocks
    private OriginalUrlUseCase originalUrlUseCase;

    @Mock
    private  TraceabilityRepository traceabilityRepository;

    @Mock
    private  UrlShortenerRepository urlShortenerRepository;

    private final String  UNIQUE_ID = "54ds4d";

    @Test
    void getOriginalUrl() throws ServiceException {
       final  String LARGE_URL_EXPECT = "https://www.youtube.com/watch?v=z7L4FH7jvIc";
        Mockito.when(urlShortenerRepository.originalUrl(anyString()))
                .thenReturn(LARGE_URL_EXPECT);
        String originalUrlResponse =  originalUrlUseCase.handle(UNIQUE_ID);
        Assertions.assertEquals(originalUrlResponse,LARGE_URL_EXPECT);
    }
    @Test
    void getOriginalUrlTestError(){
        final String ERROR = "Error";
        Mockito.when(urlShortenerRepository.originalUrl(anyString())).thenThrow(new RuntimeException(ERROR));
        try {
            originalUrlUseCase.handle(UNIQUE_ID);
        } catch (ServiceException e) {
            Assertions.assertTrue(e.getMessage().contains(ERROR));
        }
    }


}
