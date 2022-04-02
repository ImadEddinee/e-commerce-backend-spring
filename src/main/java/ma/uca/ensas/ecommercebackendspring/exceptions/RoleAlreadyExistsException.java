package ma.uca.ensas.ecommercebackendspring.exceptions;

public class RoleAlreadyExistsException extends RuntimeException{

    public RoleAlreadyExistsException(String exMessage){
        super(exMessage);
    }
}
