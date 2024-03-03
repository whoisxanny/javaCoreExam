package pro.sky.java.course2.examineservice.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.QuestionDoesntExcistException;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.java.course2.examineservice.Constants.QUESTION_1;
import static pro.sky.java.course2.examineservice.Constants.QUESTION_2;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private JavaQuestionServiceImplTest javaQuestionServiceImplTest;

    @Test
    public void addQuestionTest() {
        Mockito.when(questionService.add(QUESTION_1)).thenReturn(QUESTION_1).thenThrow(new RuntimeException());
        assertEquals(questionService.add(QUESTION_1), QUESTION_1);

    }

    @Test
    public void removeQustionTest() {
        Mockito.when(questionService.remove(QUESTION_1)).thenReturn(QUESTION_1).thenThrow(new RuntimeException());
        assertEquals(questionService.remove(QUESTION_1), QUESTION_1);
    }

    @Test
    public void getAllQuestionsTest() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        Mockito.when(questionService.getAll()).thenReturn(List.of(QUESTION_1, QUESTION_2)).thenThrow(new QuestionDoesntExcistException());
        assertEquals(questionService.getAll(), List.of(QUESTION_1, QUESTION_2));
    }

    @Test
    public void getRandomQuestion() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(QUESTION_1).thenThrow(new RuntimeException());
        assertEquals(questionService.getRandomQuestion(), QUESTION_1);
    }


}
