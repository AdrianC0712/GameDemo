package org.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private boolean isGame = true;
    private char nowSym = 'X';

    private char gameField [][] = new char[3][3];

    @FXML
    void btnClick(ActionEvent event) {


        Button btn = (Button) event.getSource();

        if (!isGame || btn.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        System.out.println(rowIndex);
        System.out.println(columnIndex);

        gameField[rowIndex][columnIndex] = nowSym;

        ((Button) event.getSource()).setText(String.valueOf(nowSym));

        if (!isBoardFull()) {
            if (gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField[0][2] && (gameField[0][0] == 'X' || gameField[0][0] == 'O')) {
                isGame = false;
                alert(gameField[0][0]);
            } else if (gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField[1][2] && (gameField[1][0] == 'X' || gameField[1][0] == 'O')) {
                isGame = false;
                alert(gameField[1][0]);
            } else if (gameField[2][0] == gameField[2][1] && gameField[2][0] == gameField[2][2] && (gameField[2][0] == 'X' || gameField[2][0] == 'O')) {
                isGame = false;
                alert(gameField[2][0]);
            } else if (gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField[2][0] && (gameField[0][0] == 'X' || gameField[0][0] == 'O')) {
                isGame = false;
                alert(gameField[0][0]);
            } else if (gameField[0][1] == gameField[1][1] && gameField[0][1] == gameField[2][1] && (gameField[0][1] == 'X' || gameField[0][1] == 'O')) {
                isGame = false;
                alert(gameField[0][1]);
            } else if (gameField[0][2] == gameField[1][2] && gameField[0][2] == gameField[2][2] && (gameField[0][2] == 'X' || gameField[0][2] == 'O')) {
                isGame = false;
                alert(gameField[0][2]);
            } else if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2] && (gameField[0][0] == 'X' || gameField[0][0] == 'O')) {
                isGame = false;
                alert(gameField[0][0]);
            } else if (gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0] && (gameField[0][2] == 'X' || gameField[0][2] == 'O')) {
                isGame = false;
                alert(gameField[0][2]);
            }
            nowSym = nowSym == 'X' ? 'O' : 'X';
        }
        else if (isBoardFull())
        {
            alertEgal();
        }
    }

    private void alert(char winner)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "A cistigat jucatorul "+ winner +" ");
        alert.showAndWait();
    }

    private void alertEgal()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Egalitate!");
        alert.showAndWait();

    }
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField[i][j] == '\0') { // Verifică dacă există o poziție neocupată
                    return false;
                }
            }
        }
        return true;
    }
    @FXML
    void initialize() {

    }

}