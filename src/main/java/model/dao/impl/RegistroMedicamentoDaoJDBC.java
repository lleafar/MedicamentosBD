package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.ClasseTerapeutica;
import model.dao.entities.RegistroMedicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroMedicamentoDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public RegistroMedicamentoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO registro_medicamento (numero_registro_produto, numero_produto, data_vencimento, principio_ativo) VALUES (?, ?, ?, ?)";
        PreparedStatement st = null;
        RegistroMedicamento rm = (RegistroMedicamento) obj;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setLong(1,rm.getNumero_registro_produto());
            st.setInt(2, rm.getNumero_produto());
            st.setString(3, rm.getData_vencimento());
            st.setString(4, rm.getPrincipio_ativo());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
