module oneminute {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;

    opens oneminute to javafx.fxml;
    opens oneminute.classes to javafx.fxml;
    opens oneminute.controllers to javafx.fxml;

    exports oneminute;
    exports oneminute.controllers;
    exports oneminute.classes;
}
