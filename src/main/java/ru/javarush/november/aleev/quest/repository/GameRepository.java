package ru.javarush.november.aleev.quest.repository;


import ru.javarush.november.aleev.quest.entity.Game;

import java.util.Comparator;
import java.util.stream.Stream;

public class GameRepository extends AbstractRepository<Game> implements Repository<Game> {
    private static final GameRepository gameRepository = new GameRepository();

    public GameRepository(){}

    public static GameRepository get() {
        return gameRepository;
    }

    @Override
    public Stream<Game> find(Game pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Game::getId)
                        && isOk(pattern,entity,Game::getUserName)
                        && isOk(pattern,entity,Game::getCurrentQuestionId)
                        && isOk(pattern,entity,Game::getState)
                        )
                .sorted(Comparator.comparingLong(Game::getId));
    }
}
