package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.Collection;


@Service
public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
