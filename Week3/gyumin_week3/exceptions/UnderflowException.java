package gyumin_week3.exceptions;

public class UnderflowException extends RuntimeException{
   public UnderflowException () {
        super("언더플로우 발생");
   }
}
