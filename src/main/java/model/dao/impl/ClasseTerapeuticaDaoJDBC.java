package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.ClasseTerapeutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClasseTerapeuticaDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public ClasseTerapeuticaDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO classe_terapeutica (numero_classe_terapeutica, classe_terapeutica) VALUES (?, ?)";
        PreparedStatement st = null;
        ClasseTerapeutica ct = (ClasseTerapeutica) obj;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setInt(1,ct.getNumero_classe_terapeutica());
            st.setString(2, ct.getClasse_terapeutica());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
