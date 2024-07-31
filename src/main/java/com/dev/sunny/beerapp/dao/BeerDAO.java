package com.dev.sunny.beerapp.dao;

import com.dev.sunny.beerapp.model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public BeerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Beer> listBeersByColor(String color) throws SQLException {
        List<Beer> listBeer = new ArrayList<>();
        String sql = "SELECT * FROM beers WHERE color = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, color);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            boolean availability = resultSet.getBoolean("availability");

            Beer beer = new Beer(id, name, price, availability);
            listBeer.add(beer);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listBeer;
    }
}
