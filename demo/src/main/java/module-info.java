module com.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cardgame to javafx.fxml;
    exports com.cardgame;
}
