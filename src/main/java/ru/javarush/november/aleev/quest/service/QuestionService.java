package ru.javarush.november.aleev.quest.service;

import ru.javarush.november.aleev.quest.entity.Question;
import ru.javarush.november.aleev.quest.repository.QuestionRepository;
import ru.javarush.november.aleev.quest.repository.Repository;

public enum QuestionService {
    INSTANCE;

    private final Repository<Question> questionRepository = QuestionRepository.get();

    public Question get(Long id){
        return questionRepository.get(id);
    }
}
