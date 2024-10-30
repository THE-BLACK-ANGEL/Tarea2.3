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
    private TableColumn<Company, String> tcID;
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

        //Inicializamos los valores de las columnas de la tabla asignando a cada columna los valores de los registros
        //que se han almacenado en las variables de los objetos de la clase Company.
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcPropietario.setCellValueFactory(new PropertyValueFactory<>("partner_id"));
        tcMoneda.setCellValueFactory(new PropertyValueFactory<>("currency_id"));

    /*
        //CARGAR DATOS DESDE EL INICIO DEL PROGRAMA DE LA BASE DE DATOS

        List<Company> companies = CompanyDAO.buscarCompaniesNombre("");
        ObservableList<Company> datos = FXCollections.observableList(companies);
        tvDatos.setItems(datos);

     */
    }


    @FXML
    public void onBtnBuscar(ActionEvent actionEvent) {
        try {
            /*Declaramos una lista que almacenara objetos de tipo Company obtenidos a partir de la lectura y recogida de la informacion de los registros de
              la tabla res_company gracias al metodo de la clase CompanyDAO (interfaz que hace de intermedaria entre la base de datos de odoo y el controlador
              de la aplicacion) de buscar companies por el nombre
            * */
            List<Company> companies = CompanyDAO.buscarCompaniesNombre(tfNombre.getText());
            //Permitimos que se puedan ver los datos la lista companies y que esta refleje los cambios que se realizen de forma automatica
            ObservableList<Company> datos = FXCollections.observableArrayList(companies);
            //Lo siguiente que haremos es decirle a la tabla que muestre los datos de la lista
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