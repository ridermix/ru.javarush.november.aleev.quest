package ru.javarush.november.aleev.quest.service;

import org.junit.jupiter.api.Test;
import ru.javarush.november.aleev.quest.entity.Game;
import ru.javarush.november.aleev.quest.entity.GameState;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {

    private final GameService gameService = GameService.INSTANCE;

    @Test
    void create(){
        Long id = gameService.create("test");
        Game game = gameService.get(id);
        assertEquals("test", game.getUserName());
        assertEquals(1L, game.getCurrentQuestionId());
        assertEquals(GameState.PLAY, game.getState());
        assertEquals(1L, game.getQuestId());
    }

    @Test
    void getAll(){
        gameService.create("test");
        assertEquals(2, gameService.getAll().size());
    }


}
