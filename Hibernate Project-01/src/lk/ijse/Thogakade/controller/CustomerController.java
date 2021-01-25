package lk.ijse.Thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Thogakade.NotificationAlert;
import lk.ijse.Thogakade.business.BoFactory;
import lk.ijse.Thogakade.business.BoType;
import lk.ijse.Thogakade.business.custome.CustomerBo;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.entity.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtId;
    public JFXButton btnSave;
    public JFXTextField txtFind;

    public TableView tblCustomer;
    public TableColumn tblId;
    public TableColumn tblname;
    public TableColumn tbladdress;
    public AnchorPane root;

    CustomerBo customerBo;

    public CustomerController() {

        this.customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    }
    public void btnSavOnAction(ActionEvent actionEvent) {
        String id = this.txtId.getText();
        String name = this.txtName.getText();
        String address = this.txtAddress.getText();
        CustomerDto customer = new CustomerDto(id, name, address);

        try {
            boolean added = this.customerBo.addCustomer(customer);
            if (added) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }

            this.txtId.clear();
            this.txtName.clear();
            this.txtAddress.clear();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    public void btnUpdateOnaction(ActionEvent actionEvent) {
        String id = this.txtId.getText();
        String name = this.txtName.getText();
        String address = this.txtAddress.getText();
        CustomerDto customer = new CustomerDto(id, name, address);

        try {
            boolean updated = this.customerBo.updateCustomer(customer);
            if (updated) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }

            this.txtId.clear();
            this.txtName.clear();
            this.txtAddress.clear();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = this.txtId.getText();
//        new CustomerDto(id);

        try {
            boolean deleted = this.customerBo.deleteCustomer(id);
            if (deleted) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }

            this.txtId.clear();
            this.txtName.clear();
            this.txtAddress.clear();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void findOnAction(MouseEvent mouseEvent) {
        String id = txtFind.getText();
        try {
            Customer customer = customerBo.findCustomer(id);
            if(customer!=null){
                txtId.setText(customer.getId());
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.warning();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void loadAll() {
        ObservableList observableList = FXCollections.observableArrayList();
        try {
            List<Customer> all = customerBo.findAll();
            Iterator<Customer> iterator = all.iterator();
            while (iterator.hasNext()){
                Customer next = iterator.next();
                observableList.add(new CustomerDto(next.getId(),next.getAddress(),next.getName()));
            }
            tblCustomer.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLastId(){
        try {
            String lastId = customerBo.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                txtId.setText("C00"+newId);
            }else if (newId < 100) {
                txtId.setText("C0"+newId);
            }else {
                txtId.setText("C"+newId);
            }
        } catch (Exception e) {
            txtId.setText("C001");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblId.setCellValueFactory(new PropertyValueFactory("id"));
        tbladdress.setCellValueFactory(new PropertyValueFactory("address"));
        tblname.setCellValueFactory(new PropertyValueFactory("name"));
        loadAll();
        txtId.requestFocus();
        getLastId();
    }

    public void homeOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) this.root.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/OrderForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }
}
