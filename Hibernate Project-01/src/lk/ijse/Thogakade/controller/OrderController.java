package lk.ijse.Thogakade.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Thogakade.NotificationAlert;
import lk.ijse.Thogakade.business.BoFactory;
import lk.ijse.Thogakade.business.BoType;
import lk.ijse.Thogakade.business.custome.CustomerBo;
import lk.ijse.Thogakade.business.custome.ItemBo;
import lk.ijse.Thogakade.business.custome.OrderBo;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.dto.OrderDetailDto;
import lk.ijse.Thogakade.dto.OrderDto;
import lk.ijse.Thogakade.entity.Customer;
import lk.ijse.Thogakade.entity.Item;
import lk.ijse.Thogakade.view.TM.AddOrderTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    public TableView tblCustomer;

    public TableColumn tblId;
    public TableColumn tblAddress;
    public TableColumn tblName;
    public Label lblId;
    public Label lblName;
    public Label lblAddress;
    public TableView tblItem;
    public TableColumn tblCode;
    public TableColumn tblDescription;
    public TableColumn tblUnit;
    public TableColumn tblQty;
    public Label lblDes;
    public Label lblICOde;
    public Label lblPrice;
    public TextField txtQty;
    public Label lblTot;
    public TableView tblOrder;
    public TableColumn tblOrCode;
    public TableColumn tblOrPrice;
    public TableColumn tblOrQty;
    public TableColumn tblOrTotal;
    public Label lblAllTot;
    public TextField txtPay;
    public Label lblFinalTot;
    public TextField txtOrID;
    public AnchorPane root;
    CustomerBo customerBo;
    ItemBo itemBo;
    OrderBo orderBo;
    private List<ItemDto>itemDtoList=new ArrayList<>();

    public OrderController(){
        customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
        itemBo = BoFactory.getInstance().getBo(BoType.ITEM);
        orderBo=BoFactory.getInstance().getBo(BoType.ORDER);
    }


    public void loadCustomer(){
        ObservableList observableList = FXCollections.observableArrayList();
        try {
            List<Customer> all = customerBo.findAll();
            Iterator<Customer> iterator = all.iterator();
            while (iterator.hasNext()){
                Customer next = iterator.next();
                observableList.add(new CustomerDto(next.getId(),next.getName(),next.getAddress()));
            }
            tblCustomer.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadItem(){
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
        loadCustomer();
        tblId.setCellValueFactory(new PropertyValueFactory("id"));
        tblAddress.setCellValueFactory(new PropertyValueFactory("address"));
        tblName.setCellValueFactory(new PropertyValueFactory("name"));
        loadItem();
        tblCode.setCellValueFactory(new PropertyValueFactory("code"));
        tblDescription.setCellValueFactory(new PropertyValueFactory("description"));
        tblQty.setCellValueFactory(new PropertyValueFactory("qty"));
        tblUnit.setCellValueFactory(new PropertyValueFactory("unitPrice"));

        getLastId();
    }

    public void CustomerClickOnAction(MouseEvent mouseEvent) {
        CustomerDto e = (CustomerDto) tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
        lblId.setText(e.getId());
        lblName.setText(e.getName());
        lblAddress.setText(e.getAddress());
        tblCustomer.setOnKeyReleased(event -> {
            if(event.getCode()== KeyCode.UP ||event.getCode()==KeyCode.DOWN){
                CustomerDto c = (CustomerDto) tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
                lblId.setText(c.getId());
                lblName.setText(c.getName());
                lblAddress.setText(c.getAddress());
            }
        });
    }

    public void ItemTableClickOnAction(MouseEvent mouseEvent) {
        ItemDto e = (ItemDto) tblItem.getItems().get(tblItem.getSelectionModel().getSelectedIndex());
        lblICOde.setText(e.getCode());
        lblDes.setText(e.getDescription());
        lblPrice.setText(String.valueOf(e.getUnitPrice()));

        tblItem.setOnKeyReleased(event -> {
            if(event.getCode()== KeyCode.UP ||event.getCode()==KeyCode.DOWN){
                ItemDto c = (ItemDto) tblItem.getItems().get(tblItem.getSelectionModel().getSelectedIndex());
                lblICOde.setText(c.getCode());
                lblDes.setText(c.getDescription());
                lblPrice.setText(String.valueOf(c.getUnitPrice()));
            }
        });

    }


    public void QTYOnAction(ActionEvent actionEvent) {
        ItemDto i = (ItemDto) tblItem.getItems().get(tblItem.getSelectionModel().getSelectedIndex());
        int qty = i.getQty();
        int newQty= Integer.parseInt(txtQty.getText());
        double total;
        String code = lblICOde.getText();
        String des = lblDes.getText();


        if(qty>=newQty){
            double price = Double.parseDouble(lblPrice.getText());
            total=price*newQty;
            lblTot.setText(String.valueOf(total));

            ItemDto itemDto = new ItemDto(code, des, price, qty);
            itemDtoList.add(itemDto);
            AddOrderTM addOrderTM = new AddOrderTM(code, price, qty, total);

            tblOrder.getItems().add(addOrderTM);
            tblOrCode.setCellValueFactory(new PropertyValueFactory("code"));
            tblOrQty.setCellValueFactory(new PropertyValueFactory("qty"));
            tblOrPrice.setCellValueFactory(new PropertyValueFactory("price"));
            tblOrTotal.setCellValueFactory(new PropertyValueFactory("tot"));


            getValue();
        }else {
            (new Alert(Alert.AlertType.WARNING, "Stock not enough", new ButtonType[0])).showAndWait();
            lblTot.setText("");
        }

    }
    public void getValue(){
        double tot=0;
        int totItem=0;
        for (int i=0;i<tblOrder.getItems().size();i++){
            AddOrderTM tm= (AddOrderTM) tblOrder.getItems().get(i);
            tot+=tm.getTot();
            totItem+=tm.getQty();
        }
        lblAllTot.setText(String.valueOf(tot));
    }

    public void payOnAction(ActionEvent actionEvent) {
        double tot = Double.parseDouble(lblAllTot.getText());
        double pay = Double.parseDouble(txtPay.getText());
        double balance;
        if(pay>=tot){
            balance=pay-tot;
            lblFinalTot.setText(String.valueOf(balance));
        }else{
            (new Alert(Alert.AlertType.WARNING, " Not enough Money", new ButtonType[0])).showAndWait();
        }
    }

    public void PurchaseOrderOnAction(ActionEvent actionEvent) {

        String code="";
        int qty=0;
        int newQty = 0;
        String custId = lblId.getText();
        String name = lblName.getText();
        String address = lblAddress.getText();
        CustomerDto customer = new CustomerDto(custId, name, address);

        String id = txtOrID.getText();
        double pay = Double.parseDouble(txtPay.getText());
        double tot = Double.parseDouble(lblFinalTot.getText());
        OrderDto orderDto = new OrderDto(id,  pay, tot);
        List<OrderDetailDto> orderDetailDtoList=new ArrayList<>();
        for (int i=0;i<tblOrder.getItems().size();i++){
            AddOrderTM addOrderTM  = (AddOrderTM) tblOrder.getItems().get(i);
             code = addOrderTM.getCode();
             qty = addOrderTM.getQty();

            double price = addOrderTM.getPrice();
            boolean add = orderDetailDtoList.add(new OrderDetailDto(id, code, qty, price));


        }
        try {
            boolean placed = orderBo.placeOrder(customer, orderDto, orderDetailDtoList,itemDtoList);
            if(placed){

                NotificationAlert.yesAlert();
                getLastId();
            }else{
                NotificationAlert.warning();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addCustomer(ActionEvent actionEvent) {
        Stage window = (Stage) this.root.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }

    public void addItem(ActionEvent actionEvent) {
        Stage window = (Stage) this.root.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ItemForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }

    public void getLastId(){
        try {
            String lastId = orderBo.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                txtOrID.setText("C00"+newId);
            }else if (newId < 100) {
                txtOrID.setText("C0"+newId);
            }else {
                txtOrID.setText("C"+newId);
            }
        } catch (Exception e) {
            txtOrID.setText("C001");
        }
    }
}
