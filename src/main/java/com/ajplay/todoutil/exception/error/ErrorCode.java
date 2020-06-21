package com.ajplay.todoutil.exception.error;

public enum ErrorCode {

    ACCESS_DENIED("error.client.accessdenied"),
    NOT_AUTHORIZED("error.client.notauthorised"),
    NOT_ACCEPTABLE("error.client.notacceptable"),
    UNSUPPORTED_MEDIA_TYPE("error.client.unsupportedmediatype"),
    BAD_REQUEST("error.client.badrequest"),
    RESOURCE_NOT_FOUND("error.client.resource.notfound"),
    RESOURCE_CONFLICT("error.client.resource.conflict"),
    RESOURCE_PROPERTY_VALUE("error.client.resource.propertyvalue"),
    RESOURCE_LOCKED("error.client.resource.locked"),
    RESOURCE_GONE("error.client.resource.gone"),

    NOT_IMPLEMENTED("error.server.notimplemented"),
    INTERNAL_SERVER_ERROR("error.server.internalservererror"),
    GATEWAY_TIMEOUT("error.server.gatewaytimeout"),
    VERIFICATION_FAILED("error.client.verification.failed"),
    SQL_ERROR("error.server.sql"),
    EXTERNAL_HTTP_SERVER_ERROR("error.server.http.external.service");

    private final String code;

    ErrorCode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
