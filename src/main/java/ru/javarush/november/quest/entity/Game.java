package ru.javarush.november.quest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Game extends AbstractEntity{
    Long id;
    String userName;
    LocalDateTime startTime;
    Long currentQuestionId;
    Long questId;
    GameState state;
}
