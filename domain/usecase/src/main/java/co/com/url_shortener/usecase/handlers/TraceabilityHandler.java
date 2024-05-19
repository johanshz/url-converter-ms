package co.com.url_shortener.usecase.handlers;

import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.model.traceability.AccumulatedIp;
import co.com.url_shortener.model.traceability.Traceability;

import java.util.List;

public interface TraceabilityHandler {
    List<Traceability> handle() throws ServiceException;
    List<AccumulatedIp> getAccumulatedIp() throws ServiceException;

}
