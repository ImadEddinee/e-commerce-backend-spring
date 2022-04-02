package ma.uca.ensas.ecommercebackendspring.exceptions;

public class PermissionAlreadyExistsException extends RuntimeException {

    public PermissionAlreadyExistsException(String exMessage){
        super(exMessage);
    }
}
