/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Model.Question;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ryzen7
 */
@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
private static final List<Question> questions = Arrays.asList(
     new Question("Who directed the movie 'Inception'?", "Christopher Nolan", "James Cameron", "Steven Spielberg", "Quentin Tarantino", "A"),
        new Question("Which city is the capital of India?", "Mumbai", "Delhi", "Bangalore", "Kolkata", "B"),
        new Question("What does CPU stand for?", "Central Processing Unit", "Computer Power Unit", "Central Program Utility", "Control Panel Unit", "A"),
        new Question("Which company developed the game 'Prince Of Persia'?", "Mojang", "Epic Games", "Ubisoft", "EA", "C"),
        new Question("Which language is used for Android app development?", "Java", "Python", "C++", "Ruby", "A")
    );

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");
    new Gson().toJson(questions, response.getWriter());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession();
    int index = Integer.parseInt(request.getParameter("index"));
    String answer = request.getParameter("answer");
    int score = (int) session.getAttribute("score");
    if (questions.get(index).getCorrect().equals(answer)) {
      session.setAttribute("score", score + 1);
    }
  }
}

