package co.com.url_shortener.model.common.ex;

import lombok.Getter;

@Getter
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private long errorCode;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
