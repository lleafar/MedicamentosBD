package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.EmpresaDetentora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpresaDetentoraDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public EmpresaDetentoraDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO empresa_detentora (cnpj_detentora, razao_social_detentora) VALUES (?, ?)";
        PreparedStatement st = null;
        EmpresaDetentora ed = (EmpresaDetentora) obj;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setLong(1,ed.getCnpj_detentora());
            st.setString(2, ed.getRazao_social_detentora());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
