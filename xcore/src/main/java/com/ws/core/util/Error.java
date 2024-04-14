package com.ws.core.util;

public class Error {
	
	public static final int CODE = 404;
	public static final int LEVEL = 1;
	public static final String TEXT = "PingService.doPing.error_text";

    public static final int    ADDRESS_SERVICE_PERSIST_CODE    = 422;
    public static final int    ADDRESS_SERVICE_PERSIST_LEVEL   = 1;
    public static final String ADDRESS_SERVICE_PERSIST_TEXT    = "AddressService.persist.error_text";

    public static final int    ADDRESS_SERVICE_UPDATE_CODE     = 422;
    public static final int    ADDRESS_SERVICE_UPDATE_LEVEL    = 1;
    public static final String ADDRESS_SERVICE_UPDATE_TEXT     = "AddressService.update.error_text";

    public static final int    ADDRESS_SERVICE_DELETE_CODE     = 422;
    public static final int    ADDRESS_SERVICE_DELETE_LEVEL    = 1;
    public static final String ADDRESS_SERVICE_DELETE_TEXT     = "AddressService.delete.error_text";

    public static final int    ADDRESS_SERVICE_FETCH_ALL_CODE  = 204;
    public static final int    ADDRESS_SERVICE_FETCH_ALL_LEVEL = 1;
    public static final String ADDRESS_SERVICE_FETCH_ALL_TEXT  = "AddressService.fetchAll.error_text";

    public static final int    ADDRESS_SERVICE_FETCH_CODE      = 204;
    public static final int    ADDRESS_SERVICE_FETCH_LEVEL     = 1;
    public static final String ADDRESS_SERVICE_FETCH_TEXT      = "AddressService.fetch.error_text";

}
