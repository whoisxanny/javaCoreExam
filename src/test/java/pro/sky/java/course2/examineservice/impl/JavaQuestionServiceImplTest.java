package pro.sky.java.course2.examineservice.impl;


import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.QuestionDoesntExcistException;
import pro.sky.java.course2.examineservice.service.QuestionService;
import pro.sky.java.course2.examineservice.service.impl.JavaQuestionServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examineservice.Constants.*;

public class JavaQuestionServiceImplTest {
    private final QuestionService e = new JavaQuestionServiceImpl();

    @Test
    public void testAdd() {
        Question result = e.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        assertEquals(result, QUESTION_1);
    }

    @Test
    public void testAddShouldThrowException() {
        assertThrows(RuntimeException.class, () -> e.add(QUESTION_WE_HAVE.getQuestion(), QUESTION_WE_HAVE.getAnswer()));
    }

    @Test
    public void testAddWithoutParams() {
        Question result = e.add(QUESTION_1);
        assertEquals(result, QUESTION_1);
    }

    @Test
    public void testRemove() {
        Question result = e.remove(QUESTION_WE_HAVE);
        assertEquals(QUESTION_WE_HAVE, result);
    }

    @Test
    void testRemoveShouldThrowQuestionDoesntExcistException() {
        assertThrows(QuestionDoesntExcistException.class,
                () -> e.remove(QUESTION_1));
    }

    @Test
    void testGetAll() {
        assertEquals(QUESTIONS, e.getAll());
    }
}


