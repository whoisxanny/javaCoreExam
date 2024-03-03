package pro.sky.java.course2.examineservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.InvalidAmountOfQuestions;
import pro.sky.java.course2.examineservice.exceptions.QuestionDoesntExcistException;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Random random = new Random();
    private final Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>(Set.of(
                new Question("2 + 2",
                        "4"),
                new Question("2 + 3",
                        "5"),
                new Question("2 + 4",
                        "6"),
                new Question("2 + 5",
                        "7")
        ));
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else {
            throw new QuestionDoesntExcistException("Nope");
        }
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!questions.contains(question1)) {
            questions.add(question1);
            return question1;
        } else {
            throw new InvalidAmountOfQuestions("BB");
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionDoesntExcistException("No question");
        }
    }

    @Override
    public Collection<Question> getAll() {
        if (!questions.isEmpty()) {
            return questions;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Question getRandomQuestion() {
        if (!questions.isEmpty()) {
            random.nextInt(questions.size());
            return questions.stream().toList().get(questions.size());
        } else {
            throw new RuntimeException();
        }
    }
}
