package co.com.url_shortener.model.traceability;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AccumulatedIp {
    private String ip;
    private long ipOccurrences;

    public AccumulatedIp(String ip, long ipOccurrences) {
        this.ip = ip;
        this.ipOccurrences = ipOccurrences;
    }
}
