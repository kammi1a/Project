package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Result;
import com.example.exemination_meka_true.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {
    private final Connection connection;

    public ResultDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Result> findAll() {
        List<Result> results = new ArrayList<>();
        String sql = "SELECT r.test_id, r.user_id, u.username, t.name AS test_name, r.score " +
                "FROM results r " +
                "JOIN users u ON r.user_id = u.id " +
                "JOIN tests t ON r.test_id = t.id";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                results.add(new Result(
                        rs.getInt("test_id"),
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("test_name"),
                        rs.getInt("score")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void save(Result result) {
        String sql = "INSERT INTO results (test_id, user_id, username, test_name, score) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, result.getTestId());
            statement.setInt(2, result.getUserId());
            statement.setString(3, result.getUserName());
            statement.setString(4, result.getTestName());
            statement.setInt(5, result.getScore());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
