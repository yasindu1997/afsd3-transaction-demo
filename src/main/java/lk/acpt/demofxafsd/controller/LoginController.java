package lk.acpt.demofxafsd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.acpt.demofxafsd.HelloApplication;

import java.io.IOException;
import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 03/12/2023
 * Time: 11:48
 * To change this template use File | Settings | File and Code Templates.
 */
public class LoginController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            //1st step ---> load Driver to the ram
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2nd step ---> create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_3", "root", "acpt");

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("select * from user where email=?");
            stm.setObject(1, email);

            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                //decode password
                if (password.equals(resultSet.getString(3))) {
                    Stage stage = (Stage) this.root.getScene().getWindow();

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("save-car-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Error !");
                    alert.setContentText("Email or Password incorrect");
                    alert.show();
                }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
