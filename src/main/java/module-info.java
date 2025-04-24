module com.example.ultimafronteira {
    requires javafx.controls;
    requires javafx.fxml;


    opens jogo to javafx.fxml;
    exports jogo;
    exports jogo.ClassesDaInterface;
    opens jogo.ClassesDaInterface to javafx.fxml;
    exports jogo.ClassesDaInterface.janelaPrincipal;
    opens jogo.ClassesDaInterface.janelaPrincipal to javafx.fxml;
}