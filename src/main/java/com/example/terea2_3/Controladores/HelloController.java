package com.example.terea2_3.Controladores;

import com.example.terea2_3.DAO.ConexionBaseDatos;
import com.example.terea2_3.Modelos.company;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import javax.swing.*;

public class HelloController {
    @FXML
    private Button botonAnadir,botonBorrar,botonEditar,botonBuscar;
    @FXML
    private TableView tablaDatos ;
    @FXML
    private ConexionBaseDatos conexion;

    //Constructor del controlador
    public HelloController() {
        this.conexion = new ConexionBaseDatos();
    }

    public void crearEmpleado(company empleado) {
        // Código para crear un empleado en la base de datos
    }

    public company leerCompany(int id) {
        // Código para leer un empleado de la base de datos
        return null;
    }

    public void actualizarCompany(company empleado) {
        // Código para actualizar un empleado en la base de datos

    }

    public void eliminarCompany(int id) {
        // Código para eliminar un empleado de la base de datos
    }


}