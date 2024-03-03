package pro.sky.java.course2.examineservice.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examineservice.Constants.QUESTIONS;
import static pro.sky.java.course2.examineservice.Constants.QUESTION_2;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionService;
    private ExaminerServiceImpl out;


    @BeforeEach
    public void createAQuestion() {
        when(javaQuestionService.getAll()).thenReturn(QUESTIONS);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION_2);
        out = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void shouldGetAllQuestions() {
        Set<Question> expected = Set.of(QUESTION_2);
        Set<Question> result = (Set<Question>) out.getQuestions(1);
        assertIterableEquals(expected, result);
    }

}
