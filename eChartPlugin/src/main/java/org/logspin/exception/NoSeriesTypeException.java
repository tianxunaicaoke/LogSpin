package org.logspin.exception;

public class NoSeriesTypeException extends RuntimeException {
    private final String method;

    public NoSeriesTypeException(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "NoSeriesTypeException{" +
                "method='" + method + '\'' +
                '}';
    }
}