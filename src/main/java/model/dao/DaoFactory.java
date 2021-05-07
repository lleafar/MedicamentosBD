package model.dao;

import db.DB;
import model.dao.entities.EmpresaDetentora;
import model.dao.impl.*;

public class DaoFactory {
    public static CategoriaRegulatoriaDaoJDBC createCRD(){
        return new CategoriaRegulatoriaDaoJDBC(DB.getConnection());
    }


    public static ClasseTerapeuticaDaoJDBC createCTD(){
        return new ClasseTerapeuticaDaoJDBC(DB.getConnection());
    }


    public static EmpresaDetentoraDaoJDBC createEDD(){
        return new EmpresaDetentoraDaoJDBC(DB.getConnection());
    }

    public static ProdutoDaoJDBC createPD(){
        return new ProdutoDaoJDBC(DB.getConnection());
    }

    public static RegistroMedicamentoDaoJDBC createRMD(){
        return new RegistroMedicamentoDaoJDBC(DB.getConnection());
    }

    public static RegistroMedicamentoProcessoDaoJDBC createRMDP(){
        return new RegistroMedicamentoProcessoDaoJDBC(DB.getConnection());
    }

    public static TipoProdutoDaoJDBC createTPD(){
        return new TipoProdutoDaoJDBC(DB.getConnection());
    }

}
