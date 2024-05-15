package mk.ukim.finki.lab_1_emt.model.exceptions;

public class NoAvailableCopiesLeftException extends RuntimeException{
        public NoAvailableCopiesLeftException() {
            super("There are no more copies of this book.");
        }
}
