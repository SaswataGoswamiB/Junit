package com.JunitTest;

import org.springframework.http.HttpStatus;

public enum CustomHttpStatus {
    HTTP_418_CUSTOM_TEAPOT(418, "I'm a teapot");

    private final int value;
    private final String reasonPhrase;

    CustomHttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public HttpStatus toHttpStatus() {
        return HttpStatus.valueOf(this.value);
    }
}
