package org.LogSpin.Exception;

public class NoMethodFindException extends RuntimeException {
    String method;

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
