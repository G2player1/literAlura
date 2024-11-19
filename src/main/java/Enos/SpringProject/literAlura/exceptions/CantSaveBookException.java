package Enos.SpringProject.literAlura.exceptions;

public class CantSaveBookException extends RuntimeException {
    private final String message;

    public CantSaveBookException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
