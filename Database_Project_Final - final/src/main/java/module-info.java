module com.example.database_project_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.database_project_final to javafx.fxml;
    exports com.example.database_project_final;
}