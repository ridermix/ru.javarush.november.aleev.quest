package ru.javarush.november.quest.service;



import ru.javarush.november.quest.entity.Game;
import ru.javarush.november.quest.entity.GameState;
import ru.javarush.november.quest.repository.GameRepository;
import ru.javarush.november.quest.repository.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

public enum GameService {
    INSTANCE;

    private final Repository<Game> gameRepository = GameRepository.get();

    public Collection<Game> getAll(){
        return gameRepository.getAll().collect(Collectors.toList());
    }

    public Game get(Long id){
        return gameRepository.get(id);
    }


    public Long create(String name){
        Game game = Game.builder()
                .questId(1L)
                .currentQuestionId(1L)
                .userName(name)
                .state(GameState.PLAY)
                .startTime(LocalDateTime.now())
                .build();
        return gameRepository.create(game);
    }

}
