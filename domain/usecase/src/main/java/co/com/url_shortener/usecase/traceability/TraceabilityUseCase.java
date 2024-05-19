package co.com.url_shortener.usecase.traceability;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.traceability.AccumulatedIp;
import co.com.url_shortener.model.traceability.Traceability;
import co.com.url_shortener.model.traceability.gateway.TraceabilityRepository;
import co.com.url_shortener.usecase.handlers.TraceabilityHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;


@Log
@RequiredArgsConstructor
public class TraceabilityUseCase implements TraceabilityHandler {
    private final TraceabilityRepository traceabilityRepository;
    @Override
    public List<Traceability> handle() throws ServiceException {
        try {
            log.info("Get Traceability");
            List<Traceability> traceabilityList = traceabilityRepository.findAll();
            Collections.reverse(traceabilityList);
            return traceabilityList;
        }catch (Exception e){
            log.severe("Error: " + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<AccumulatedIp> getAccumulatedIp() throws ServiceException {
        try {
            return traceabilityRepository.getAccumulatedIp();
        }catch (Exception e){
            log.severe("Error: " + e.getMessage());
            throw new ServiceException(e.getMessage());
        }

    }
}
