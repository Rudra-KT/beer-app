package com.dev.sunny.beerapp.servlets;

import com.dev.sunny.beerapp.dao.BeerDAO;
import com.dev.sunny.beerapp.model.Beer;
import com.dev.sunny.beerapp.model.BeerExpert;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list-beers")
public class BeerSuggestionServlet extends HttpServlet {
    private BeerExpert beerExpert;

    @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        BeerDAO beerDAO = new BeerDAO(jdbcURL, jdbcUsername, jdbcPassword);
        beerExpert = new BeerExpert(beerDAO);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String color = request.getParameter("color");

        try {
            List<Beer> result = beerExpert.getBeersByColor(color);
            request.setAttribute("brands", result);
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}




//package com.dev.sunny.beerapp.servlets;
//
//import com.dev.sunny.beerapp.model.BeerExpert;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/list-beers")
//public class BeerSuggestionServlet extends HttpServlet {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String c = request.getParameter("color");
//        BeerExpert be = new BeerExpert();
//        List<String> result = be.getBrands(c);
//
//        request.setAttribute("brands", result);
//        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//
//        view.forward(request, response);
//    }
//}
