package ru.javarush.november.aleev.quest.util;

import lombok.experimental.UtilityClass;
import ru.javarush.november.aleev.quest.entity.Answer;
import ru.javarush.november.aleev.quest.entity.Quest;
import ru.javarush.november.aleev.quest.entity.Question;
import ru.javarush.november.aleev.quest.repository.AnswerRepository;
import ru.javarush.november.aleev.quest.repository.QuestRepository;
import ru.javarush.november.aleev.quest.repository.QuestionRepository;


import java.util.HashSet;

@UtilityClass
public class Runner {
    private final QuestRepository questRepository = QuestRepository.get();
    private final QuestionRepository questionRepository = QuestionRepository.get();
    private final AnswerRepository answerRepository = AnswerRepository.get();

    public void load() {
        init();
    }

    private static void init() {
        Quest quest1 = Quest.builder()
                .name("JavaRush")
                .id(1L)
                .build();

        Question question1 = Question.builder()
                .id(1L)
                .questId(1L)
                .text("Принять вызов НЛО?").build();

        Question question2 = Question.builder()
                .id(2L)
                .questId(1L)
                .text("Подняться на мостик к капитану?").build();

        Question question3 = Question.builder()
                .id(3L)
                .questId(1L)
                .text("Ты кто?").build();

        Question question4 = Question.builder()
                .id(4L)
                .questId(1L)
                .text("YOU WIN!").build();

        Question question5 = Question.builder()
                .id(5L)
                .questId(1L)
                .text("GAME OVER!").build();



// 1L "Принять вызов НЛО?"
        Answer answer1 = Answer.builder()
                .questionId(1L)
                .id(1L)
                .text("Принять вызов")
                .nextQuestionId(2L).build();
        Answer answer2 = Answer.builder()
                .questionId(1L)
                .id(2L)
                .correct(false)
                .text("Отклонить вызов")
                .nextQuestionId(5L).build();
// 2L "Подняться на мостик к капитану?"
        Answer answer3 = Answer.builder()
                .questionId(2L)
                .id(3L)
                .text("Подняться на мостик")
                .nextQuestionId(3L).build();
        Answer answer4 = Answer.builder()
                .questionId(2L)
                .id(4L)
                .correct(false)
                .text("Отказаться подниматься на мостик")
                .nextQuestionId(5L).build();
// 3L "Ты кто?"
        Answer answer5 = Answer.builder()
                .questionId(3L)
                .id(5L)
                .text("Рассказать правду")
                .nextQuestionId(4L).build();
        Answer answer6 = Answer.builder()
                .questionId(3L)
                .id(6L)
                .correct(false)
                .text("Солгать о себе")
                .nextQuestionId(5L).build();

        question1.setAnswers(new HashSet<>());
        question1.getAnswers().add(answer1);
        question1.getAnswers().add(answer2);

        question2.setAnswers(new HashSet<>());
        question2.getAnswers().add(answer3);
        question2.getAnswers().add(answer4);

        question3.setAnswers(new HashSet<>());
        question3.getAnswers().add(answer5);
        question3.getAnswers().add(answer6);

        quest1.setQuestions(new HashSet<>());
        quest1.getQuestions().add(question1);
        quest1.getQuestions().add(question2);
        quest1.getQuestions().add(question3);
        quest1.getQuestions().add(question4);
        quest1.getQuestions().add(question5);


        questRepository.update(quest1);

        questionRepository.update(question1);
        questionRepository.update(question2);
        questionRepository.update(question3);
        questionRepository.update(question4);
        questionRepository.update(question5);


        answerRepository.update(answer1);
        answerRepository.update(answer2);
        answerRepository.update(answer3);
        answerRepository.update(answer4);
        answerRepository.update(answer5);
        answerRepository.update(answer6);
    }

}
