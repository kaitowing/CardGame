module game {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens game to javafx.fxml;
    exports game;
}
