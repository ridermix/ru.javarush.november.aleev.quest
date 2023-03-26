package ru.javarush.november.quest.controller;

import ru.javarush.november.quest.entity.Answer;
import ru.javarush.november.quest.entity.Game;
import ru.javarush.november.quest.entity.GameState;
import ru.javarush.november.quest.service.GameService;
import ru.javarush.november.quest.service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;
    private final QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long currentQuestionId = gameService.get((Long)req.getSession().getAttribute("id")).getCurrentQuestionId();
        if(req.getParameter("answer") != null){
            if(req.getParameter("answer").equals("0")){
                Answer answer = new ArrayList<>(questionService.get(currentQuestionId).getAnswers()).get(0);
                req.getSession().setAttribute("correct", answer.getCorrect());
                currentQuestionId = answer.getNextQuestionId();

            }
            else {
                Answer answer = new ArrayList<>(questionService.get(currentQuestionId).getAnswers()).get(1);
                req.getSession().setAttribute("correct", answer.getCorrect());
                currentQuestionId = answer.getNextQuestionId();
            }
            gameService.get((Long)req.getSession().getAttribute("id")).setCurrentQuestionId(currentQuestionId);

        }


        go(req,resp, currentQuestionId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void go(HttpServletRequest req, HttpServletResponse resp, long currentQuestionId) throws ServletException, IOException {
        req.setAttribute("questionText", questionService.get(currentQuestionId).getText());

        Collection<Answer> answers = questionService.get(currentQuestionId).getAnswers();
        Game game = gameService.get((Long)req.getSession().getAttribute("id"));

        if(answers==null){
            if(req.getSession().getAttribute("correct")==null){
                game.setState(GameState.WIN);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("win.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                game.setState(GameState.GAME_OVER);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("game_over.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        assert answers != null;
        req.setAttribute("answer1", new ArrayList<>(answers).get(0).getText());
        req.setAttribute("answer2", new ArrayList<>(answers).get(1).getText());
    }
}
