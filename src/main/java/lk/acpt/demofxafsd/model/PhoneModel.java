package lk.acpt.demofxafsd.model;

import javafx.scene.control.Alert;
import lk.acpt.demofxafsd.db.DBConnection;
import lk.acpt.demofxafsd.to.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 30/12/2023
 * Time: 11:00
 * To change this template use File | Settings | File and Code Templates.
 */
public class PhoneModel {
    public static boolean savePhone(Phone phone){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("insert into phone values(?,?,?,?,?)");
            stm.setObject(1,phone.getId());
            stm.setObject(2,phone.getBrand());
            stm.setObject(3,phone.getModel());
            stm.setObject(4,phone.getRam());
            stm.setObject(5,phone.getPrice());

            int executed = stm.executeUpdate();

           return executed>0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deletePhone(String id){
        return true;
    }

    public static boolean updatePhone(Phone phone){
        return true;
    }

    public static ArrayList<Phone> getAllPhone(){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("select * from phone");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<Phone> phones = new ArrayList<>();

            while(resultSet.next()){
                Phone phone = new Phone();

                phone.setId(resultSet.getString(1));
                phone.setBrand(resultSet.getString(2));
                phone.setModel(resultSet.getString(3));
                phone.setRam(resultSet.getInt(4));
                phone.setPrice(resultSet.getDouble(5));

                phones.add(phone);
            }

            return phones;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Phone search(String id){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("select * from phone where pid=?");
            stm.setObject(1, id);

            ResultSet resultSet = stm.executeQuery();

            Phone phone = new Phone();

            if (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Entry Found !");
                alert.show();
            } else {
                do {
                    phone.setBrand(resultSet.getString(2));
                    phone.setModel(resultSet.getString(3));
                    phone.setRam(resultSet.getInt(4));
                    phone.setPrice((resultSet.getDouble(5)));
                    phone.setQty((resultSet.getInt(6)));
                } while (resultSet.next());
            }

            return phone;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> getPhoneIds(){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //SQL Query
            PreparedStatement stm = connection.prepareStatement("select pid from phone");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<String> phoneIds = new ArrayList<>();

            while(resultSet.next()){
               phoneIds.add(resultSet.getString(1));
            }

            return phoneIds;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
