package Enos.SpringProject.literAlura.exceptions;

public class ZeroNegativeIdException extends RuntimeException {

    private final String message;

    public ZeroNegativeIdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
