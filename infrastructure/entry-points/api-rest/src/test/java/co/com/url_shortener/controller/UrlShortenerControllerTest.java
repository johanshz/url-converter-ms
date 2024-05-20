package co.com.url_shortener.controller;

import co.com.url_shortener.controller.dto.AccumulatedIpResponseDto;
import co.com.url_shortener.controller.dto.TraceabilityResponseDto;
import co.com.url_shortener.controller.dto.UrlShortenerRequestDto;
import co.com.url_shortener.controller.dto.UrlShortenerResponseDto;
import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.traceability.AccumulatedIp;
import co.com.url_shortener.model.traceability.Traceability;
import co.com.url_shortener.usecase.handlers.GetOriginalUrlHandler;
import co.com.url_shortener.usecase.handlers.TraceabilityHandler;
import co.com.url_shortener.usecase.handlers.UrlShortenerHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class UrlShortenerControllerTest {
    @InjectMocks
    private UrlShortenerController urlShortenerController;

    @Mock
    private  UrlShortenerHandler urlShortenerHandler;
    @Mock
    private  GetOriginalUrlHandler getOriginalUrlHandler;
    @Mock
    private  TraceabilityHandler traceabilityHandler;

    private final String UNIQUE_ID = "5f4s5d";

    private final String TEXT = "text";

    @Test
    void urlShortenerTest() throws ServiceException {
        final String LARGE_URL = "https://www.youtube.com/watch?v=z7L4FH7jvIc";
        Mockito.when(urlShortenerHandler.handle(anyString()))
                .thenReturn(UNIQUE_ID);
        UrlShortenerRequestDto urlShortenerRequestDto = UrlShortenerRequestDto.builder()
                .originalUrl(LARGE_URL)
                .build();
        UrlShortenerResponseDto urlShortenerResponse = urlShortenerController.urlShortener(urlShortenerRequestDto);
        Assertions.assertEquals(urlShortenerResponse.getUniqueId(),UNIQUE_ID);
    }
    @Test
    void getOriginalUrlTest() throws ServiceException, UnknownHostException {
        final int  STATUS_CODE_EXPECT = 302;
        Mockito.when(getOriginalUrlHandler.handle(anyString()))
                .thenReturn(UNIQUE_ID);

        ResponseEntity<Void> response = urlShortenerController.getOriginalUrl(UNIQUE_ID);
        Assertions.assertEquals(response.getStatusCode().value(),STATUS_CODE_EXPECT);
    }
    @Test
    void getTraceabilityTest() throws ServiceException {
        List<Traceability> traceabilityList = new ArrayList<>();

        traceabilityList.add(Traceability.builder()
                        .ip(TEXT)
                        .registrationDate(TEXT)
                        .uniqueId(TEXT)
                .build());
        Mockito.when(traceabilityHandler.handle())
                .thenReturn(traceabilityList);
        List<TraceabilityResponseDto> traceabilityListResponse = urlShortenerController.getTraceability();
        Assertions.assertEquals(traceabilityListResponse.get(0).getIp(),TEXT);
    }
    @Test
    void getAccumulatedIpTest() throws ServiceException {
        List<AccumulatedIp> accumulatedIpList = new ArrayList<>();
        accumulatedIpList.add(AccumulatedIp.builder()
                        .ip(TEXT)
                        .ipOccurrences(1L)
                .build());
        Mockito.when(traceabilityHandler.getAccumulatedIp()).thenReturn(accumulatedIpList);
        List<AccumulatedIpResponseDto> response = urlShortenerController.getAccumulatedIp();
        Assertions.assertEquals(TEXT,response.get(0).getIp());
    }
}
