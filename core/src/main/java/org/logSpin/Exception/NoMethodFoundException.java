package org.logSpin.Exception;

public class NoMethodFoundException extends RuntimeException {
    private final String method;

    public NoMethodFoundException(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "NoMethodFindException{" +
                "method='" + method + '\'' +
                '}';
    }
}
