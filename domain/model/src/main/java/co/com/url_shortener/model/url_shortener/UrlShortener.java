package co.com.url_shortener.model.url_shortener;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UrlShortener {
    private Integer id;
    private String originalUrl;
    private String uniqueId;
}
