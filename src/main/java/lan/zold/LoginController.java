package lan.zold;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lan.zold.models.UserSource;
import lan.zold.models.Sqlite;

public class LoginController {

    @FXML
    private TextField passField;

    @FXML
    private TextField userField;

    @FXML
    void onClickLoginButton(ActionEvent event) {
        startLogin();
    }

    void startLogin() {
        UserSource userSource = new UserSource(new Sqlite());
        boolean loginOk = userSource.login(userField.getText(), passField.getText());

        if (loginOk) {
            System.out.println("Sikeres bejelentkezés!");
        } else {
            System.out.println("Hiba! A bejelentkezés sikertelen!");
        }
    }

}
