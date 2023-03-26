package ru.javarush.november.quest.controller;



import ru.javarush.november.quest.service.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createServlet", value = "/create")
public class CreateServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("id") == null
                || !req.getSession().getAttribute("status").toString().equals("PLAY")) {
            doPost(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game");
            requestDispatcher.forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = gameService.create(req.getParameter("name"));
        int count = (int) gameService.getAll().stream()
                .map(s -> s.getUserName().equals(req.getParameter("name"))).count();
        req.getSession().setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("count", count);
        req.getSession().setAttribute("status", gameService.get(id).getState());
        req.getSession().setAttribute("id", id);
        doGet(req, resp);
    }
}
