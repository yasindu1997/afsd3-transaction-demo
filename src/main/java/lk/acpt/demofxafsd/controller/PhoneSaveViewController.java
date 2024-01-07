package lk.acpt.demofxafsd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.acpt.demofxafsd.model.PhoneModel;
import lk.acpt.demofxafsd.to.Phone;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 17/12/2023
 * Time: 09:30
 * To change this template use File | Settings | File and Code Templates.
 */
public class PhoneSaveViewController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRam;

    @FXML
    void back(MouseEvent event) {

    }

    @FXML
    void cancle(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        String pid = txtId.getText();
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int ram = Integer.parseInt(txtRam.getText());
        double price = Double.parseDouble(txtPrice.getText());

        boolean b = PhoneModel.savePhone(new Phone(pid, brand, model, ram, price,2));

        //alert or anything....
    }
}
