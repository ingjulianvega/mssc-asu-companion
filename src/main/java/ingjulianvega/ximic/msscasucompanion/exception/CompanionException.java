package ingjulianvega.ximic.msscasucompanion.exception;

import lombok.Getter;

@Getter
public class CompanionException extends RuntimeException {

    private final String code;

    public CompanionException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

