package main.exception;

public class RunTimeExceptionDuplicationById extends RuntimeException{
    public RunTimeExceptionDuplicationById(String message) {
        super("Existe ID já inscrito, tente com outro ID");
    }
}
