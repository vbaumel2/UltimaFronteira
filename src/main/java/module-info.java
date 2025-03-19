module com.example.ultimafronteira {
    requires javafx.controls;
    requires javafx.fxml;


    opens jogo to javafx.fxml;
    exports jogo;
    exports jogo.ControllersDaInterface;
    opens jogo.ControllersDaInterface to javafx.fxml;
}