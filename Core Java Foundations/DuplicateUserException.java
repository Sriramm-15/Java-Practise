public class DuplicateUserException extends Exception {
    public DuplicateUserException(String message) {
        super(message);
        System.out.println("Duplicate User is not allowed");
        // System.exit(0);
    }
}
