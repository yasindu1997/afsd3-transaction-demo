package lk.acpt.demofxafsd.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.demofxafsd.model.PhoneModel;
import lk.acpt.demofxafsd.tm.PhoneTM;
import lk.acpt.demofxafsd.to.Phone;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 23/12/2023
 * Time: 10:49
 * To change this template use File | Settings | File and Code Templates.
 */
public class PhoneLoadController implements Initializable {
    @FXML
    private TableView<PhoneTM> tblPhone;

    @FXML
    void load(ActionEvent event) {

        //get all phones from model
        ArrayList<Phone> allPhone = PhoneModel.getAllPhone();

        //put all phones to TM list
        ArrayList<PhoneTM > tms = new ArrayList<>();

        for(Phone p : allPhone){
            tms.add(new PhoneTM(p.getId(),p.getBrand(),p.getModel(),p.getRam(),p.getPrice()));
        }

        tblPhone.setItems(FXCollections.observableArrayList(tms));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //table initialization
        tblPhone.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblPhone.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblPhone.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblPhone.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ram"));
        tblPhone.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        //get all phones from model
        ArrayList<Phone> allPhone = PhoneModel.getAllPhone();

        //put all phones to TM list
        ArrayList<PhoneTM > tms = new ArrayList<>();

        for(Phone p : allPhone){
            tms.add(new PhoneTM(p.getId(),p.getBrand(),p.getModel(),p.getRam(),p.getPrice()));
        }

        tblPhone.setItems(FXCollections.observableArrayList(tms));
    }
}
