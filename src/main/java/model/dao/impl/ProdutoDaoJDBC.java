package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO produto (numero_produto, nome_produto, numero_classe_terapeutica, numero_tipo_produto) VALUES (?, ?, ?, ?)";
        PreparedStatement st = null;
        Produto p = (Produto) obj;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setInt(1,p.getNumero_produto());
            st.setString(2, p.getNome_produto());
            st.setInt(3, p.getNumero_classe_terapeutica());
            st.setInt(4, p.getNumero_tipo_produto());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
