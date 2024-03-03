package pro.sky.java.course2.examineservice.impl;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.QuestionDoesntExcistException;
import pro.sky.java.course2.examineservice.service.impl.JavaQuestionServiceImpl;
import pro.sky.java.course2.examineservice.service.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.java.course2.examineservice.Constants.*;

public class JavaQuestionServiceImplTest {
    private final QuestionService e = new JavaQuestionServiceImpl();



    @Test
    void shouldAddByQuestionPlusAnswer() {
        Question result = e.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        assertEquals(QUESTION_1, result);
    }

    @Test
    void shouldAddWithoutAnyParams() {
        Question result = e.add(QUESTION_1);
        assertEquals(QUESTION_1, result);
    }

    @Test
    void shouldReturnQuestionToRemove() {
        Question result = e.remove(QUESTION_2);
        assertEquals(QUESTION_2, result);
    }

    @Test
    void shouldThrowQuestionDoesntExcistExceptionForRemoveMethod() {
        assertThrows(QuestionDoesntExcistException.class,
                () -> e.remove(QUESTION_1));
    }

    @Test
    void shouldGetAll() {
        assertEquals(QUESTIONS, e.getAll());
    }
}
