package ru.javarush.november.aleev.quest.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Loader implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Loader(){}

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Runner.load();
    }
}
