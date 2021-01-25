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
import lk.ijse.Thogakade.business.custome.ItemBo;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.entity.Item;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    public JFXTextField txtDes;
    public JFXTextField txtQty;
    public JFXTextField txtFind;
    public JFXTextField txtCode;
    public JFXButton btnSave;
    public TableView tblItem;
    public TableColumn tblCode;
    public TableColumn tblDescription;
    public TableColumn tblUnit;
    public TableColumn tblQty;
    public JFXTextField txtUnit;
    public AnchorPane root;

    ItemBo itemBo;
    public ItemController(){
        itemBo = BoFactory.getInstance().getBo(BoType.ITEM);
    }

    public void btnSavOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String des = txtDes.getText();
        double price = Double.parseDouble(txtUnit.getText());
        int qty = Integer.parseInt(txtQty.getText());

        ItemDto itemDto = new ItemDto(code, des, price, qty);
        try {
            boolean Added = itemBo.addItem(itemDto);
            if(Added) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }

            this.txtCode.clear();
            this.txtDes.clear();
            this.txtUnit.clear();
            this.txtQty.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnaction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String des = txtDes.getText();
        double price = Double.parseDouble(txtUnit.getText());
        int qty = Integer.parseInt(txtQty.getText());

        ItemDto itemDto = new ItemDto(code, des, price, qty);

        try {
            boolean updated = itemBo.updateItem(itemDto);
            if (updated) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }
            this.txtCode.clear();
            this.txtDes.clear();
            this.txtUnit.clear();
            this.txtQty.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();

        try {
            boolean deleted = itemBo.deleteItem(code);
            if (deleted) {
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }
            this.txtCode.clear();
            this.txtDes.clear();
            this.txtUnit.clear();
            this.txtQty.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findOnAction(MouseEvent mouseEvent) {
        String code = txtFind.getText();

        try {
            Item item = itemBo.findItem(code);

            if(item!=null){
                txtCode.setText(item.getCode());
                txtDes.setText(item.getDescription());
                txtUnit.setText(String.valueOf(item.getUnitPrice()));
                txtQty.setText(String.valueOf(item.getQty()));
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }
            txtFind.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAll() {
        ObservableList observableList = FXCollections.observableArrayList();
        try {
            List<Item> all = itemBo.findAll();
            Iterator<Item> iterator = all.iterator();
            while (iterator.hasNext()){
                Item next = iterator.next();
                observableList.add(new ItemDto(next.getCode(),next.getDescription(),next.getUnitPrice(),next.getQty()));
            }
            tblItem.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblCode.setCellValueFactory(new PropertyValueFactory("code"));
        tblDescription.setCellValueFactory(new PropertyValueFactory("description"));
        tblQty.setCellValueFactory(new PropertyValueFactory("qty"));
        tblUnit.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        loadAll();
        txtCode.requestFocus();
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

    public void getLastId(){
        try {
            String lastId = itemBo.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                txtCode.setText("C00"+newId);
            }else if (newId < 100) {
                txtCode.setText("C0"+newId);
            }else {
                txtCode.setText("C"+newId);
            }
        } catch (Exception e) {
            txtCode.setText("C001");
        }
    }

}
