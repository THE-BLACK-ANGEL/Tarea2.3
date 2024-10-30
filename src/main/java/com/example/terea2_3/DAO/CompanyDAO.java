package com.example.terea2_3.DAO;

import com.example.terea2_3.Modelos.Company;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public static List<Company> buscarCompaniesNombre(String nombre) throws SQLException {

        //Lista que almacenara las compañias que vamos a buscar.
        List<Company> companies = new ArrayList<>();

        //Establecemos conexion con la base de datos que vamos a utilizar
        try (Connection conexion = ConexionBaseDatos.getConnection();
             Statement statement = conexion.createStatement();

             //Realizamos una consulta para conseguir los datos de los registros que nos interese, para mas tarde, asignar estos datos
             //a variables de objetos de tipo Company y añadir de esta forma los distintos registros de la tabla de la base de datos
             //a la lista de tipo Company ("companies") en forma de objetos del mismo tipo que la lista .
             ResultSet resultSet = statement.executeQuery("SELECT id, name, partner_id, currency_id FROM res_company WHERE name LIKE '%" + nombre + "%' ORDER BY id")) {

            //Mientras hayan registros en la tabla a la que accedemos se almacenaran los datos de los registros de la siguiente manera
            //a un objeto temporal de tipo Company para finalmente añadir estos a la lista de tipo Company "companies".
            while (resultSet.next()) {

                //Creamos un objeto tipo Company que mas tarde añadiremos a la lista de este tipo creada anteriormente.
                Company company = new Company();

                //Establecemos el valor de la variable id con el valor de la columna "id" del registro correspondiente de la tabla de la base de datos.
                company.setId(resultSet.getInt("id"));

                //Hacemos lo mismo con las demás columnas de las que nos interesa almacenar el valor en el objeto.
                company.setName(resultSet.getString("name"));
                company.setPartner_id(resultSet.getInt("partner_id"));
                company.setCurrency_id(resultSet.getInt("currency_id"));

                //añadimos el objeto a la lista una vez realizado la asignacion de valores de las variables de este.
                companies.add(company);

                //Imprimimos por consola el valor de la columna "name" de los registros que hemos buscado en la tabla de la base de datos.
                System.out.println(resultSet.getString("name"));
            }
        }

        //Devolvemos por parametro la lista para ser usada en otras clases (En nuestro caso desde controlador/es).
        return companies;
    }


}

