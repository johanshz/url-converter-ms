package co.com.url_shortener.model.traceability;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AccumulatedIp {
    private String ip;
    private long ipOccurrences;
    private String uniqueId;
    private String originalUrl;


    public AccumulatedIp(String ip, long ipOccurrences,String uniqueId,String originalUrl) {
        this.ip = ip;
        this.ipOccurrences = ipOccurrences;
        this.uniqueId = uniqueId;
        this.originalUrl = originalUrl;

    }
}
