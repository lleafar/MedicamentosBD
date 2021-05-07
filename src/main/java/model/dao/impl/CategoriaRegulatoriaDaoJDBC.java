package model.dao.impl;

import db.DB;
import model.dao.MedicamentosDao;
import model.dao.entities.CategoriaRegulatoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaRegulatoriaDaoJDBC implements MedicamentosDao {
    private Connection conn;

    public CategoriaRegulatoriaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Object obj) {
        String sql = "INSERT INTO categoria_regulatoria (numero_categoria_regulatoria, desc_categoria) VALUES (?, ?)";
        PreparedStatement st = null;
        CategoriaRegulatoria cr =  (CategoriaRegulatoria) obj;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);

            st.setInt(1,cr.getNumero_categoria_regulatoria());
            st.setString(2, cr.getDesc_categoria());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}



