module com.example.exemination_meka_true {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    // Экспортируем пакеты, которые используются в проекте
    exports com.example.exemination_meka_true;
    exports com.example.exemination_meka_true.controller;
    exports com.example.exemination_meka_true.model;
    exports com.example.exemination_meka_true.dao;
    exports com.example.exemination_meka_true.util;

    // Открываем пакеты для JavaFX (FXML использует рефлексию)
    opens com.example.exemination_meka_true.controller to javafx.fxml;
    opens com.example.exemination_meka_true.model to javafx.fxml;
    opens com.example.exemination_meka_true.dao to javafx.fxml;
    opens com.example.exemination_meka_true.util to javafx.fxml;
}
