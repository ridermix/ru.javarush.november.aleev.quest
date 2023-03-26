package ru.javarush.november.quest.repository;


import ru.javarush.november.quest.entity.Quest;

import java.util.Comparator;
import java.util.stream.Stream;

public class QuestRepository extends AbstractRepository<Quest> implements Repository<Quest> {

    private static final QuestRepository questRepository = new QuestRepository();

    public static QuestRepository get() {
        return questRepository;
    }

    @Override
    public Stream<Quest> find(Quest pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Quest::getId)
                && isOk(pattern, entity, Quest::getName)
        )
                .sorted(Comparator.comparingLong(Quest::getId));
    }
}
