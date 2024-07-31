package com.dev.sunny.beerapp.model;

import com.dev.sunny.beerapp.dao.BeerDAO;

import java.sql.SQLException;
import java.util.List;

public class BeerExpert {
    private BeerDAO beerDAO;

    public BeerExpert(BeerDAO beerDAO) {
        this.beerDAO = beerDAO;
    }

    public List<Beer> getBeersByColor(String color) throws SQLException {
        return beerDAO.listBeersByColor(color);
    }
}













//package com.dev.sunny.beerapp.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BeerExpert {
//    public List<String> getBrands(String color) {
//        List<String> brands = new ArrayList<>();
//
//        if (color.equals("amber")) {
//            brands.add("Jack Amber");
//            brands.add("Red Moose");
//        } else {
//            brands.add("Jail Pale Ale");
//            brands.add("Gout Stout");
//        }
//
//        return brands;
//    }
//}


