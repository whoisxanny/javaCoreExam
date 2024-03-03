package pro.sky.java.course2.examineservice;

import pro.sky.java.course2.examineservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static final Question QUESTION_1 = new Question("2 + 8", "10");
    public static final Question QUESTION_2 = new Question("2 + 9", "11");
    public static final Question QUESTION_WE_HAVE = new Question("2 + 2", "4");
    public static final Set<Question> QUESTIONS = new HashSet<>(Set.of(
            new Question("2 + 2", "4"),
            new Question("2 + 3", "5"),
            new Question("2 + 4", "6"),
            new Question("2 + 5", "7")
    ));
}
