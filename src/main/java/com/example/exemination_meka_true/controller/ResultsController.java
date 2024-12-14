package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.dao.ResultDAO;
import com.example.exemination_meka_true.model.Result;
import com.example.exemination_meka_true.util.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

public class ResultsController {

    @FXML
    private ListView<String> resultsList;

    private final ResultDAO resultDAO = new ResultDAO(DatabaseUtil.getConnection());

    public ResultsController() throws SQLException {
    }

    @FXML
    public void initialize() {
        loadResults();
    }


    private void loadResults() {
        List<Result> results = resultDAO.findAll();
        ObservableList<String> resultsDisplay = FXCollections.observableArrayList();
        for (Result result : results) {
            resultsDisplay.add(result.getUserName() + " - " + result.getTestName() + " - Score: " + result.getScore());
        }
        resultsList.setItems(resultsDisplay);
    }
}
