package ru.javarush.november.quest.repository;


import ru.javarush.november.quest.entity.Question;

import java.util.Comparator;
import java.util.stream.Stream;

public class QuestionRepository extends AbstractRepository<Question> implements Repository<Question> {

    private static final QuestionRepository questionRepository = new QuestionRepository();

    public QuestionRepository(){}

    public static QuestionRepository get(){
        return questionRepository;
    }

    @Override
    public Stream<Question> find(Question pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern,entity,Question::getId)
                        && isOk(pattern, entity,Question::getQuestId)
                        && isOk(pattern, entity, Question::getText)
                        && isOk(pattern, entity,Question::getAnswers)
                )
                .sorted(Comparator.comparingLong(Question::getId));
    }
}
