package com.example.terea2_3.Controladores;

import com.example.terea2_3.Modelos.Company;
import com.example.terea2_3.DAO.CompanyDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.util.List;

public class HelloController {

    @FXML
    private TableColumn<Company, String> tcName;
    @FXML
    private TableColumn<Company,Integer> tcID;
    @FXML
    private TableColumn<Company,Integer> tcPropietario;
    @FXML
    private TableColumn<Company, Integer> tcMoneda;

    @FXML
    private TableView<Company> tvDatos;

    @FXML
    private TextField tfNombre;

    @FXML
    private Button btAnadir;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnBuscar;

    public void initialize() throws SQLException {
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcPropietario.setCellValueFactory(new PropertyValueFactory<>("partner_id"));
        tcMoneda.setCellValueFactory(new PropertyValueFactory<>("currency_id"));
        tvDatos.setItems(FXCollections.observableArrayList());
    }


    @FXML
    public void onBtnBuscar(ActionEvent actionEvent) {
        try {
            List<Company> companies = CompanyDAO.buscarCompaniesNombre(tfNombre.getText());
            ObservableList<Company> datos = FXCollections.observableArrayList(companies);
            tvDatos.setItems(datos);
        } catch (SQLException e) {
            System.err.println("Error de SQL al consultar: " + e.getMessage());
            showAlert("Error", "Error de SQL al consultar: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error de SQL al consultar: " + e.getMessage());
        }
    }
//Alertas del programa
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}