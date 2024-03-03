package pro.sky.java.course2.examineservice.exceptions;

public class QuestionDoesntExcistException extends RuntimeException {
    public QuestionDoesntExcistException(String message) {
        super(message);
    }
    public QuestionDoesntExcistException() {
        super();
    }
}
