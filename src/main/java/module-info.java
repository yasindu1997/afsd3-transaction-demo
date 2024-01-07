module lk.acpt.demofxafsd {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;

    opens lk.acpt.demofxafsd to javafx.fxml;
    exports lk.acpt.demofxafsd;
    exports lk.acpt.demofxafsd.controller;
    opens lk.acpt.demofxafsd.controller to javafx.fxml;
    exports lk.acpt.demofxafsd.tm;
    opens lk.acpt.demofxafsd.tm to javafx.fxml;
}