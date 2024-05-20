package co.com.url_shortener.jpa.repositories;

import co.com.url_shortener.jpa.model.TraceabilityEntity;
import co.com.url_shortener.model.traceability.AccumulatedIp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceabilityJpaRepository extends CrudRepository<TraceabilityEntity,Integer> {

    @Query("SELECT new co.com.url_shortener.model.traceability.AccumulatedIp(t.ip, COUNT(t), t.uniqueId, us.originalUrl) " +
            "FROM TraceabilityEntity t " +
            "LEFT JOIN UrlShortenerEntity us ON t.uniqueId = us.uniqueId " +
            "GROUP BY t.ip, t.uniqueId, us.originalUrl " +
            "ORDER BY t.uniqueId DESC")
    List<AccumulatedIp> getAccumulatedIp();


}
