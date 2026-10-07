package live.switchly.api.exception;

public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException(String message) {
        super(message);
    }
}