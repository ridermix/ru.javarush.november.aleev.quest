package ru.javarush.november.aleev.quest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Quest extends AbstractEntity{
    Long id;
    String name;
    Collection<Question> questions;
}
