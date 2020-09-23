package org.logSpin.Exception;

public class NoMethodFindException extends RuntimeException {
    private final String method;

    public NoMethodFindException(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "NoMethodFindException{" +
                "method='" + method + '\'' +
                '}';
    }
}
