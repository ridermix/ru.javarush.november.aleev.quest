package ru.javarush.november.aleev.quest.repository;

import ru.javarush.november.aleev.quest.entity.AbstractEntity;

import java.util.stream.Stream;

public interface Repository <T extends AbstractEntity>{
    Stream<T> getAll();
//    Stream<T> find(T entity);
    T get(Long id);
    Long create(T entity);
    void update(T entity);
//    void delete(T entity);
}
