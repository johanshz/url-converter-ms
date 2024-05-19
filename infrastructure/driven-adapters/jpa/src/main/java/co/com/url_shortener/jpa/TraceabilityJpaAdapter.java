package co.com.url_shortener.jpa;

import co.com.url_shortener.jpa.model.TraceabilityEntity;
import co.com.url_shortener.jpa.repositories.TraceabilityJpaRepository;
import co.com.url_shortener.model.traceability.AccumulatedIp;
import co.com.url_shortener.model.traceability.Traceability;
import co.com.url_shortener.model.traceability.gateway.TraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TraceabilityJpaAdapter implements TraceabilityRepository {
    private final TraceabilityJpaRepository traceabilityJpaRepository;

    @Override
    public void save(Traceability traceability) {
        try{
            traceabilityJpaRepository.save(buildTraceabilityEntity(traceability));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Traceability> findAll() {
        try{
          return buildTraceabilityList(traceabilityJpaRepository.findAll());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<AccumulatedIp> getAccumulatedIp() {
        try{
            return traceabilityJpaRepository.getAccumulatedIp();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    private  List<Traceability> buildTraceabilityList(Iterable<TraceabilityEntity> entityIterable) {
        List<Traceability> traceabilityList = new ArrayList<>();
        for (TraceabilityEntity entity : entityIterable) {
            traceabilityList.add(Traceability.builder()
                            .ip(entity.getIp())
                            .registrationDate(entity.getRegistrationDate())
                            .uniqueId(entity.getUniqueId())
                    .build());
        }
        return traceabilityList;
    }
    private TraceabilityEntity buildTraceabilityEntity(Traceability traceability){
        return TraceabilityEntity.builder()
                .ip(traceability.getIp())
                .uniqueId(traceability.getUniqueId())
                .registrationDate(traceability.getRegistrationDate())
                .build();
    }
}
