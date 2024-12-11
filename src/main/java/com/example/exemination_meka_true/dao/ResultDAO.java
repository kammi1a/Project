package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Result;
import com.example.exemination_meka_true.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    public List<Result> findAll() {
        List<Result> results = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT u.username, t.name AS test_name, r.score " +
                            "FROM results r " +
                            "JOIN users u ON r.user_id = u.id " +
                            "JOIN tests t ON r.test_id = t.id"
            );
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                results.add(new Result(
                        rs.getString("username"),
                        rs.getString("test_name"),
                        rs.getInt("score")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
