package co.com.url_shortener.model.traceability.gateway;

import co.com.url_shortener.model.traceability.AccumulatedIp;
import co.com.url_shortener.model.traceability.Traceability;

import java.util.List;

public interface TraceabilityRepository {
    void save(Traceability traceability);
    List<Traceability> findAll();
    List<AccumulatedIp> getAccumulatedIp();

}
