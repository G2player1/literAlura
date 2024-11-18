package Enos.SpringProject.literAlura.exceptions;

public class CantGetWebDataException extends RuntimeException {

    private final String message;

    public CantGetWebDataException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
