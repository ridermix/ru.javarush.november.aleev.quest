package ru.javarush.november.aleev.quest.repository;


import ru.javarush.november.aleev.quest.entity.Answer;

import java.util.Comparator;
import java.util.stream.Stream;

public class AnswerRepository extends AbstractRepository<Answer> implements Repository<Answer> {

    private static final AnswerRepository answerRepository = new AnswerRepository();

    public AnswerRepository(){}

    public static AnswerRepository get(){
        return answerRepository;
    }

//    @Override
//    public Stream<Answer> find(Answer pattern) {
//        return map.values().stream()
//                .filter(entity -> isOk(pattern,entity, Answer::getId)
//                        && isOk(pattern,entity,Answer::getQuestionId)
//                        && isOk(pattern,entity,Answer::getText)
//                )
//                .sorted(Comparator.comparingLong(Answer::getId));
//    }
}
