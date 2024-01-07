package lk.acpt.demofxafsd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.acpt.demofxafsd.model.PhoneModel;
import lk.acpt.demofxafsd.to.Phone;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 23/12/2023
 * Time: 08:39
 * To change this template use File | Settings | File and Code Templates.
 */
public class PhoneUpdateController {
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
    void cancle(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        String id = txtId.getText();

        Phone search = PhoneModel.search(id);

        txtBrand.setText(search.getBrand());
    }

    @FXML
    void update(ActionEvent event) {
        String pid = txtId.getText();
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int ram = Integer.parseInt(txtRam.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {
            //1st step ---> load Driver to the ram
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2nd step ---> create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_3", "root", "acpt");

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("update phone set brand=?,model=?,ram=?,price=? where pid=?");
            stm.setObject(1, brand);
            stm.setObject(2, model);
            stm.setObject(3, ram);
            stm.setObject(4, price);
            stm.setObject(5, pid);

            int executed = stm.executeUpdate();

            System.out.println(executed);

            //delete from phone where pid = ?

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
