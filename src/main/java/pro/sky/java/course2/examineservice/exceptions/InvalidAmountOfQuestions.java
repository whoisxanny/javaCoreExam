package pro.sky.java.course2.examineservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAmountOfQuestions extends RuntimeException {

    public InvalidAmountOfQuestions() {
        super();
    }

    public InvalidAmountOfQuestions(String message) {
        super(message);
    }
}
