package com.example.terea2_3.DAO;

import com.example.terea2_3.Modelos.Company;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public static List<Company> obtenerCompanies() throws SQLException {
        List<Company> companies = new ArrayList<>();

        try (Connection conexion = ConexionBaseDatos.getConnection();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM res_company ORDER BY name ")) {

            while (resultSet.next()) {
                Company company = new Company();
                company.setName(resultSet.getString("name"));
                company.setId(resultSet.getInt("id"));
                company.setIdSocio(resultSet.getInt("partner_id"));
                company.setIdMoneda(resultSet.getInt("currency_id"));

                companies.add(company);
                System.out.println(resultSet.getString("name"));
            }
        }

        return companies;
    }


    public static List<Company> buscarCompaniesNombre(String nombre) throws SQLException {
        List<Company> companies = new ArrayList<>();
        String sentencia = "SELECT name " +
                "FROM res_company " +
                "WHERE name LIKE  '%" + nombre + "'";

        try (Connection conexion = ConexionBaseDatos.getConnection();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sentencia)) {

            while (resultSet.next()) {
                Company company = new Company();
                company.setName(resultSet.getString("name"));
                companies.add(company);
                System.out.println(resultSet.getString("name"));
            }
        }

        return companies;
    }



}

