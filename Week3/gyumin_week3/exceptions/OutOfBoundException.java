package gyumin_week3.exceptions;

public class OutOfBoundException extends RuntimeException{
   public OutOfBoundException() {
      super("범위 초과");
   }
}
