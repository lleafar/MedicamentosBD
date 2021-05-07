package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.TipoProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoProdutoDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public TipoProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO tipo_produto (numero_tipo_produto, tipo_produto) VALUES (?, ?)";
        PreparedStatement st = null;
        TipoProduto tp =  (TipoProduto) obj;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setInt(1,tp.getNumero_tipo_produto());
            st.setString(2, tp.getTipo_produto());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
