package pro.sky.java.course2.examineservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }

    @GetMapping("/all")
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
