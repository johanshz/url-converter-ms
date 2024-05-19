package co.com.url_shortener.model.traceability;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Traceability {
    private Integer id;
    private String ip;
    private String uniqueId;
    private String registrationDate;
}
