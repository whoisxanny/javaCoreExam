package pro.sky.java.course2.examineservice.service.impl;

import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.InvalidAmountOfQuestions;
import pro.sky.java.course2.examineservice.service.ExaminerService;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.*;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new InvalidAmountOfQuestions("There are no more questions, dude))");
        }
        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }


}
