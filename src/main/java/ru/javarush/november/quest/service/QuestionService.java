package ru.javarush.november.quest.service;

import ru.javarush.november.quest.entity.Question;
import ru.javarush.november.quest.repository.QuestionRepository;
import ru.javarush.november.quest.repository.Repository;

public enum QuestionService {
    INSTANCE;

    private final Repository<Question> questionRepository = QuestionRepository.get();

    public Question get(Long id){
        return questionRepository.get(id);
    }
}
