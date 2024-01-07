package lk.acpt.demofxafsd.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.demofxafsd.model.PhoneModel;
import lk.acpt.demofxafsd.tm.OrderDetailTM;
import lk.acpt.demofxafsd.to.Phone;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @FXML
    private ComboBox<String> cmbIds;

    @FXML
    private TableView<OrderDetailTM> tblItems;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtRam;

    @FXML
    private TextField txtUnitPrice;

    private ArrayList<OrderDetailTM> detailTMS;

    @FXML
    void btnAddToCart(ActionEvent event) {
        double itemTotal = Double.parseDouble(txtUnitPrice.getText())*Integer.parseInt(txtQty.getText());

        detailTMS.add(new OrderDetailTM(cmbIds.getSelectionModel().getSelectedItem(),txtModel.getText(),Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQty.getText()),itemTotal));

        tblItems.setItems(FXCollections.observableArrayList(detailTMS));
    }

    @FXML
    void idSelect(ActionEvent event) {
        String id = cmbIds.getSelectionModel().getSelectedItem();

        Phone search = PhoneModel.search(id);

        txtBrand.setText(search.getBrand());
        txtModel.setText(search.getModel());
        txtQtyOnHand.setText(String.valueOf(search.getQty()));
        txtRam.setText(String.valueOf(search.getRam()));
        txtUnitPrice.setText(String.valueOf(search.getPrice()));
    }

    @FXML
    void placeOrder(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> phoneIds = PhoneModel.getPhoneIds();

        cmbIds.setItems(FXCollections.observableArrayList(phoneIds));

        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        detailTMS =  new ArrayList<>();

    }
}
