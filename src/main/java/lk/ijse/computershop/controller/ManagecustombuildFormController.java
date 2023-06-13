package lk.ijse.computershop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.computershop.bo.BoFactory;
import lk.ijse.computershop.bo.custom.BuildBO;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.*;
import lk.ijse.computershop.dto.tm.CustombuildsTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ManagecustombuildFormController implements Initializable {

    @FXML
    private TextField txtBuildCode;
    @FXML
    private TextField txtBuildDate;
    @FXML
    private ComboBox<String> cmbCustomerId;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private ComboBox<String> cmbEmployeeId;
    @FXML
    private TextField txtEmployeeName;
    @FXML
    private ComboBox<String> cmbItemCode;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtQtyOnHand;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtNetTotal;
    @FXML
    private TableView tblCustomBuild;
    @FXML
    private TableColumn colCode;
    @FXML
    private TableColumn colDescription;
    @FXML
    private TableColumn colQty;
    @FXML
    private TableColumn colUnitPrice;
    @FXML
    private TableColumn colTotal;
    @FXML
    private TableColumn colUpdate;
    @FXML
    private TableColumn colRemove;

    private BuildBO buildBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.BUILD);

    private ObservableList<CustombuildsTM> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setBuildDate();
        setCellValueFactory();
        generateNextBuildCode();
        loadCustomerIds();
        loadEmployeeIds();
        loadItemCodes();
    }

    private void setCellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("update"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));
    }

    private void setBuildDate() {
        txtBuildDate.setText(String.valueOf(LocalDate.now()));
    }

    private void generateNextBuildCode() {
        try {
            String code = buildBO.generateNextBuildCode();
            txtBuildCode.setText(code);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            List<String> customerId = buildBO.loadCustomerIds();

            for (String id : customerId) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    private void loadEmployeeIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            List<String> employeeId = buildBO.loadEmployeeIds();

            for (String id : employeeId) {
                observableList.add(id);
            }
            cmbEmployeeId.setItems(observableList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    private void loadItemCodes() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            List<String> itemCode = buildBO.loadItemCodes();

            for (String code : itemCode) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    @FXML
    private void cmbCustomerIdOnAction(ActionEvent event) {
        String customerId = cmbCustomerId.getValue();
        cmbCustomerId.setDisable(true);

        try {
            CustomerDTO customerDTO = buildBO.searchByCustomerId(customerId);
            txtCustomerName.setText(customerDTO.getName());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    @FXML
    private void cmbEmployeeIdOnAction(ActionEvent event) {
        String employeeId = cmbEmployeeId.getValue();
        cmbEmployeeId.setDisable(true);

        try {
            EmployeeDTO employeeDTO = buildBO.searchByEmployeeId(employeeId);
            txtEmployeeName.setText(employeeDTO.getName());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    @FXML
    private void cmbItemCodeOnAction(ActionEvent event) {
        String itemCode = cmbItemCode.getValue();

        try {
            ItemDTO itemDTO = buildBO.searchByItemCodes(itemCode);
            fillItemFields(itemDTO);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    private void fillItemFields(ItemDTO itemDTO) {
        txtDescription.setText(itemDTO.getDescription());
        txtUnitPrice.setText(String.valueOf(itemDTO.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(itemDTO.getQtyOnHand()));
    }

    @FXML
    private void addToCartOnAction(ActionEvent event) {
        try {
            String code = cmbItemCode.getValue();
            String description = txtDescription.getText();
            int qty = Integer.parseInt(txtQty.getText());
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());

            double total = qty * unitPrice;

            Button btnUpdate = new Button("Update");
            btnUpdate.setCursor(Cursor.HAND);
            setUpdateBtnOnAction(btnUpdate);

            Button btnRemove = new Button("Remove");
            btnRemove.setCursor(Cursor.HAND);
            setRemoveBtnOnAction(btnRemove);

            if (!observableList.isEmpty()) {
                for (int i = 0; i < tblCustomBuild.getItems().size(); i++) {
                    if (colCode.getCellData(i).equals(code)) {
                        qty += (int) colQty.getCellData(i);
                        total = qty * unitPrice;

                        observableList.get(i).setQty(qty);
                        observableList.get(i).setTotal(total);

                        tblCustomBuild.refresh();
                        calculateNetTotal();
                        return;
                    }
                }
            }

            CustombuildsTM tm = new CustombuildsTM(code, description, qty, unitPrice, total, btnUpdate, btnRemove);
            observableList.add(tm);
            tblCustomBuild.setItems(observableList);
            calculateNetTotal();

            //txtQty.clear();
            txtQty.requestFocus();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "please try again...!").show();
        }
    }

    private void setUpdateBtnOnAction(Button update) {
        update.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to update?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                int index = tblCustomBuild.getSelectionModel().getSelectedIndex();
                observableList.remove(index + 1);

                tblCustomBuild.refresh();
                calculateNetTotal();
            }

        });
    }

    private void setRemoveBtnOnAction(Button remove) {
        remove.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                int index = tblCustomBuild.getSelectionModel().getSelectedIndex();
                observableList.remove(index + 1);

                tblCustomBuild.refresh();
                calculateNetTotal();
            }

        });
    }

    private void calculateNetTotal() {
        double netTotal = 0.0;
        for (int i = 0; i < tblCustomBuild.getItems().size(); i++) {
            double total = (double) colTotal.getCellData(i);
            netTotal += total;
        }
        txtNetTotal.setText(String.valueOf(netTotal));
    }

    private void printBills() throws JRException, SQLException {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Do you want a quotation?", yes, no).showAndWait();

        if (buttonType.orElse(yes) == yes) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("CustomBuild", "CustomBuild");
            InputStream resource = this.getClass().getResourceAsStream("/reports/customBuild.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        }
    }

    private void makeBuildReset() {
        txtCustomerName.clear();
        txtEmployeeName.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQty.clear();
        txtNetTotal.clear();
        tblCustomBuild.getItems().clear();
    }

    @FXML
    private void makeBuildOnAction(ActionEvent events) throws SQLException {
        String buildCode = txtBuildCode.getText();
        String customerId = cmbCustomerId.getValue();
        String employeeId = cmbEmployeeId.getValue();
        String itemCode = cmbItemCode.getValue();
        int qty = Integer.parseInt(txtQty.getText());
        double total = Double.parseDouble(txtNetTotal.getText());

        List<Build_DetailsDTO> buildDetailsDTOList = new ArrayList<>();
        buildDetailsDTOList.add(new Build_DetailsDTO(buildCode,itemCode,qty,total,LocalDate.now()));

        Boolean isPlaced = buildBO.makeBuild(new BuildDTO(buildCode, customerId, employeeId, buildDetailsDTOList));
        if (isPlaced) {
            Alert makeBuildAlert = new Alert(Alert.AlertType.INFORMATION, "your build is in progress...!");
            makeBuildAlert.show();
            //EmailSend.mail("Your Build is in Progress...!");

            makeBuildAlert.setOnHidden(event -> {
                try {
                    printBills();
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, "please try again...!").show();
                }
            });

        } else {
            new Alert(Alert.AlertType.ERROR, "your build is not in progress...!").show();
        }
        makeBuildReset();
        generateNextBuildCode();
    }
}
