package store.exceptions;

//TODO: replace by more common exception like NotFound and describe info in message?
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message){
        super(message);
    }
}
