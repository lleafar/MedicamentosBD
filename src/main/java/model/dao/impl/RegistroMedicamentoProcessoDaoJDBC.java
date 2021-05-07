package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.RegistroMedicamentoProcesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroMedicamentoProcessoDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public RegistroMedicamentoProcessoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO registro_medicamento_processo (numero_registro_produto, numero_processo, data_finalizacao_processo, numero_categoria_regulatoria, cnpj_detentora) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        RegistroMedicamentoProcesso rmp = (RegistroMedicamentoProcesso) obj;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setLong(1,rmp.getNumero_registro_produto());
            st.setLong(2, rmp.getNumero_processo());
            st.setString(3, rmp.getData_finalizacao_processo());
            st.setInt(4, rmp.getNumero_categoria_regulatoria());
            st.setLong(5, rmp.getCnpj_detentora());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
