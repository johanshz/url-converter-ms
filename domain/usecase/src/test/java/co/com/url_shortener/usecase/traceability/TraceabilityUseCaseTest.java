package co.com.url_shortener.usecase.traceability;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.traceability.Traceability;
import co.com.url_shortener.model.traceability.gateway.TraceabilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
 class TraceabilityUseCaseTest {
    @InjectMocks
    private TraceabilityUseCase traceabilityUseCase;

    @Mock
    private  TraceabilityRepository traceabilityRepository;



    @Test
    void getTraceabilityTest() throws ServiceException {
        final String TEXT = "1";
        List<Traceability> traceabilityListExpect = new ArrayList<>();
            traceabilityListExpect.add(Traceability.builder()
                            .ip(TEXT)
                            .uniqueId(TEXT)
                            .registrationDate(TEXT)
                    .build());
        Mockito.when(traceabilityRepository.findAll())
                .thenReturn(traceabilityListExpect);
        List<Traceability> traceabilityListResponse = traceabilityUseCase.handle();
        Assertions.assertEquals(traceabilityListResponse.get(0).getUniqueId(),traceabilityListExpect.get(0).getUniqueId());
    }

    @Test
    void getTraceabilityError(){
         final String ERROR = "Error";
        Mockito.when(traceabilityRepository.findAll()).thenThrow(new RuntimeException(ERROR));
        try {
            traceabilityUseCase.handle();
        } catch (ServiceException e) {
            Assertions.assertTrue(e.getMessage().contains(ERROR));
        }
    }
}
