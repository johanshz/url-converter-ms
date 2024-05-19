package co.com.url_shortener.usecase.handlers;

import co.com.url_shortener.model.common.ex.ServiceException;

import java.net.UnknownHostException;

public interface GetOriginalUrlHandler {
    String handle(String uniqueId) throws ServiceException, UnknownHostException;
}
